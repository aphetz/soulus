package me.aphetz.kitpvp;

import me.aphetz.kitpvp.Commands.*;
import me.aphetz.kitpvp.Listeners.CombatLogListener;
import me.aphetz.kitpvp.Listeners.DeathListener;
import me.aphetz.kitpvp.Listeners.KitSelectorListener;
import me.aphetz.kitpvp.Managers.KitMethod;
import me.aphetz.kitpvp.Managers.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Main extends JavaPlugin implements Listener {

    VarSetterGetter var = new VarSetterGetter();
    KitMethod kit = var.kitmethod;

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Soulus Enabled]");

        saveDefaultConfig();

        getCommand("kitselector").setExecutor(new KitSelectorCommand());
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("balance").setExecutor(new BalanceCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getServer().getPluginManager().registerEvents(new KitSelectorListener(), this);
        getServer().getPluginManager().registerEvents(new VarSetterGetter(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new CombatLogListener(this), this);
        getServer().getPluginManager().registerEvents(new ScoreboardManager(this), this);

        getStringMap(var.getsClass(), "selected_class");
        getIntegerMap(var.getwClass(), "warrior_class");
        getIntegerMap(var.getaClass(), "archer_class");
        getIntegerMap(var.gettClass(), "tank_class");
        getIntegerMap(var.getBal(), "balance");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Soulus Disabled]");

        saveStringMap(var.getsClass(), "selected_class");
        saveIntegerMap(var.getwClass(), "warrior_class");
        saveIntegerMap(var.getaClass(), "archer_class");
        saveIntegerMap(var.gettClass(), "tank_class");
        saveIntegerMap(var.getBal(), "balance");

    }

    public void saveStringMap(HashMap<UUID, String> map, String path) {
        List<String> data = getConfig().getStringList(path);
        data.clear();
        for (UUID uuid : map.keySet()) {
            data.add(uuid.toString() + ":" + map.get(uuid));
        }
        getConfig().set(path, data);
        saveConfig();
    }

    public void getStringMap(HashMap<UUID, String> map, String path) {
        List<String> data = getConfig().getStringList(path);
        for (String str : data) {
            String[] words = str.split(":");
            map.put(UUID.fromString(words[0]), words[1]);
        }
    }

    public void saveIntegerMap(HashMap<UUID, Integer> map, String path) {
        List<String> data = getConfig().getStringList(path);
        data.clear();
        for (UUID uuid : map.keySet()) {
            data.add(uuid.toString() + ":" + map.get(uuid));
        }
        getConfig().set(path, data);
        saveConfig();
    }

    public void getIntegerMap(HashMap<UUID, Integer> map, String path) {
        List<String> data = getConfig().getStringList(path);
        for (String str : data) {
            String[] words = str.split(":");
            map.put(UUID.fromString(words[0]), Integer.parseInt(words[1]));
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent e) {
        e.setCancelled(true);
    }

    public Location getLocation(String path) {
        ConfigurationSection config = getConfig().getConfigurationSection(path);
        if (config == null) {
            return null;
        }
        String worldName = config.getString("world");
        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            return null;
        }
        double x = config.getDouble("x");
        double y = config.getDouble("y");
        double z = config.getDouble("z");
        float pitch = (float) config.getDouble("pitch");
        float yaw = (float) config.getDouble("yaw");
        return new Location(world, x, y, z, yaw, pitch);
    }

    public void setLocation(String path, Location location) {
        ConfigurationSection config = getConfig().createSection(path);
        config.set("world", location.getWorld().getName());
        config.set("x", location.getX());
        config.set("y", location.getY());
        config.set("z", location.getZ());
        config.set("pitch", location.getPitch());
        config.set("yaw", location.getYaw());
    }

}
