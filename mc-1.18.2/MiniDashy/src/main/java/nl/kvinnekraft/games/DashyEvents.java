package nl.kvinnekraft.games;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DashyEvents implements Listener
{
    public final List<Consumer<PlayerToggleSneakEvent>> sneak_event_handlers = new ArrayList<>();

    @EventHandler
    public void PlayerSneakEvent(final PlayerToggleSneakEvent event)
    {
        for (final Consumer<PlayerToggleSneakEvent> consumer : sneak_event_handlers)
        {
            consumer.accept(event);
        }
    }


}
