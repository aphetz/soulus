package me.aphetz.kitpvp.Managers;

import me.aphetz.kitpvp.Main;
import me.aphetz.kitpvp.VarSetterGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager implements Listener {

    private Main plugin;
    VarSetterGetter var = new VarSetterGetter();

    public ScoreboardManager(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {

                org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();
                final Scoreboard board = manager.getNewScoreboard();
                final Objective obj = board.registerNewObjective("Soulus", "dummy");

                obj.setDisplaySlot(DisplaySlot.SIDEBAR);
                obj.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "SOULUS");
                Score score11 = obj.getScore("   ");
                Score score10 = obj.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "PLAYER");
                Score score9 = obj.getScore("   Balance: " + ChatColor.YELLOW + var.getBal().get(player.getUniqueId()));
                Score score8 = obj.getScore("   Kills: " + ChatColor.YELLOW + var.getKills().get(player.getUniqueId()));
                Score score7 = obj.getScore("   Deaths: " + ChatColor.YELLOW + var.getDeaths().get(player.getUniqueId()));
                if (var.getDeaths().get(player.getUniqueId()) > 0) {
                    int kdr = var.getKills().get(player.getUniqueId()) / var.getDeaths().get(player.getUniqueId());
                    Score score6 = obj.getScore("   K/D: " + ChatColor.YELLOW + kdr);
                    score6.setScore(6);
                } else {
                    Score score6 = obj.getScore("   K/D: " + ChatColor.YELLOW + var.getKills().get(player.getUniqueId()));
                    score6.setScore(6);
                }
                Score score5 = obj.getScore("  ");
                Score score4 = obj.getScore(ChatColor.YELLOW + "" + ChatColor.BOLD + "SERVER");
                Score score3 = obj.getScore("   Online: " + ChatColor.YELLOW + Bukkit.getOnlinePlayers().size());
                Score score2 = obj.getScore("   IP: " + ChatColor.YELLOW + "localhost lol");
                Score score1 = obj.getScore(" ");

                score11.setScore(11);
                score10.setScore(10);
                score9.setScore(9);
                score8.setScore(8);
                score7.setScore(7);
                //6 done above because I had to
                score5.setScore(5);
                score4.setScore(4);
                score3.setScore(3);
                score2.setScore(2);
                score1.setScore(1);

                player.setScoreboard(board);

            }
        }, 0L, 60L);

    }

}
