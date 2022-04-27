package me.aphetz.kitpvp.Listeners;

import me.aphetz.kitpvp.Managers.IGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

public class KitSelectorListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof IGUI) {
            e.setCancelled(true);
            IGUI gui = (IGUI) e.getInventory().getHolder();
            gui.guiClick((Player)e.getWhoClicked(), e.getRawSlot(), e.getCurrentItem());
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryDragEvent e) {
        if (e.getInventory().getHolder() instanceof IGUI) {
            e.setCancelled(true);
        }
    }

}
