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
    EnhancementInventory EnhancementInventory= new EnhancementInventory();
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
                return;
            }
            if (event.getSlot() == 43) {
                if (targetSlotItem != null && targetSlotItem2 != null) {
                    enhancementInventory.setItem(0, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(1, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(2, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(3, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(4, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(5, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(6, InvenDecoPURPLE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(7, InvenDecoPURPLE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(8, InvenDecoPURPLE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(9, InvenDecoGray_STAINED_GLASS_PANE());

                    enhancementInventory.setItem(11, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(12, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(13, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(14, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(15, InvenDecoPURPLE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(17, InvenDecoPURPLE_STAINED_GLASS_PANE());

                    enhancementInventory.setItem(18, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(19, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(20, InvenDecoGray_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(21, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(22, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(23, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(24, InvenDecoPURPLE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(25, InvenDecoPURPLE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(26, InvenDecoPURPLE_STAINED_GLASS_PANE());

                    enhancementInventory.setItem(27, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(28, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(29, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(30, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(32, InvenDecoRED_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(33, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(34, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(35, InvenDecoWHITE_STAINED_GLASS_PANE());

                    enhancementInventory.setItem(36, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(37, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(38, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(41, InvenDecoORANGE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(42, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(43, InvenDecoLIME_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(44, InvenDecoWHITE_STAINED_GLASS_PANE());

                    enhancementInventory.setItem(45, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(46, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(47, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(48, InvenDecoGREEN_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(50, InvenDecoYELLOW_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(51, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(52, InvenDecoWHITE_STAINED_GLASS_PANE());
                    enhancementInventory.setItem(53, InvenDecoWHITE_STAINED_GLASS_PANE());
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
                    if (isSword(targetSlotItem.getType())) {
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
                                    if (player.isOp()){
                                        successChance = 1.0;
                                        failChance = 0.0;
                                        destroyChance = 0.0;
                                    }else if (starCount == 0) {
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
                                        if (starCount == 7) {
                                            increaseAmount = 1.0;
                                        } else if (starCount == 8) {
                                            increaseAmount = 1.5;
                                        } else if (starCount == 9) {
                                            increaseAmount = 3.0;
                                        }
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
                                            AttributeModifier attackSpeedModifier = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 1.6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                                            itemMeta1.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
                                            itemMeta1.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
                                            itemMeta1.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, newModifier);
                                            itemMeta1.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedModifier);
                                            targetSlotItem.setItemMeta(itemMeta1);
                                        }
                                        if (starCount == 9) {
                                            // 강화 10강 성공 시 서버 월드에 메시지 출력
                                            String message = "§l§e[!] §a모두 축하해 주세요! " + player.getName() + "님이 강화 §510강§a에 성공하였습니다!";
                                            player.sendTitle("§l§e★ 축 하 ★", "§l§e" + player.getName() + "님이 강화 §l§510강§l§a에 성공하였습니다!", 10, 140, 10);
                                            Bukkit.getServer().broadcastMessage(message);
                                            // 월드 내 모든 플레이어에게 사운드 출력
                                            Sound sound = Sound.UI_TOAST_CHALLENGE_COMPLETE;
                                            float volume = 2.0f;
                                            float pitch = 1.0f;

                                            for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                                                onlinePlayer.playSound(onlinePlayer.getLocation(), sound, volume, pitch);
                                            }
                                        } else {
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
                    } else if (isEquip(targetSlotItem.getType())) {
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
                                    if (player.isOp()){
                                        successChance = 1.0;
                                        failChance = 0.0;
                                        destroyChance = 0.0;
                                    }else if (starCount == 0) {
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
                                        // 방어력 증가 로직 추가
                                        double baseArmor = 0.0;
                                        if (itemMeta1 != null && itemMeta1.hasAttributeModifiers()) {
                                            Collection<AttributeModifier> modifiers1 = itemMeta1.getAttributeModifiers(Attribute.GENERIC_ARMOR);
                                            if (modifiers1 != null) {
                                                for (AttributeModifier modifier : modifiers1) {
                                                    if (modifier.getOperation() == AttributeModifier.Operation.ADD_NUMBER) {
                                                        baseArmor = modifier.getAmount();
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        double baseMaxHealth = 0.0;
                                        double maxHealthIncrease = 0.0;
                                        if (itemMeta1.hasAttributeModifiers()) {
                                            Collection<AttributeModifier> maxHealthModifiers = itemMeta1.getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH);
                                            if (maxHealthModifiers != null) {
                                                for (AttributeModifier modifier : maxHealthModifiers) {
                                                    if (modifier.getOperation() == AttributeModifier.Operation.ADD_NUMBER) {
                                                        baseMaxHealth = modifier.getAmount();
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        double baseSpeed = 0.0;
                                        double speedIncrease = 0.0;
                                        if (itemMeta1.hasAttributeModifiers()) {
                                            Collection<AttributeModifier> maxHealthModifiers = itemMeta1.getAttributeModifiers(Attribute.GENERIC_MOVEMENT_SPEED);
                                            if (maxHealthModifiers != null) {
                                                for (AttributeModifier modifier : maxHealthModifiers) {
                                                    if (modifier.getOperation() == AttributeModifier.Operation.ADD_NUMBER) {
                                                        baseSpeed = modifier.getAmount();
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (starCount==4){
                                            maxHealthIncrease = 1.0;
                                        }
                                        if (starCount==9){
                                            maxHealthIncrease = 2.0;
                                        }
                                        if (whatType(targetSlotItem.getType()).equals("FEET")){
                                            if (starCount==4 || starCount==9){
                                                speedIncrease = 0.01;
                                            }

                                        }
                                        double increaseAmount = 0.5;
                                        double newArmor = baseArmor + increaseAmount;
                                        double newMaxHealth = baseMaxHealth + maxHealthIncrease;

                                        double newSpeed = baseSpeed + speedIncrease;
                                        if (newArmor < 4) {
                                            // 원하는 값으로 수정 가능
                                            if (targetSlotItem.getType() == Material.LEATHER_HELMET) {
                                                newArmor = 1.5;
                                            }
                                            if (targetSlotItem.getType() == Material.LEATHER_LEGGINGS || targetSlotItem.getType() == Material.CHAINMAIL_HELMET || targetSlotItem.getType() == Material.IRON_HELMET || targetSlotItem.getType() == Material.GOLDEN_HELMET) {
                                                newArmor = 2.5;
                                            }
                                            if (targetSlotItem.getType() == Material.LEATHER_CHESTPLATE || targetSlotItem.getType() == Material.DIAMOND_HELMET || targetSlotItem.getType() == Material.NETHERITE_HELMET) {
                                                newArmor = 3.5;
                                            }
                                            if (targetSlotItem.getType() == Material.CHAINMAIL_LEGGINGS) {
                                                newArmor = 4.5;
                                            }
                                            if (targetSlotItem.getType() == Material.CHAINMAIL_CHESTPLATE || targetSlotItem.getType() == Material.IRON_LEGGINGS) {
                                                newArmor = 5.5;
                                            }
                                            if (targetSlotItem.getType() == Material.IRON_CHESTPLATE || targetSlotItem.getType() == Material.DIAMOND_LEGGINGS || targetSlotItem.getType() == Material.NETHERITE_LEGGINGS) {
                                                newArmor = 6.5;
                                            }
                                            if (targetSlotItem.getType() == Material.DIAMOND_CHESTPLATE) {
                                                newArmor = 8.5;
                                            }
                                            if (targetSlotItem.getType() == Material.GOLDEN_CHESTPLATE) {
                                                newArmor = 5.5;
                                            }
                                            if (targetSlotItem.getType() == Material.NETHERITE_CHESTPLATE) {
                                                newArmor = 8.5;
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

                                        // targetSlotItem의 ItemMeta를 수정하여 방어력 및 최대 체력을 갱신
                                        if (targetSlotItem.getType() == Material.DIAMOND_CHESTPLATE || targetSlotItem.getType() == Material.DIAMOND_LEGGINGS || targetSlotItem.getType() == Material.DIAMOND_HELMET || targetSlotItem.getType() == Material.DIAMOND_BOOTS) {
                                            if (itemMeta1 != null) {
                                                AttributeModifier armorModifier = new AttributeModifier(UUID.randomUUID(), "armor", newArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier toughnessModifier = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier maxHealthModifier = new AttributeModifier(UUID.randomUUID(), "generic.maxHealth", newMaxHealth, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier speedModifier = new AttributeModifier(UUID.randomUUID(), "generic.speed", newSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));

                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_ARMOR);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED);

                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_ARMOR, armorModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughnessModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, maxHealthModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speedModifier);

                                                targetSlotItem.setItemMeta(itemMeta1);
                                            }
                                        } else if (targetSlotItem.getType() == Material.NETHERITE_CHESTPLATE || targetSlotItem.getType() == Material.NETHERITE_LEGGINGS || targetSlotItem.getType() == Material.NETHERITE_HELMET || targetSlotItem.getType() == Material.NETHERITE_BOOTS) {
                                            if (itemMeta1 != null) {
                                                AttributeModifier armorModifier = new AttributeModifier(UUID.randomUUID(), "armor", newArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier toughnessModifier = new AttributeModifier(UUID.randomUUID(), "generic.armorToughness", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier knockbackModifier = new AttributeModifier(UUID.randomUUID(), "generic.knockbackResistance", 0.1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier maxHealthModifier = new AttributeModifier(UUID.randomUUID(), "generic.maxHealth", newMaxHealth, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier speedModifier = new AttributeModifier(UUID.randomUUID(), "generic.speed", newSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));

                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_ARMOR);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED);

                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_ARMOR, armorModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughnessModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockbackModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, maxHealthModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speedModifier);

                                                targetSlotItem.setItemMeta(itemMeta1);
                                            }
                                        } else {
                                            if (itemMeta1 != null) {
                                                AttributeModifier armorModifier = new AttributeModifier(UUID.randomUUID(), "armor", newArmor, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier maxHealthModifier = new AttributeModifier(UUID.randomUUID(), "generic.maxHealth", newMaxHealth, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));
                                                AttributeModifier speedModifier = new AttributeModifier(UUID.randomUUID(), "generic.speed", newSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.valueOf(whatType(targetSlotItem.getType())));

                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_ARMOR);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH);
                                                itemMeta1.removeAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED);

                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_ARMOR, armorModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, maxHealthModifier);
                                                itemMeta1.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speedModifier);

                                                targetSlotItem.setItemMeta(itemMeta1);
                                            }
                                        }


                                        if (starCount == 9) {
                                            // 강화 10강 성공 시 서버 월드에 메시지 출력
                                            String message = "§l§e[!] §a모두 축하해 주세요! " + player.getName() + "님이 강화 §510강§a에 성공하였습니다!";
                                            player.sendTitle("§l§e★ 축 하 ★", "§l§e" + player.getName() + "님이 강화 §l§510강§l§a에 성공하였습니다!", 10, 140, 10);
                                            Bukkit.getServer().broadcastMessage(message);
                                            // 월드 내 모든 플레이어에게 사운드 출력
                                            Sound sound = Sound.UI_TOAST_CHALLENGE_COMPLETE;
                                            float volume = 2.0f;
                                            float pitch = 1.0f;

                                            for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                                                onlinePlayer.playSound(onlinePlayer.getLocation(), sound, volume, pitch);
                                            }
                                        } else {
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
            }
            if (event.getSlot() == 16) {
                ItemStack itemInSlot16 = event.getCurrentItem();
                player.getInventory().addItem(itemInSlot16);
                player.closeInventory();
            }
        }
    }
    private boolean isSword(Material material) {
        return material == Material.WOODEN_SWORD ||
                material == Material.STONE_SWORD ||
                material == Material.IRON_SWORD ||
                material == Material.GOLDEN_SWORD ||
                material == Material.DIAMOND_SWORD ||
                material == Material.NETHERITE_SWORD;
    }
    private boolean isEquip(Material material) {
        return material == Material.LEATHER_HELMET ||
                material == Material.CHAINMAIL_HELMET ||
                material == Material.IRON_HELMET ||
                material == Material.GOLDEN_HELMET ||
                material == Material.DIAMOND_HELMET ||
                material == Material.NETHERITE_HELMET ||

                material == Material.DIAMOND_CHESTPLATE ||
                material == Material.GOLDEN_CHESTPLATE ||
                material == Material.IRON_CHESTPLATE ||
                material == Material.CHAINMAIL_CHESTPLATE ||
                material == Material.NETHERITE_CHESTPLATE ||
                material == Material.LEATHER_CHESTPLATE ||

                material == Material.LEATHER_LEGGINGS ||
                material == Material.CHAINMAIL_LEGGINGS ||
                material == Material.IRON_LEGGINGS ||
                material == Material.DIAMOND_LEGGINGS ||
                material == Material.GOLDEN_LEGGINGS ||
                material == Material.NETHERITE_LEGGINGS ||

                material == Material.LEATHER_BOOTS ||
                material == Material.CHAINMAIL_BOOTS ||
                material == Material.IRON_BOOTS ||
                material == Material.GOLDEN_BOOTS ||
                material == Material.DIAMOND_BOOTS ||
                material == Material.NETHERITE_BOOTS ;
    }
    private String whatType(Material material) {
        if(material == Material.LEATHER_HELMET ||
                material == Material.CHAINMAIL_HELMET ||
                material == Material.IRON_HELMET ||
                material == Material.GOLDEN_HELMET ||
                material == Material.DIAMOND_HELMET ||
                material == Material.NETHERITE_HELMET){
            return "HEAD";
        } else if (material == Material.DIAMOND_CHESTPLATE ||
                material == Material.GOLDEN_CHESTPLATE ||
                material == Material.IRON_CHESTPLATE ||
                material == Material.CHAINMAIL_CHESTPLATE ||
                material == Material.NETHERITE_CHESTPLATE ||
                material == Material.LEATHER_CHESTPLATE) {
            return "CHEST";
        }else if (material == Material.LEATHER_LEGGINGS ||
                material == Material.CHAINMAIL_LEGGINGS ||
                material == Material.IRON_LEGGINGS ||
                material == Material.DIAMOND_LEGGINGS ||
                material == Material.GOLDEN_LEGGINGS ||
                material == Material.NETHERITE_LEGGINGS){
            return "LEGS";
        }else if (material == Material.LEATHER_BOOTS ||
                material == Material.CHAINMAIL_BOOTS ||
                material == Material.IRON_BOOTS ||
                material == Material.GOLDEN_BOOTS ||
                material == Material.DIAMOND_BOOTS ||
                material == Material.NETHERITE_BOOTS){
            return "FEET";
        }
            return null;
    }
}
