package nl.kvinnekraft.games.playerlayeggs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import nl.kvinnekraft.MiniDashy;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

///
/// This piece of art was made with the intent of adding similar functionality found on another server. It allows you to lay eggs when you shift based on a percentage. Configuration file is as of now not a part of the implementation but may be by the time this is read.
///

public class PlayerLayEggs
{
    private final HashMap<UUID, Integer> twerks = new HashMap<>();

    private int GetTwerks(final UUID uuid)
    {
        return twerks.getOrDefault(uuid, 0);
    }

    private boolean HasTwerks(final UUID uuid)
    {
        return GetTwerks(uuid) > 0;
    }

    private void UpdateTwerks(final UUID uuid)
    {
        int count = 1;

        if (HasTwerks(uuid))
        {
            count += GetTwerks(uuid);
        }

        twerks.put(uuid, count);
    }

    private void ResetTwerks(final UUID uuid)
    {
        twerks.put(uuid, 0);
    }

    private final int when_try_lay_egg = 10;
    private final int one_to_hundred_chance = 50;

    private boolean MayLayEgg(final Player player, final UUID uuid)
    {
        final boolean twerking = player.isSneaking();

        if (twerking)
        {
            UpdateTwerks(uuid);

            return false;
        }

        final int twerks = GetTwerks(uuid);

        if (twerks < when_try_lay_egg)
        {
            return false;
        }

        ResetTwerks(uuid);

        final Random random = new Random();

        return random.nextInt(100) <= one_to_hundred_chance;
    }

    private void PlayerSneak(PlayerToggleSneakEvent event)
    {
        final Player player = event.getPlayer();
        final UUID uuid = player.getUniqueId();

        if (!MayLayEgg(player, uuid))
        {
            return;
        }

        final Location location = player.getLocation();
        final World world = location.getWorld();

        player.playSound(location, Sound.ENTITY_CHICKEN_EGG, 1.0F, 1.0F);
        player.playSound(location, Sound.ENTITY_SLIME_JUMP, 1.0f, 1.0f);

        final ItemStack egg = new ItemStack(Material.EGG, 1);

        world.dropItem(location, egg);
    }

    public PlayerLayEggs(final MiniDashy pony)
    {
        pony.listener.sneak_event_handlers.add(this::PlayerSneak);
    }
}
