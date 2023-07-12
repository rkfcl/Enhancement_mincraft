package weaponenhancement.weaponenhancement;

import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.EntityType;
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

        //  강화
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
            if (event.getSlot() == 43) {
                if (targetSlotItem != null && targetSlotItem2 != null) {
                    ItemMeta itemMeta1 = targetSlotItem.getItemMeta();
                    if (itemMeta1.hasLore()) {
                        List<String> lore = itemMeta1.getLore();
                        String firstLine = null;
                        if (!lore.isEmpty()) {
                            firstLine = lore.get(0);
                        }
                        int starCount = 0;
                        if (firstLine != null) {
                            starCount = (int) firstLine.chars().filter(ch -> ch == '★').count();
                        }
                        // 별 개수가 10개 이상이면 강화를 중지합니다.
                        if (starCount >= 10) {
                            player.sendMessage("아이템은 이미 완전히 강화되었습니다.");
                            return;
                        }
                    }

                    // 클릭 소리 재생
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
                    player.playSound(player.getLocation(), "minecraft:block.note_block.harp", SoundCategory.MASTER, 1.0f, 2.0f);
                    enhancementInventory.setItem(39, null);
                    enhancementInventory.setItem(32, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(41, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(48, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(50, InvenDecoWHITE_STAINED_GLASS_PANE());
                    // 순서적으로 바뀜
                    enhancementInventory.setItem(38, InvenDecoBLACK_STAINED_GLASS_PANE());
                    new BukkitRunnable() {
                        int slot = 0;
                        private long delay = 3L;
                        private long currentTick = 0L;

                        @Override
                        public void run() {
                            ItemMeta itemMeta1 = targetSlotItem.getItemMeta();
                            int starCount = 0;
                            if (itemMeta1.hasLore()) {
                                List<String> lore = itemMeta1.getLore();
                                String firstLine = null;
                                if (!lore.isEmpty()) {
                                    firstLine = lore.get(0);
                                }

                                if (firstLine != null) {
                                    starCount = (int) firstLine.chars().filter(ch -> ch == '★').count();
                                }

                            }
                            if (currentTick % delay == 0) {
                                // 아이템을 한 슬롯씩 이동시킴
                                if (slot > 10) {
                                    enhancementInventory.setItem(PANE_SLOTS[slot], InvenDecoGREEN_STAINED_GLASS_PANE());
                                } else {
                                    enhancementInventory.setItem(PANE_SLOTS[slot], InvenDecoBLACK_STAINED_GLASS_PANE());
                                }
                                if (delay == 3L) {
                                    player.playSound(player.getLocation(), "minecraft:block.note_block.harp", SoundCategory.MASTER, 1.0f, 0.5f);
                                } else if (delay == 1L) {
                                    player.playSound(player.getLocation(), "minecraft:block.note_block.pling", SoundCategory.MASTER, 1.0f, 2.0f);
                                } else if (delay == 4L) {
                                    player.playSound(player.getLocation(), "minecraft:block.note_block.pling", SoundCategory.MASTER, 1.0f, 2.0f);
                                }
                                slot++;
                            }
                            if (slot == 3) {
                                delay = 1L;
                            } else if (slot == 11) {
                                delay = 4L;
                            }
                            currentTick++;
                            if (slot >= PANE_SLOTS.length) {
                                // 확률 계산
                                double successChance;
                                double failChance;
                                double destroyChance;
                                if (starCount == 0) {
                                    successChance = 0.9;
                                    failChance = 0.1;
                                    destroyChance = 0.0;
                                } else if (starCount == 1) {
                                    successChance = 0.85;
                                    failChance = 0.15;
                                    destroyChance = 0.0;
                                } else if (starCount == 2) {
                                    successChance = 0.75;
                                    failChance = 0.25;
                                    destroyChance = 0.0;
                                } else if (starCount == 3) {
                                    successChance = 0.65;
                                    failChance = 0.35;
                                    destroyChance = 0.0;
                                } else if (starCount == 4) {
                                    successChance = 0.55;
                                    failChance = 0.45;
                                    destroyChance = 0.0;
                                } else if (starCount == 5) {
                                    successChance = 0.45;
                                    failChance = 0.55;
                                    destroyChance = 0.0;
                                } else if (starCount == 6) {
                                    successChance = 0.35;
                                    failChance = 0.65;
                                    destroyChance = 0.1;
                                } else if (starCount == 7) {
                                    successChance = 0.3;
                                    failChance = 0.67;
                                    destroyChance = 0.03;
                                } else if (starCount == 8) {
                                    successChance = 0.2;
                                    failChance = 0.73;
                                    destroyChance = 0.07;
                                } else if (starCount == 9) {
                                    successChance = 0.03;
                                    failChance = 0.77;
                                    destroyChance = 0.2;
                                } else {
                                    successChance = 0.0;
                                    failChance = 0.0;
                                    destroyChance = 0.0;
                                }

                                // 강화 결과 계산
                                double randomNum = Math.random();
                                if (randomNum < successChance) {
                                    // 성공
                                    for (int i = 0; i < PANE_SLOTS2.length; i++) {
                                        enhancementInventory.setItem(PANE_SLOTS2[i], InvenDecoSuccess_STAINED_GLASS_PANE());
                                    }
                                    // 공격력 증가 로직 추가
                                    double baseDamage = 0.0;
                                    if (itemMeta1 != null && itemMeta1.hasAttributeModifiers()) {
                                        Collection<AttributeModifier> modifiers1 = itemMeta1.getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE);
                                        if (modifiers1 != null) {
                                            for (AttributeModifier modifier : modifiers1) {
                                                if (modifier.getOperation() == AttributeModifier.Operation.ADD_NUMBER) {
                                                    baseDamage = modifier.getAmount();
                                                    break;
                                                }
                                            }
                                        }
                                    }

                                    double increaseAmount = 0.5;
                                    double newDamage = baseDamage + increaseAmount;
                                    if (newDamage < 4) {
                                        // 원하는 값으로 수정 가능
                                        if (targetSlotItem.getType() == Material.WOODEN_SWORD) {
                                            newDamage = 4.5;
                                        }
                                        if (targetSlotItem.getType() == Material.STONE_SWORD) {
                                            newDamage = 5.5;
                                        }
                                        if (targetSlotItem.getType() == Material.GOLDEN_SWORD) {
                                            newDamage = 4.5;
                                        }
                                        if (targetSlotItem.getType() == Material.IRON_SWORD) {
                                            newDamage = 6.5;
                                        }
                                        if (targetSlotItem.getType() == Material.DIAMOND_SWORD) {
                                            newDamage = 7.5;
                                        }
                                        if (targetSlotItem.getType() == Material.NETHERITE_SWORD) {
                                            newDamage = 8.5;
                                        }
                                    }

                                    List<String> lore = itemMeta1.getLore();
                                    if (lore == null) {
                                        lore = new ArrayList<>();
                                    }

                                    String firstLine = null;
                                    if (!lore.isEmpty()) {
                                        firstLine = lore.get(0);
                                    }

                                    // 첫 번째 줄이 비어 있지 않다면 별을 추가합니다.
                                    if (firstLine != null) {
                                        StringBuilder newLine = new StringBuilder(firstLine);
                                        newLine.append("§e★");
                                        lore.set(0, newLine.toString());
                                    } else {
                                        lore.add(0, "§e★");
                                    }

                                    itemMeta1.setLore(lore);

                                    // targetSlotItem의 ItemMeta를 수정하여 공격력을 갱신
                                    if (itemMeta1 != null) {
                                        AttributeModifier newModifier = new AttributeModifier(UUID.randomUUID(), "weapon_damage", newDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                        itemMeta1.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
                                        itemMeta1.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, newModifier);
                                        targetSlotItem.setItemMeta(itemMeta1);
                                    }
                                    if (starCount==9){
                                        // 강화 10강 성공 시 서버 월드에 메시지 출력
                                        String message = "§l§e[!] §a모두 축하해 주세요! "+player.getName() + "님이 강화 §510강§a에 성공하였습니다!";
                                        player.sendTitle("§l§e★ 축 하 ★", "§l§e"+player.getName() +"님이 강화 §l§510강§l§a에 성공하였습니다!", 10, 140, 10);
                                        Bukkit.getServer().broadcastMessage(message);
                                        // 월드 내 모든 플레이어에게 사운드 출력
                                        Sound sound = Sound.UI_TOAST_CHALLENGE_COMPLETE;
                                        float volume = 2.0f;
                                        float pitch = 1.0f;

                                        for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                                            onlinePlayer.playSound(onlinePlayer.getLocation(), sound, volume, pitch);
                                        }
                                    }else {
                                        player.playSound(player.getLocation(), "minecraft:block.anvil.use", SoundCategory.MASTER, 1.0f, 1.0f);
                                    }
                                    enhancementInventory.setItem(10, null);
                                    enhancementInventory.setItem(16, targetSlotItem);
                                    cancel();
                                } else if (randomNum < successChance + failChance) {
                                    // 실패
                                    for (int i = 0; i < PANE_SLOTS2.length; i++) {
                                        enhancementInventory.setItem(PANE_SLOTS2[i], InvenDecoRED_STAINED_GLASS_PANE());
                                    }
                                    player.playSound(player.getLocation(), "minecraft:block.note_block.bass", SoundCategory.MASTER, 2.0f, 1.0f);
                                    cancel();
                                } else {
                                    // 파괴
                                    for (int i = 0; i < PANE_SLOTS2.length; i++) {
                                        enhancementInventory.setItem(PANE_SLOTS2[i], InvenDecoRED_STAINED_GLASS_PANE());
                                    }
                                    player.playSound(player.getLocation(), "minecraft:block.anvil.destroy", SoundCategory.MASTER, 1.0f, 1.0f);
                                    enhancementInventory.setItem(10, null);
                                    cancel();
                                }
                            }
                        }
                    }.runTaskTimer(plugin, 1L, 4L);
                }
            }
            if (event.getSlot() == 16) {
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
