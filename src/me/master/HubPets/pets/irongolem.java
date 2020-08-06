package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;

import java.util.UUID;

public class irongolem
{
    private ConfigManager config = new ConfigManager();
    private IronGolem irongolem;

    public void spawnIrongolem(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("irongolem") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "irongolem" );

        irongolem = player.getWorld().spawn( player.getLocation(), IronGolem.class );
        irongolem.setCustomName( name );
        irongolem.setInvulnerable( true );
        irongolem.setCustomNameVisible( true );
        irongolem.setTarget( player );
        petSpawner.makePet( irongolem, player.getPlayer() );

    }

    @Deprecated
    public void rideIrongolem( Player player )
    {
        irongolem.setPassenger( player );
    }

    @Deprecated
    public void hatIrongolem( Player player )
    {
        player.setPassenger( irongolem );
    }

    public void removeIrongolem( Player player )
    {
        irongolem.remove();
    }

    public void bringIrongolem( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        irongolem.teleport( location );
    }

    public Location getLocation(Player player )
    {
        return irongolem.getLocation();
    }

    public void respawnIrongolem( Player player )
    {
        irongolem.remove();
        spawnIrongolem( player );
    }
}