package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ocelot
{
    private ConfigManager config = new ConfigManager();
    private Ocelot ocelot;

    public void spawnOcelot(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("ocelot") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "ocelot" );

        ocelot = player.getWorld().spawn( player.getLocation(), Ocelot.class );
        ocelot.setCustomName( name );
        ocelot.setInvulnerable( true );
        ocelot.setCustomNameVisible( true );
        ocelot.setTarget( player );
        petSpawner.makePet( ocelot, player.getPlayer() );

    }

    @Deprecated
    public void rideOcelot( Player player )
    {
        ocelot.setPassenger( player );
    }

    @Deprecated
    public void hatOcelot( Player player )
    {
        player.setPassenger( ocelot );
    }

    public void removeOcelot( Player player )
    {
        ocelot.remove();
    }

    public void bringOcelot( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        ocelot.teleport( location );
    }

    public void setBabyOcelot( Player player )
    {
        ocelot.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("ocelot") || config.getLastPet(player.getUniqueId() ).equals("babyocelot") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babyocelot" );

        ocelot = player.getWorld().spawn( player.getLocation(), Ocelot.class );
        ocelot.setCustomName( name );
        ocelot.setInvulnerable( true );
        ocelot.setCustomNameVisible( true );
        ocelot.setTarget( player );
        ocelot.setBaby();
        petSpawner.makePet( ocelot, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return ocelot.getLocation();
    }

    public void respawnOcelot( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babyocelot") )
        {
            setBabyOcelot( player );
        }
        else
        {
            removeOcelot( player );
            spawnOcelot( player );
        }
    }
}