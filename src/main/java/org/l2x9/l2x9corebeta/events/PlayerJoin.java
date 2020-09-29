package org.l2x9.l2x9corebeta.events;

import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class PlayerJoin extends PlayerListener {
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GRAY + event.getPlayer().getName() + " Joined");
    }
}
