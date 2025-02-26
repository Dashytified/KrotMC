package nl.kvinnekraft;

import org.bukkit.plugin.java.JavaPlugin;

import nl.kvinnekraft.games.DashyEvents;
import nl.kvinnekraft.games.playerlayeggs.PlayerLayEggs;

public final class MiniDashy extends JavaPlugin
{
    public final DashyEvents listener = new DashyEvents();

    @Override
    public void onEnable()
    {
        final PlayerLayEggs ple = new PlayerLayEggs(this);

        // 

        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }
}

// May this become an all-in-one package. Capture The Wool being the first game.