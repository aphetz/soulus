package me.aphetz.kitpvp.Commands;

import me.aphetz.kitpvp.Managers.ShopGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "This command cannot be run by console");
            return true;
        }

        Player player = (Player) sender;

        ShopGUI gui = new ShopGUI();

        player.openInventory(gui.getInventory());
        gui.setItems(player);

        return true;

    }
}
