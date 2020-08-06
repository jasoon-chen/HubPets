package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Enderman;

import java.util.UUID;

public class enderman
{
    private ConfigManager config = new ConfigManager();
    private Enderman enderman;

    public void spawnEnderman(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("enderman") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "enderman" );

        enderman = player.getWorld().spawn( player.getLocation(), Enderman.class );
        enderman.setCustomName( name );
        enderman.setInvulnerable( true );
        enderman.setCustomNameVisible( true );
        enderman.setTarget( player );
        petSpawner.makePet( enderman, player.getPlayer() );

    }

    @Deprecated
    public void rideEnderman( Player player )
    {
        enderman.setPassenger( player );
    }

    @Deprecated
    public void hatEnderman( Player player )
    {
        player.setPassenger( enderman );
    }

    public void removeEnderman( Player player )
    {
        enderman.remove();
    }

    public void bringEnderman( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        enderman.teleport( location );
    }


    public void respawnEnderman( Player player )
    {
        enderman.remove();
        spawnEnderman( player );
    }

    public Location getLocation(Player player )
    {
        return enderman.getLocation();
    }
}