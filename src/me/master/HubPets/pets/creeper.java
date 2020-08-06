package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;

import java.util.UUID;

public class creeper
{
    private ConfigManager config = new ConfigManager();
    private Creeper creeper;

    public void spawnCreeper(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("creeper") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "creeper" );

        creeper = player.getWorld().spawn( player.getLocation(), Creeper.class );
        creeper.setCustomName( name );
        creeper.setInvulnerable( true );
        creeper.setCustomNameVisible( true );
        creeper.setExplosionRadius( 0 );
        creeper.setTarget( player );
        petSpawner.makePet( creeper, player.getPlayer() );

    }

    @Deprecated
    public void rideCreeper( Player player )
    {
        creeper.remove();
        spawnCreeper( player );
        creeper.setPassenger( player );
    }

    @Deprecated
    public void hatCreeper( Player player )
    {
        creeper.remove();
        spawnCreeper( player );
        player.setPassenger( creeper );
    }

    public void removeCreeper( Player player )
    {
        creeper.remove();
    }

    public void bringCreeper( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        creeper.teleport( location );
    }

    public void respawnCreeper( Player player )
    {
        creeper.remove();
        spawnCreeper( player );
    }

    public Location getLocation(Player player )
    {
        return creeper.getLocation();
    }
}