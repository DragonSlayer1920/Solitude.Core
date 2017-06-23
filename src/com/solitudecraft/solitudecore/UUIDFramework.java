package com.solitudecraft.solitudecore;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by nolan on 6/21/2017.
 */
public class UUIDFramework {
    public OfflinePlayer getPlayer(String uuid) {
        UUID playerUUID = UUID.fromString(uuid);
        return Bukkit.getServer().getOfflinePlayer(playerUUID);
    }

    public UUID getUUID(Player player) {
        return player.getUniqueId();
    }

    public String getUsername(String uuid) {
        return getPlayer(uuid).getName();
    }
}
