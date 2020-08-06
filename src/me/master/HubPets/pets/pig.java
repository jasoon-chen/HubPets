package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;

import java.util.UUID;

public class pig
{
    private ConfigManager config = new ConfigManager();
    private Pig pig;

    public void spawnPig(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("pig") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "pig" );

        pig = player.getWorld().spawn( player.getLocation(), Pig.class );
        pig.setCustomName( name );
        pig.setInvulnerable( true );
        pig.setCustomNameVisible( true );
        pig.setTarget( player );
        petSpawner.makePet( pig, player.getPlayer() );

    }

    @Deprecated
    public void ridePig( Player player )
    {
        pig.setPassenger( player );
    }

    @Deprecated
    public void hatPig( Player player )
    {
        player.setPassenger( pig );
    }

    public void removePig( Player player )
    {
        pig.remove();
    }

    public void bringPig( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        pig.teleport( location );
    }

    public void setBabyPig( Player player )
    {
        pig.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("pig") || config.getLastPet(player.getUniqueId() ).equals("babypig") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babypig" );

        pig = player.getWorld().spawn( player.getLocation(), Pig.class );
        pig.setCustomName( name );
        pig.setInvulnerable( true );
        pig.setCustomNameVisible( true );
        pig.setTarget( player );
        pig.setBaby();
        petSpawner.makePet( pig, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return pig.getLocation();
    }

    public void respawnPig( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babypig") )
        {
            setBabyPig( player );
        }
        else
        {
            removePig( player );
            spawnPig( player );
        }
    }
}