package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;

import java.util.UUID;

public class skeleton
{
    private ConfigManager config = new ConfigManager();
    private Skeleton skeleton;

    public void spawnSkeleton(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("skeleton") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "skeleton" );

        skeleton = player.getWorld().spawn( player.getLocation(), Skeleton.class );
        skeleton.setCustomName( name );
        skeleton.setInvulnerable( true );
        skeleton.setCustomNameVisible( true );
        skeleton.setTarget( player );
        petSpawner.makePet( skeleton, player.getPlayer() );

    }

    @Deprecated
    public void rideSkeleton( Player player )
    {
        skeleton.setPassenger( player );
    }

    @Deprecated
    public void hatSkeleton( Player player )
    {
        player.setPassenger( skeleton );
    }

    public void removeSkeleton( Player player )
    {
        skeleton.remove();
    }

    public void bringSkeleton( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        skeleton.teleport( location );
    }

    public Location getLocation(Player player )
    {
        return skeleton.getLocation();
    }

    public void respawnSkeleton( Player player )
    {
        skeleton.remove();
        spawnSkeleton( player );
    }
}