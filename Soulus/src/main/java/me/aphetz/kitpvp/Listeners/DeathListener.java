package me.aphetz.kitpvp.Listeners;

import me.aphetz.kitpvp.Main;
import me.aphetz.kitpvp.Managers.KitMethod;
import me.aphetz.kitpvp.VarSetterGetter;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DeathListener implements Listener {

    VarSetterGetter var = new VarSetterGetter();
    KitMethod kit = var.kitmethod;
    private Main plugin;
    private int i;
    private int x;

    public DeathListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {

        if (!(e.getEntity() instanceof Player) || !(e.getDamager() instanceof Player)) {
            return;
        }

        Player victim = (Player) e.getEntity();
        Player attacker = (Player) e.getDamager();

        if (e.getDamage() > victim.getHealth()) {
            e.setCancelled(true);
            victim.setGameMode(GameMode.SPECTATOR);

            x = 3;

            for (i = 0; i < 3; i++) {
                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        victim.sendTitle(ChatColor.RED + "" + x, ChatColor.WHITE + "Respawning in...", 10, 70, 1);
                        x--;
                    }
                }, 20L * i);
            }

            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {

                    victim.setGameMode(GameMode.SURVIVAL);
                    victim.teleport(plugin.getLocation("spawn"));
                    victim.setHealth(20);

                    switch (var.getsClass().get(victim.getUniqueId())) {
                        case "warrior":
                            kit.giveKit(victim, "warrior", var.getwClass().get(victim.getUniqueId()));
                            break;
                        case "archer":
                            kit.giveKit(victim, "archer", var.getaClass().get(victim.getUniqueId()));
                            break;
                        case "tank":
                            kit.giveKit(victim, "tank", var.gettClass().get(victim.getUniqueId()));
                            break;
                    }

                    var.getBal().put(attacker.getUniqueId(), var.getBal().get(attacker.getUniqueId()) + 10);

                }
            }, 61L);

        }

    }

}
