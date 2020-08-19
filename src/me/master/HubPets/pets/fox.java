package me.master.HubPets.pets;

import me.master.HubPets.petFunctions.petSpawner;
import me.master.HubPets.ymlManagement.ConfigManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Fox;

import java.util.UUID;

public class fox
{
    private ConfigManager config = new ConfigManager();
    private Fox fox;

    public void spawnFox(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("fox") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "fox" );

        fox = player.getWorld().spawn( player.getLocation(), Fox.class );
        fox.setCustomName( name );
        fox.setInvulnerable( true );
        fox.setCustomNameVisible( true );
        fox.setTarget( player );
        petSpawner.makePet( fox, player.getPlayer() );

    }

    @Deprecated
    public void rideFox( Player player )
    {
        fox.setPassenger( player );
    }

    @Deprecated
    public void hatFox( Player player )
    {
        player.setPassenger( fox );
    }

    public void removeFox( Player player )
    {
        fox.remove();
    }

    public void bringFox( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        fox.teleport( location );
    }

    public void setBabyFox( Player player )
    {
        fox.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("fox") || config.getLastPet(player.getUniqueId() ).equals("babyfox") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babyfox" );

        fox = player.getWorld().spawn( player.getLocation(), Fox.class );
        fox.setCustomName( name );
        fox.setInvulnerable( true );
        fox.setCustomNameVisible( true );
        fox.setTarget( player );
        fox.setBaby();
        petSpawner.makePet( fox, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return fox.getLocation();
    }

    public void respawnFox( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babyfox") )
        {
            setBabyFox( player );
        }
        else
        {
            removeFox( player );
            spawnFox( player );
        }
    }
}
