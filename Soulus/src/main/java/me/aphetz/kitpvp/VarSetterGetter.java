package me.aphetz.kitpvp;

import me.aphetz.kitpvp.Managers.KitMethod;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class VarSetterGetter implements Listener {

    public static KitMethod kitmethod = new KitMethod();

    public static HashMap<UUID, String> sClass = new HashMap<>();
    public static HashMap<UUID, Integer> wClass = new HashMap<>();
    public static HashMap<UUID, Integer> aClass = new HashMap<>();
    public static HashMap<UUID, Integer> tClass = new HashMap<>();
    public static HashMap<UUID, Integer> bal = new HashMap<>();
    public static HashMap<UUID, Integer> kills = new HashMap<>();
    public static HashMap<UUID, Integer> deaths = new HashMap<>();

    public HashMap<UUID, String> getsClass() {
        return sClass;
    }

    public HashMap<UUID, Integer> getwClass() {
        return wClass;
    }

    public HashMap<UUID, Integer> getaClass() {
        return aClass;
    }

    public HashMap<UUID, Integer> gettClass() {
        return tClass;
    }

    public HashMap<UUID, Integer> getBal() {
        return bal;
    }

    public HashMap<UUID, Integer> getDeaths() {
        return deaths;
    }

    public HashMap<UUID, Integer> getKills() {
        return kills;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        if (aClass.get(uuid) == null
                || wClass.get(uuid) == null
                || tClass.get(uuid) == null
                || sClass.get(uuid) == null
                || kills.get(uuid) == null
                || deaths.get(uuid) == null
                || bal.get(uuid) == null) {
            wClass.put(player.getUniqueId(), 1);
            aClass.put(player.getUniqueId(), 1);
            tClass.put(player.getUniqueId(), 1);
            sClass.put(player.getUniqueId(), "warrior");
            bal.put(uuid, 0);
            kills.put(uuid, 0);
            deaths.put(uuid, 0);
        }
    }

}