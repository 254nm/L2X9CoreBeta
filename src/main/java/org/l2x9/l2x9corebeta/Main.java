package org.l2x9.l2x9corebeta;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.l2x9.l2x9corebeta.commands.GiveCommand;
import org.l2x9.l2x9corebeta.events.BlockPlace;
import org.l2x9.l2x9corebeta.events.PlayerJoin;
import org.l2x9.l2x9corebeta.events.PlayerQuit;
import org.l2x9.l2x9corebeta.events.RandomSpawn;
import org.l2x9.l2x9corebeta.events.BLM;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerJoin playerJoin = new PlayerJoin();
        PlayerQuit playerQuit = new PlayerQuit();
       getCommand("give").setExecutor(new GiveCommand());
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, playerJoin, Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_QUIT, playerQuit, Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, new BlockPlace(), Event.Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_RESPAWN, new RandomSpawn(), Event.Priority.Highest, this);
        getServer().getPluginManager().registerEvent(Event.Type.OXYGEN_LOSS, new GeorgeFloyd(), Event.Priority.Highest, this); //this is important
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
