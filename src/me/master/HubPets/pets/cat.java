package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Player;

import java.util.UUID;

public class cat
{
    private ConfigManager config = new ConfigManager();
    private Cat cat;

    public void spawnCat(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("cat") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "cat" );

        cat = player.getWorld().spawn( player.getLocation(), Cat.class );
        cat.setCustomName( name );
        cat.setInvulnerable( true );
        cat.setCustomNameVisible( true );
        cat.setTarget( player );
        petSpawner.makePet( cat, player.getPlayer() );

    }

    @Deprecated
    public void rideCat( Player player )
    {
        cat.setPassenger( player );
    }

    @Deprecated
    public void hatCat( Player player )
    {
        player.setPassenger( cat );
    }

    public void removeCat( Player player )
    {
        cat.remove();
    }

    public void bringCat( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        cat.teleport( location );
    }

    public boolean babify()
    {
        return false;
    }

    public void setBabyCat( Player player )
    {
        cat.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("cat") || config.getLastPet(player.getUniqueId() ).equals("babycat") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babycat" );

        cat = player.getWorld().spawn( player.getLocation(), Cat.class );
        cat.setCustomName( name );
        cat.setInvulnerable( true );
        cat.setCustomNameVisible( true );
        cat.setTarget( player );
        cat.setBaby();
        petSpawner.makePet( cat, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return player.getLocation();
    }

    public void respawnCat( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babycat") )
        {
            setBabyCat( player );
        }
        else
        {
            removeCat( player );
            spawnCat( player );
        }
    }
}