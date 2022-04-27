package me.aphetz.kitpvp.Commands;

import me.aphetz.kitpvp.Managers.KitSelectorGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitSelectorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "This command cannot be run by console");
            return true;
        }

        Player player = (Player) sender;

        KitSelectorGUI gui = new KitSelectorGUI();

        player.openInventory(gui.getInventory());
        gui.setItems(player);

        return true;
    }
}
