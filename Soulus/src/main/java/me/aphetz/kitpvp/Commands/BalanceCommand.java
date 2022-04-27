package me.aphetz.kitpvp.Commands;

import me.aphetz.kitpvp.VarSetterGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    VarSetterGetter var = new VarSetterGetter();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length > 0) {

            OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
            if (!(target.hasPlayedBefore())) {
                player.sendMessage(ChatColor.YELLOW + "This player has never joined the server");
                return true;
            }
            player.sendMessage(ChatColor.YELLOW + "" + target.getName() + "'s " + ChatColor.WHITE + "balance is " + ChatColor.YELLOW + var.getBal().get(target.getUniqueId()));

            return true;
        }

        player.sendMessage(ChatColor.YELLOW + "Your " + ChatColor.WHITE + "balance is " + ChatColor.YELLOW + var.getBal().get(player.getUniqueId()));

        return true;
    }
}
