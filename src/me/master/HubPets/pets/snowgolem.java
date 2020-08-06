package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;

import java.util.UUID;

public class snowgolem
{
    private ConfigManager config = new ConfigManager();
    private Snowman snowgolem;

    public void spawnGolem(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("snowgolem") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "snowgolem" );

        snowgolem = player.getWorld().spawn( player.getLocation(), Snowman.class );
        snowgolem.setCustomName( name );
        snowgolem.setInvulnerable( true );
        snowgolem.setCustomNameVisible( true );
        snowgolem.setTarget( player );
        petSpawner.makePet( snowgolem, player.getPlayer() );

    }

    @Deprecated
    public void rideGolem( Player player )
    {
        snowgolem.setPassenger( player );
    }

    @Deprecated
    public void hatGolem( Player player )
    {
        player.setPassenger( snowgolem );
    }

    public void removeGolem( Player player )
    {
        snowgolem.remove();
    }

    public void bringGolem( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        snowgolem.teleport( location );
    }

    public Location getLocation(Player player )
    {
        return snowgolem.getLocation();
    }

    public void respawnGolem( Player player )
    {
        snowgolem.remove();
        spawnGolem( player );
    }
}