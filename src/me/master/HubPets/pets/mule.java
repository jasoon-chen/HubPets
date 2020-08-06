package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Mule;
import org.bukkit.entity.Player;

import java.util.UUID;

public class mule
{
    private ConfigManager config = new ConfigManager();
    private Mule mule;

    public void spawnMule(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("mule") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "mule" );

        mule = player.getWorld().spawn( player.getLocation(), Mule.class );
        mule.setCustomName( name );
        mule.setInvulnerable( true );
        mule.setCustomNameVisible( true );
        mule.setTarget( player );
        petSpawner.makePet( mule, player.getPlayer() );

    }

    @Deprecated
    public void rideMule( Player player )
    {
        mule.setPassenger( player );
    }

    @Deprecated
    public void hatMule( Player player )
    {
        player.setPassenger( mule );
    }

    public void removeMule( Player player )
    {
        mule.remove();
    }

    public void bringMule( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        mule.teleport( location );
    }

    public void setBabyMule( Player player )
    {
        mule.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("mule") || config.getLastPet(player.getUniqueId() ).equals("babymule") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babymule" );

        mule = player.getWorld().spawn( player.getLocation(), Mule.class );
        mule.setCustomName( name );
        mule.setInvulnerable( true );
        mule.setCustomNameVisible( true );
        mule.setTarget( player );
        mule.setBaby();
        petSpawner.makePet( mule, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return mule.getLocation();
    }

    public void respawnMule( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babymule") )
        {
            setBabyMule( player );
        }
        else
        {
            removeMule( player );
            spawnMule( player );
        }
    }
}
