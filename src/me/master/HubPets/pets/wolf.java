package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Player;

import java.util.UUID;

public class wolf
{
    private ConfigManager config = new ConfigManager();
    private Wolf wolf;

    public void spawnWolf(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("wolf") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "wolf" );

        wolf = player.getWorld().spawn( player.getLocation(), Wolf.class );
        wolf.setCustomName( name );
        wolf.setInvulnerable( true );
        wolf.setCustomNameVisible( true );
        wolf.setTarget( player );
        petSpawner.makePet( wolf, player.getPlayer() );

    }

    @Deprecated
    public void rideWolf( Player player )
    {
        wolf.setPassenger( player );
    }

    @Deprecated
    public void hatWolf( Player player )
    {
        player.setPassenger( wolf );
    }

    public void removeWolf( Player player )
    {
        wolf.remove();
    }

    public void bringWolf( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        wolf.teleport( location );
    }

    public void setBabyWolf( Player player )
    {
        wolf.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("wolf") || config.getLastPet(player.getUniqueId() ).equals("babywolf") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babywolf" );

        wolf = player.getWorld().spawn( player.getLocation(), Wolf.class );
        wolf.setCustomName( name );
        wolf.setInvulnerable( true );
        wolf.setCustomNameVisible( true );
        wolf.setTarget( player );
        wolf.setBaby();
        petSpawner.makePet( wolf, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return wolf.getLocation();
    }

    public void respawnWolf( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babywolf") )
        {
            setBabyWolf( player );
        }
        else
        {
            removeWolf( player );
            spawnWolf( player );
        }
    }
}
