package weaponenhancement.weaponenhancement;

import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.UUID;

public final class Weaponenhancement extends JavaPlugin implements Listener {
    EnhancementInventory enhancementInventory= new EnhancementInventory();
    EnhancementButton enhancementButton = new EnhancementButton(this);

    @Override
    public void onEnable() {
        getLogger().info("Weaponenhancement 플러그인 실행");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(enhancementButton, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onBlockPlace(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return; // 우클릭한 블럭이 아닌 경우 무시합니다.
        }
        Block clickedBlock = event.getClickedBlock();
        CustomBlock custom = CustomBlock.getInstance("enhancement_anvil");

        if (clickedBlock != null && clickedBlock.getBlockData().equals(custom.getBaseBlockData())) {
            enhancementInventory.openEnhancementInventory(player);
        }

    }
    @EventHandler
    public void ShopMenuInventory(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();
        ClickType clickType = event.getClick();

        if (clickedInventory == null) return;

        // 메뉴 상점
        if (event.getView().getTitle().equalsIgnoreCase("강화")) {
            event.setCancelled(true); // 이벤트 취소하여 아이템을 메뉴로 옮기지 못하도록 함
            CustomStack stack = CustomStack.getInstance("enhancement_scroll");
            ItemStack enhancement_scroll = stack.getItemStack();

            if (clickedInventory.getType() == InventoryType.PLAYER) {
                // 클릭한 인벤토리가 플레이어 인벤토리인 경우
                event.setCancelled(true); // 이벤트 취소하여 아이템을 옮기지 못하도록 함

                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && isEquip(clickedItem.getType())) {
                    // 검 아이템을 강화 인벤토리의 10번 슬롯으로 이동
                    Inventory enhancementInventory = event.getView().getTopInventory();
                    ItemStack targetSlotItem = enhancementInventory.getItem(10);

                    if (targetSlotItem == null) {
                        enhancementInventory.setItem(10, clickedItem);
                        event.setCurrentItem(null);
                    }
                } else if (clickedItem != null && clickedItem.getItemMeta().equals(enhancement_scroll.getItemMeta())) {
                    // 강화권 아이템을 강화 인벤토리의 10번 슬롯으로 이동
                    Inventory enhancementInventory = event.getView().getTopInventory();
                    ItemStack targetSlotItem = enhancementInventory.getItem(10);
                    ItemStack targetSlotItem2 = enhancementInventory.getItem(39);

                    if (targetSlotItem != null && targetSlotItem2 == null) {
                        if (clickedItem.getAmount() > 1) {
                            clickedItem.setAmount(clickedItem.getAmount() - 1);
                            player.sendMessage("§5[ 강화 ] §f강화권을 추가하였습니다.");
                            enhancementInventory.setItem(39, enhancement_scroll);
                        } else {
                            clickedItem.setAmount(clickedItem.getAmount() - 1);
                            player.sendMessage("§5[ 강화 ] §f강화권을 추가하였습니다.");
                            enhancementInventory.setItem(39, enhancement_scroll);
                        }
                    } else if(targetSlotItem2 != null){

                    }else{
                        player.sendMessage("§5[ 강화 ] §f강화할 아이템이 올려져 있지 않습니다.");
                    }
                }
            }
        }
    }

//    @EventHandler
//    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
//        Entity damager = event.getDamager();
//        Entity damaged = event.getEntity();
//
//        if (damager instanceof Player) {
//            Player player = (Player) damager;
//            double damage = event.getDamage();
//
//            // 플레이어가 가하는 데미지 출력
//            System.out.println(player.getName() + "이(가) " + damaged.getName() + "에게 " + damage + "의 데미지를 가했습니다.");
//        }
//    }
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getPlayer();

        if (inventory.getType() == InventoryType.CHEST && event.getView().getTitle().equalsIgnoreCase("강화")) {
            ItemStack itemInSlot10 = inventory.getItem(10);
            ItemStack itemInSlot39 = inventory.getItem(39);

            if (itemInSlot10 != null) {
                if (isInventoryFull(player.getInventory())) {
                    player.getWorld().dropItem(player.getLocation(), itemInSlot10);
                } else {
                    player.getInventory().addItem(itemInSlot10);
                }
                inventory.setItem(10, null);
            }

            if (itemInSlot39 != null) {
                if (isInventoryFull(player.getInventory())) {
                    player.getWorld().dropItem(player.getLocation(), itemInSlot39);
                } else {
                    player.getInventory().addItem(itemInSlot39);
                }
                inventory.setItem(39, null);
            }
        }
    }

    // 인벤토리가 꽉 찼는지 확인하는 유틸리티 메소드
    private boolean isInventoryFull(Inventory inventory) {
        for (ItemStack item : inventory.getStorageContents()) {
            if (item == null || item.getType() == Material.AIR) {
                return false;
            }
        }
        return true;
    }



    // 검 아이템인지 확인하는 유틸리티 메소드
    private boolean isEquip(Material material) {
        return material == Material.WOODEN_SWORD ||
                material == Material.STONE_SWORD ||
                material == Material.IRON_SWORD ||
                material == Material.GOLDEN_SWORD ||
                material == Material.DIAMOND_SWORD ||
                material == Material.NETHERITE_SWORD ||

                material == Material.LEATHER_HELMET ||
                material == Material.CHAINMAIL_HELMET ||
                material == Material.IRON_HELMET ||
                material == Material.GOLDEN_HELMET ||
                material == Material.DIAMOND_HELMET ||
                material == Material.NETHERITE_HELMET ||

                material == Material.LEATHER_CHESTPLATE ||
                material == Material.CHAINMAIL_CHESTPLATE ||
                material == Material.IRON_CHESTPLATE ||
                material == Material.GOLDEN_CHESTPLATE ||
                material == Material.NETHERITE_CHESTPLATE ||
                material == Material.DIAMOND_CHESTPLATE ||

                material == Material.LEATHER_LEGGINGS ||
                material == Material.CHAINMAIL_LEGGINGS ||
                material == Material.IRON_LEGGINGS ||
                material == Material.GOLDEN_LEGGINGS ||
                material == Material.DIAMOND_LEGGINGS ||
                material == Material.NETHERITE_LEGGINGS ||

                material == Material.LEATHER_BOOTS ||
                material == Material.CHAINMAIL_BOOTS ||
                material == Material.IRON_BOOTS ||
                material == Material.GOLDEN_BOOTS ||
                material == Material.DIAMOND_BOOTS ||
                material == Material.NETHERITE_BOOTS;
    }



//    @EventHandler
//    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
//        Entity damager = event.getDamager();
//        Entity damaged = event.getEntity();
//
//        if (damaged instanceof Player) {
//            Player player = (Player) damaged;
//            double damage = event.getFinalDamage();
//
//            // 플레이어가 입는 데미지 출력
//            player.sendMessage("플레이어가 입는 데미지: " + damage);
//
//            // 콘솔에 데미지 출력
//            Bukkit.getLogger().info(player.getName() + "이(가) " + damage + "의 데미지를 입었습니다.");
//        }
//    }


}
