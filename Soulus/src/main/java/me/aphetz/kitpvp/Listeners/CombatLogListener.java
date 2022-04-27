package me.aphetz.kitpvp.Listeners;

import me.aphetz.kitpvp.Main;
import me.aphetz.kitpvp.VarSetterGetter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.time.Instant;
import java.util.HashMap;

public class CombatLogListener implements Listener {

    private Main plugin;
    VarSetterGetter var = new VarSetterGetter();

    public CombatLogListener(Main plugin) {
        this.plugin = plugin;
    }

    HashMap<Player, Long> combatLog = new HashMap<>();
    HashMap<Player, Player> lastHit = new HashMap<>();

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {

        if (!(e.getEntity() instanceof Player) || !(e.getDamager() instanceof Player)) {
            return;
        }

        Player victim = (Player) e.getEntity();
        Player attacker = (Player) e.getDamager();

        long unixTime = Instant.now().getEpochSecond();

        if ((!(combatLog.get(victim) == null)) && unixTime - combatLog.get(victim) > 6) {
            victim.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "COMBAT " + ChatColor.RESET + "you are now in combat.");
        }
        if ((!(combatLog.get(attacker) == null)) && unixTime - combatLog.get(attacker) > 6) {
            attacker.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "COMBAT " + ChatColor.RESET + "you are now in combat.");
        }

        combatLog.put(victim, unixTime);
        combatLog.put(attacker, unixTime);
        lastHit.put(victim, attacker);
        lastHit.put(attacker, victim);

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                long unixTime2 = Instant.now().getEpochSecond();
                if (unixTime2 - combatLog.get(victim) == 5) {
                    victim.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "COMBAT " + ChatColor.RESET + "you are no longer in combat.");
                }
                if (unixTime2 - combatLog.get(attacker) == 5) {
                    attacker.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "COMBAT " + ChatColor.RESET + "you are no longer in combat.");
                }
            }
        }, 100L);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        long unixTime = Instant.now().getEpochSecond();
        if (lastHit.get(e.getPlayer()) == null) {
            return;
        }
        Player attacker = lastHit.get(e.getPlayer());

        if (unixTime - combatLog.get(e.getPlayer()) < 6) {
            attacker.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "COMBAT " + ChatColor.RESET + attacker.getName() + " logged out in combat.");
            var.getBal().put(attacker.getUniqueId(), var.getBal().get(attacker.getUniqueId()) + 10);
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        long unixTime = Instant.now().getEpochSecond();

        if (combatLog.get(e.getPlayer()) == null) {
            return;
        }

        if (unixTime - combatLog.get(e.getPlayer()) > 4 && (!(e.getPlayer().hasPermission("combatlog.bypass")))) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "COMBAT " + ChatColor.RESET + "you cannot send commands in combat.");
        }
    }

}
