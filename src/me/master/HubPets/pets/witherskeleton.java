package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Player;

import java.util.UUID;

public class witherskeleton
{
    private ConfigManager config = new ConfigManager();
    private WitherSkeleton witerhskeleton;

    public void spawnWitherskeleton(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("witerhskeleton") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "witerhskeleton" );

        witerhskeleton = player.getWorld().spawn( player.getLocation(), WitherSkeleton.class );
        witerhskeleton.setCustomName( name );
        witerhskeleton.setInvulnerable( true );
        witerhskeleton.setCustomNameVisible( true );
        witerhskeleton.setTarget( player );
        petSpawner.makePet( witerhskeleton, player.getPlayer() );

    }

    @Deprecated
    public void rideWitherskeleton( Player player )
    {
        witerhskeleton.setPassenger( player );
    }

    @Deprecated
    public void hatWitherskeleton( Player player )
    {
        player.setPassenger( witerhskeleton );
    }

    public void removeWitherskeleton( Player player )
    {
        witerhskeleton.remove();
    }

    public void bringWitherskeleton( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        witerhskeleton.teleport( location );
    }

    public Location getLocation(Player player )
    {
        return witerhskeleton.getLocation();
    }

    public void respawnWitherskeleton( Player player )
    {
        witerhskeleton.remove();
        spawnWitherskeleton( player );
    }
}