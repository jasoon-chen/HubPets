package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Player;

import java.util.UUID;

public class blaze
{
    private ConfigManager config = new ConfigManager();
    private Blaze blaze;

    public void spawnBlaze(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("blaze") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "blaze" );

        blaze = player.getWorld().spawn( player.getLocation(), Blaze.class );
        blaze.setCustomName( name );
        blaze.setInvulnerable( true );
        blaze.setCustomNameVisible( true );
        blaze.setTarget( player );
        petSpawner.makePet( blaze, player.getPlayer() );

    }

    @Deprecated
    public void rideBlaze( Player player )
    {
        blaze.setPassenger( player );
    }

    @Deprecated
    public void hatBlaze( Player player )
    {
        player.setPassenger( blaze );
    }

    public void removeBlaze( Player player )
    {
        blaze.remove();
    }

    public void bringBlaze( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        blaze.teleport( location );
    }

    public boolean babify()
    {
        return false;
    }

    public void respawnBlaze( Player player )
    {
        blaze.remove();
        spawnBlaze( player );
    }
    public Location getLocation(Player player )
    {
        return blaze.getLocation();
    }
}