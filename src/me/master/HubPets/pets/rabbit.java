package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class rabbit
{
    private ConfigManager config = new ConfigManager();
    private Rabbit rabbit;

    public void spawnRabbit(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("rabbit") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "rabbit" );

        rabbit = player.getWorld().spawn( player.getLocation(), Rabbit.class );
        rabbit.setCustomName( name );
        rabbit.setInvulnerable( true );
        rabbit.setCustomNameVisible( true );
        rabbit.setTarget( player );
        petSpawner.makePet( rabbit, player.getPlayer() );

    }

    @Deprecated
    public void rideRabbit( Player player )
    {
        rabbit.setPassenger( player );
    }

    @Deprecated
    public void hatRabbit( Player player )
    {
        player.setPassenger( rabbit );
    }

    public void removeRabbit( Player player )
    {
        rabbit.remove();
    }

    public void bringRabbit( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        rabbit.teleport( location );
    }

    public void setBabyRabbit( Player player )
    {
        rabbit.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("rabbit") || config.getLastPet(player.getUniqueId() ).equals("babyrabbit") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babyrabbit" );

        rabbit = player.getWorld().spawn( player.getLocation(), Rabbit.class );
        rabbit.setCustomName( name );
        rabbit.setInvulnerable( true );
        rabbit.setCustomNameVisible( true );
        rabbit.setTarget( player );
        rabbit.setBaby();
        petSpawner.makePet( rabbit, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return rabbit.getLocation();
    }

    public void respawnRabbit( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babyrabbit") )
        {
            setBabyRabbit( player );
        }
        else
        {
            removeRabbit( player );
            spawnRabbit( player );
        }
    }
}