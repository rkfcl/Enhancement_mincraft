package weaponenhancement.weaponenhancement;

import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

import static weaponenhancement.weaponenhancement.EnhancementInventory.*;

public class EnhancementButton implements Listener {
    private final Weaponenhancement plugin;
    EnhancementInventory inventory;
    private final int[] PANE_SLOTS = {38, 37, 28, 20, 19, 18, 9, 0, 1, 2, 11, 12, 13};
    private final int[] PANE_SLOTS2 = {14, 15, 6, 7, 8, 17, 26, 25, 24};
    public EnhancementButton(Weaponenhancement plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ShopMenuInventory(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();
        ClickType clickType = event.getClick();

        if (clickedInventory == null) return;

        // 메뉴 상점
        if (event.getView().getTitle().equalsIgnoreCase("강화")) {
            Inventory enhancementInventory = event.getView().getTopInventory();
            ItemStack targetSlotItem = enhancementInventory.getItem(10);
            ItemStack targetSlotItem2 = enhancementInventory.getItem(39);
            ItemStack targetSlotItem3 = enhancementInventory.getItem(16);
            event.setCancelled(true); // 이벤트 취소하여 아이템을 메뉴로 옮기지 못하도록 함
            CustomStack stack = CustomStack.getInstance("enhancement_scroll");
            ItemStack enhancement_scroll = stack.getItemStack();

            if (clickedInventory.getType() == InventoryType.PLAYER) {
                // 클릭한 인벤토리가 플레이어 인벤토리인 경우
                event.setCancelled(true); // 이벤트 취소하여 아이템을 옮기지 못하도록 함
            }
            if (event.getSlot() == 43){
                if (targetSlotItem != null && targetSlotItem2 != null){
                    // 클릭 소리 재생
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
                    player.playSound(player.getLocation(), "minecraft:block.note_block.harp", SoundCategory.MASTER, 1.0f, 2.0f);
                    enhancementInventory.setItem(39, null);
                    enhancementInventory.setItem(32, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(41, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(48, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(50, InvenDecoWHITE_STAINED_GLASS_PANE());
                    //순치적으로 바뀜
                    enhancementInventory.setItem(38, InvenDecoBLACK_STAINED_GLASS_PANE());
                    new BukkitRunnable() {
                        int slot =0;
                        private long delay = 3L;
                        private long currentTick = 0L;
                        @Override
                        public void run() {
                            if (currentTick % delay == 0) {
                                // 아이템을 한 슬롯씩 이동시킴
                                if (slot>10) {
                                    enhancementInventory.setItem(PANE_SLOTS[slot], InvenDecoGREEN_STAINED_GLASS_PANE());
                                }else {
                                    enhancementInventory.setItem(PANE_SLOTS[slot], InvenDecoBLACK_STAINED_GLASS_PANE());
                                }
                                if (delay == 3L) {
                                    player.playSound(player.getLocation(), "minecraft:block.note_block.harp", SoundCategory.MASTER, 1.0f, 0.5f);
                                }else if (delay == 1L) {
                                    player.playSound(player.getLocation(), "minecraft:block.note_block.pling", SoundCategory.MASTER, 1.0f, 2.0f);
                                }else if (delay == 4L) {
                                    player.playSound(player.getLocation(), "minecraft:block.note_block.pling", SoundCategory.MASTER, 1.0f, 2.0f);
                                }
                                slot++;
                            }
                            if (slot==3) {
                                delay = 1L;
                            }else if (slot==11) {
                                delay = 4L;
                            }
                            currentTick++;
                            if (slot >= PANE_SLOTS.length) {
                                for (int i = 0; i < PANE_SLOTS2.length; i++) {
                                    enhancementInventory.setItem(PANE_SLOTS2[i], InvenDecoSuccess_STAINED_GLASS_PANE());
                                }
                                ItemMeta itemMeta1 = targetSlotItem.getItemMeta();
                                // 기존 공격력 가져오기
                                double baseDamage = 0.0;
                                if (itemMeta1 != null && itemMeta1.hasAttributeModifiers()) {
                                    Collection<AttributeModifier> modifiers1 = itemMeta1.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE);
                                    player.sendMessage(modifiers1.toString());
                                    if (modifiers1 != null) {
                                        for (AttributeModifier modifier : modifiers1) {
                                            if (modifier.getOperation() == AttributeModifier.Operation.ADD_NUMBER) {
                                                baseDamage = modifier.getAmount();
                                                break;
                                            }
                                        }
                                    }
                                }
                                // 공격력 증가를 위한 상수 값을 설정 (원하는 만큼 수정 가능)
                                double increaseAmount = 0.5;
                                String originalName=null;
                                // 공격력을 증가시키는 로직
                                double newDamage = baseDamage + increaseAmount;
                                if (newDamage<4){
                                    if (targetSlotItem.getType()==Material.WOODEN_SWORD){
                                        newDamage=4.5;
                                    }
                                    if (targetSlotItem.getType()==Material.STONE_SWORD){
                                        newDamage=5.5;
                                    }
                                    if (targetSlotItem.getType()==Material.GOLDEN_SWORD){
                                        newDamage=4.5;
                                    }
                                    if (targetSlotItem.getType()==Material.IRON_SWORD){
                                        newDamage=6.5;
                                    }
                                    if (targetSlotItem.getType()==Material.DIAMOND_SWORD){
                                        newDamage=7.5;
                                    }
                                    if (targetSlotItem.getType()==Material.NETHERITE_SWORD){
                                        newDamage=8.5;
                                    }
                                }
                                // 별모양 추가
                                List<String> lore = itemMeta1.getLore();
                                lore.add("§e★");
                                itemMeta1.setLore(lore);
                                // 강화된 아이템의 이름 설정
                                // targetSlotItem의 ItemMeta를 수정하여 공격력을 갱신
                                if (itemMeta1 != null) {
                                    AttributeModifier newModifier = new AttributeModifier(UUID.randomUUID(), "weapon_damage", newDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                    itemMeta1.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
                                    itemMeta1.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, newModifier);
                                    targetSlotItem.setItemMeta(itemMeta1);
                                }
                                enhancementInventory.setItem(10, null);
                                enhancementInventory.setItem(16, targetSlotItem);
                                cancel();
                            }

                        }
                    }.runTaskTimer(plugin, 1L, 4L);
                }
            }
            if (event.getSlot() == 16){
                ItemStack itemInSlot16 = event.getCurrentItem();
                player.getInventory().addItem(itemInSlot16);
                player.closeInventory();
            }
        }
    }
//    private String Name(String name){
//        switch (name){
//            case "WOODEN_SWORD":
//                name="나무 검§e ";
//                break;
//            case "STONE_SWORD":
//                name="돌 검§e ";
//                break;
//            case "GOLDEN_SWORD":
//                name="금 검§e ";
//                break;
//            case "IRON_SWORD":
//                name="철 검§e ";
//                break;
//            case "DIAMOND_SWORD":
//                name="다이아몬드 검§e ";
//                break;
//            case "NETHERITE_SWORD":
//                name="네더라이트 검§e ";
//                break;
//            default:
//                break;
//        }
//        return  name;
//    }
}
