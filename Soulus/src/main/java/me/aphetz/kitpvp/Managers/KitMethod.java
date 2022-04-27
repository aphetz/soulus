package me.aphetz.kitpvp.Managers;

import me.aphetz.kitpvp.VarSetterGetter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class KitMethod {

    VarSetterGetter var = new VarSetterGetter();

    ItemStack createItem(Material mat, String name, int amount, Enchantment ench, String... lore) {

        ItemStack item = new ItemStack(mat, amount);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        if (!(ench == null)) {
            meta.addEnchant(ench, 1, false);
        }
        item.setItemMeta(meta);

        return item;

    }

    public void giveKit(Player player, String kit, int kitNumber) {

        player.getInventory().clear();
        var.getsClass().put(player.getUniqueId(), kit);

        switch (kit) {
            case "warrior":
                switch (kitNumber) {
                    case 1:
                        player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        player.getInventory().addItem(createItem(Material.STONE_SWORD, ChatColor.YELLOW + "Warrior's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        break;
                    case 2:
                        player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                        player.getInventory().addItem(createItem(Material.IRON_SWORD, ChatColor.YELLOW + "Warrior's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        break;
                    case 3:
                        player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                        player.getInventory().addItem(createItem(Material.IRON_SWORD, ChatColor.YELLOW + "Warrior's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        break;
                }
                break;
            case "archer":
                switch (kitNumber) {
                    case 1:
                        player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        player.getInventory().addItem(createItem(Material.WOODEN_SWORD, ChatColor.YELLOW + "Archer's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.BOW, ChatColor.YELLOW + "Archer's Bow", 1, null));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        player.getInventory().addItem(createItem(Material.ARROW, ChatColor.YELLOW + "Arrow", 64, null));
                        break;
                    case 2:
                        player.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                        player.getInventory().addItem(createItem(Material.WOODEN_SWORD, ChatColor.YELLOW + "Archer's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.BOW, ChatColor.YELLOW + "Archer's Bow", 1, Enchantment.ARROW_DAMAGE));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        player.getInventory().addItem(createItem(Material.ARROW, ChatColor.YELLOW + "Arrow", 128, null));
                        break;
                    case 3:
                        player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                        player.getInventory().addItem(createItem(Material.STONE_SWORD, ChatColor.YELLOW + "Archer's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.BOW, ChatColor.YELLOW + "Archer's Bow", 1, Enchantment.ARROW_DAMAGE));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        player.getInventory().addItem(createItem(Material.ARROW, ChatColor.YELLOW + "Arrow", 128, null));
                        break;
                }
                break;
            case "tank":
                switch (kitNumber) {
                    case 1:
                        player.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
                        player.getInventory().addItem(createItem(Material.WOODEN_SWORD, ChatColor.YELLOW + "Tank's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        break;
                    case 2:
                        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                        player.getInventory().addItem(createItem(Material.WOODEN_SWORD, ChatColor.YELLOW + "Tank's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        break;
                    case 3:
                        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
                        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                        player.getInventory().addItem(createItem(Material.STONE_SWORD, ChatColor.YELLOW + "Tank's Sword", 1, null));
                        player.getInventory().addItem(createItem(Material.GOLDEN_APPLE, ChatColor.YELLOW + "Golden Apple", 3, null));
                        break;
                }
                break;
        }

    }

    public void upgradeKit(Player player, String kit) {

        switch (kit) {
            case "warrior":
                if (var.getwClass().get(player.getUniqueId()) == 3) {
                    player.sendMessage(ChatColor.YELLOW + "This class is already maxed");
                    break;
                }
                if (var.getBal().get(player.getUniqueId()) < 5000) {
                    player.sendMessage(ChatColor.YELLOW + "You do not have enough to upgrade this");
                    break;
                }

                var.getBal().put(player.getUniqueId(), var.getBal().get(player.getUniqueId()) - 5000);
                var.getwClass().put(player.getUniqueId(), var.getwClass().get(player.getUniqueId()) + 1);
                player.sendMessage(ChatColor.YELLOW + "Item successfully bought");

                break;
            case "archer":
                if (var.getaClass().get(player.getUniqueId()) == 3) {
                    player.sendMessage(ChatColor.YELLOW + "This class is already maxed");
                    break;
                }
                if (var.getBal().get(player.getUniqueId()) < 5000) {
                    player.sendMessage(ChatColor.YELLOW + "You do not have enough to upgrade this");
                    break;
                }

                var.getBal().put(player.getUniqueId(), var.getBal().get(player.getUniqueId()) - 5000);
                var.getaClass().put(player.getUniqueId(), var.getaClass().get(player.getUniqueId()) + 1);
                player.sendMessage(ChatColor.YELLOW + "Item successfully bought");

                break;
            case "tank":
                if (var.gettClass().get(player.getUniqueId()) == 3) {
                    player.sendMessage(ChatColor.YELLOW + "This class is already maxed");
                    break;
                }
                if (var.getBal().get(player.getUniqueId()) < 5000) {
                    player.sendMessage(ChatColor.YELLOW + "You do not have enough to upgrade this");
                    break;
                }

                var.getBal().put(player.getUniqueId(), var.getBal().get(player.getUniqueId()) - 5000);
                var.gettClass().put(player.getUniqueId(), var.gettClass().get(player.getUniqueId()) + 1);
                player.sendMessage(ChatColor.YELLOW + "Item successfully bought");

                break;
        }

    }

}
