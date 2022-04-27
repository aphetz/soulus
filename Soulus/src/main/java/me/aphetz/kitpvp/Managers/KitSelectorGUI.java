package me.aphetz.kitpvp.Managers;

import me.aphetz.kitpvp.VarSetterGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.UUID;

public class KitSelectorGUI implements IGUI {

    Inventory gui;
    VarSetterGetter var = new VarSetterGetter();
    KitMethod kit = var.kitmethod;

    @Override
    public Inventory getInventory() {
        gui = Bukkit.getServer().createInventory(this, 27, ChatColor.YELLOW + "" + ChatColor.BOLD + "Kit Selector");
        return gui;
    }

    @Override
    public void guiClick(Player whoClicked, int slot, ItemStack clickedItem) {

        whoClicked.closeInventory();

        switch (slot) {
            case 12:
                kit.giveKit(whoClicked, "warrior", var.getwClass().get(whoClicked.getUniqueId()));
                break;
            case 13:
                kit.giveKit(whoClicked, "archer", var.getaClass().get(whoClicked.getUniqueId()));
                break;
            case 14:
                kit.giveKit(whoClicked, "tank", var.gettClass().get(whoClicked.getUniqueId()));
                break;
        }
    }

    ItemStack createItem(Material mat, String name, String... lore) {

        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;

    }

    public void setItems(Player player) {

        //create glass panes
        for (int i = 0; i < 27; i++) {
            gui.setItem(i, createItem(Material.BLACK_STAINED_GLASS_PANE, ChatColor.BLUE + ""));
        }
        for (int i = 10; i < 17; i++) {
            gui.clear(i);
        }

        UUID uuid = player.getUniqueId();

        gui.setItem(12, createItem(Material.IRON_SWORD, ChatColor.YELLOW + "Warrior", " ", ChatColor.WHITE + "Level " + var.getwClass().get(uuid), " ", ChatColor.GRAY + "SELECT"));
        gui.setItem(13, createItem(Material.BOW, ChatColor.YELLOW + "Archer", " ", ChatColor.WHITE + "Level " + var.getaClass().get(uuid), " ", ChatColor.GRAY + "SELECT"));
        gui.setItem(14, createItem(Material.DIAMOND_CHESTPLATE, ChatColor.YELLOW + "Tank", " ", ChatColor.WHITE + "Level " + var.gettClass().get(uuid), " ", ChatColor.GRAY + "SELECT"));

        switch (var.getsClass().get(uuid)) {
            case "warrior":
                gui.clear(12);
                gui.setItem(12, createItem(Material.IRON_SWORD, ChatColor.YELLOW + "Warrior", " ", ChatColor.WHITE + "Level " + var.getwClass().get(uuid), " ", ChatColor.YELLOW + "" + ChatColor.BOLD + "SELECTED"));
                break;
            case "archer":
                gui.clear(13);
                gui.setItem(13, createItem(Material.BOW, ChatColor.YELLOW + "Archer", " ", ChatColor.WHITE + "Level " + var.getaClass().get(uuid), " ", ChatColor.YELLOW + "" + ChatColor.BOLD + "SELECTED"));
                break;
            case "tank":
                gui.clear(14);
                gui.setItem(14, createItem(Material.DIAMOND_CHESTPLATE, ChatColor.YELLOW + "Tank", " ", ChatColor.WHITE + "Level " + var.gettClass().get(uuid), " ", ChatColor.YELLOW + "" + ChatColor.BOLD + "SELECTED"));
                break;
        }

    }

}