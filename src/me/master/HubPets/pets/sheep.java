package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Player;

import java.util.UUID;

public class sheep
{
    private ConfigManager config = new ConfigManager();
    private Sheep sheep;

    public void spawnSheep(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("sheep") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "sheep" );

        sheep = player.getWorld().spawn( player.getLocation(), Sheep.class );
        sheep.setCustomName( name );
        sheep.setInvulnerable( true );
        sheep.setCustomNameVisible( true );
        sheep.setTarget( player );
        petSpawner.makePet( sheep, player.getPlayer() );

    }

    @Deprecated
    public void rideSheep( Player player )
    {
        sheep.setPassenger( player );
    }

    @Deprecated
    public void hatSheep( Player player )
    {
        player.setPassenger( sheep );
    }

    public void removeSheep( Player player )
    {
        sheep.remove();
    }

    public void bringSheep( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        sheep.teleport( location );
    }

    public void setBabySheep( Player player )
    {
        sheep.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("sheep") || config.getLastPet(player.getUniqueId() ).equals("babysheep") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babysheep" );

        sheep = player.getWorld().spawn( player.getLocation(), Sheep.class );
        sheep.setCustomName( name );
        sheep.setInvulnerable( true );
        sheep.setCustomNameVisible( true );
        sheep.setTarget( player );
        sheep.setBaby();
        petSpawner.makePet( sheep, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return sheep.getLocation();
    }

    public void respawnSheep( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babysheep") )
        {
            setBabySheep( player );
        }
        else
        {
            removeSheep( player );
            spawnSheep( player );
        }
    }
}