package me.aphetz.kitpvp.Managers;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface IGUI extends InventoryHolder {

    void guiClick(Player whoClicked, int slot, ItemStack clickedItem);

}
