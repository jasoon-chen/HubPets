package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;

import java.util.UUID;

public class witch
{
    private ConfigManager config = new ConfigManager();
    private Witch witch;

    public void spawnWitch(Player player)
    {
        String name = player.getPlayer().getDisplayName() + " Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("witch") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "witch" );

        witch = player.getWorld().spawn( player.getLocation(), Witch.class );
        witch.setCustomName( name );
        witch.setInvulnerable( true );
        witch.setCustomNameVisible( true );
        witch.setTarget( player );
        petSpawner.makePet( witch, player.getPlayer() );

    }

    @Deprecated
    public void rideWitch( Player player )
    {
        witch.remove();
        spawnWitch( player );
        witch.setPassenger( player );
    }

    @Deprecated
    public void hatWitch( Player player )
    {
        witch.remove();
        spawnWitch( player );
        player.setPassenger( witch );
    }

    public void removeWitch( Player player )
    {
        witch.remove();
    }

    public void bringWitch( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        witch.teleport( location );
    }

    public Location getLocation(Player player )
    {
        return witch.getLocation();
    }

    public void respawnWitch( Player player )
    {
        witch.remove();
        spawnWitch( player );
    }
}