package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import java.util.UUID;

public class horse
{
    private ConfigManager config = new ConfigManager();
    private Horse horse;

    public void spawnHorse(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("horse") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "horse" );

        horse = player.getWorld().spawn( player.getLocation(), Horse.class );
        horse.setCustomName( name );
        horse.setInvulnerable( true );
        horse.setCustomNameVisible( true );
        horse.setTarget( player );
        petSpawner.makePet( horse, player.getPlayer() );

    }

    @Deprecated
    public void rideHorse( Player player )
    {
        horse.setPassenger( player );
    }

    @Deprecated
    public void hatHorse( Player player )
    {
        player.setPassenger( horse );
    }

    public void removeHorse( Player player )
    {
        horse.remove();
    }

    public void bringHorse( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        horse.teleport( location );
    }

    public void setBabyHorse( Player player )
    {
        horse.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("horse") || config.getLastPet(player.getUniqueId() ).equals("babyhorse") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babymule" );

        horse = player.getWorld().spawn( player.getLocation(), Horse.class );
        horse.setCustomName( name );
        horse.setInvulnerable( true );
        horse.setCustomNameVisible( true );
        horse.setTarget( player );
        horse.setBaby();
        petSpawner.makePet( horse, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return horse.getLocation();
    }

    public void respawnHorse( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babyhorse") )
        {
            setBabyHorse( player );
        }
        else
        {
            removeHorse( player );
            spawnHorse( player );
        }
    }
}
