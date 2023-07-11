package weaponenhancement.weaponenhancement;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EnhancementInventory {
    public void openEnhancementInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, "강화");

        setItem(inventory, 0,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 1,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 2,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 3,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 4,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 5,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 6,InvenDecoPURPLE_STAINED_GLASS_PANE());
        setItem(inventory, 7,InvenDecoPURPLE_STAINED_GLASS_PANE());
        setItem(inventory, 8,InvenDecoPURPLE_STAINED_GLASS_PANE());
        setItem(inventory, 9,InvenDecoGray_STAINED_GLASS_PANE());

        setItem(inventory, 11,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 12,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 13,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 14,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 15,InvenDecoPURPLE_STAINED_GLASS_PANE());
        setItem(inventory, 17,InvenDecoPURPLE_STAINED_GLASS_PANE());

        setItem(inventory, 18,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 19,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 20,InvenDecoGray_STAINED_GLASS_PANE());
        setItem(inventory, 21,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 22,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 23,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 24,InvenDecoPURPLE_STAINED_GLASS_PANE());
        setItem(inventory, 25,InvenDecoPURPLE_STAINED_GLASS_PANE());
        setItem(inventory, 26,InvenDecoPURPLE_STAINED_GLASS_PANE());

        setItem(inventory, 27,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 28,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 29,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 30,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 32,InvenDecoRED_STAINED_GLASS_PANE());
        setItem(inventory, 33,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 34,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 35,InvenDecoWHITE_STAINED_GLASS_PANE());

        setItem(inventory, 36,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 37,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 38,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 41,InvenDecoORANGE_STAINED_GLASS_PANE());
        setItem(inventory, 42,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 43,InvenDecoLIME_STAINED_GLASS_PANE());
        setItem(inventory, 44,InvenDecoWHITE_STAINED_GLASS_PANE());

        setItem(inventory, 45,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 46,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 47,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 48,InvenDecoGREEN_STAINED_GLASS_PANE());
        setItem(inventory, 50,InvenDecoYELLOW_STAINED_GLASS_PANE());
        setItem(inventory, 51,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 52,InvenDecoWHITE_STAINED_GLASS_PANE());
        setItem(inventory, 53,InvenDecoWHITE_STAINED_GLASS_PANE());


        player.openInventory(inventory);
    }

    private void setItem(Inventory inventory, int slot, ItemStack item) {
        inventory.setItem(slot, item);
    }
    public static ItemStack InvenDecoWHITE_STAINED_GLASS_PANE () {
        ItemStack check = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName(" ");
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoGREEN_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName("§l▲ 강화권");
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoLIME_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName("§l§a[ 강화 시작 ]");
        meta.setLore(Arrays.asList("§f클릭 시 강화를 시작합니다"));
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoSuccess_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName(" ");
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoORANGE_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName(" ");
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoRED_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName(" ");
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoPURPLE_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName(" ");
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoGray_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName(" ");
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoBLACK_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName(" ");
        check.setItemMeta(meta);
        return check;
    }
    public static ItemStack InvenDecoYELLOW_STAINED_GLASS_PANE() {
        ItemStack check = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE, 1);
        ItemMeta meta = check.getItemMeta();
        meta.setDisplayName(" ");
        check.setItemMeta(meta);
        return check;
    }
}
