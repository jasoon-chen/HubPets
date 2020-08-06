package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;

import java.util.UUID;

public class spider
{
    private ConfigManager config = new ConfigManager();
    private Spider spider;

    public void spawnSpider(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("spider") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "spider" );

        spider = player.getWorld().spawn( player.getLocation(), Spider.class );
        spider.setCustomName( name );
        spider.setInvulnerable( true );
        spider.setCustomNameVisible( true );
        spider.setTarget( player );
        petSpawner.makePet( spider, player.getPlayer() );

    }

    @Deprecated
    public void rideSpider( Player player )
    {
        spider.setPassenger( player );
    }

    @Deprecated
    public void hatSpider( Player player )
    {
        player.setPassenger( spider );
    }

    public void removeSpider( Player player )
    {
        spider.remove();
    }

    public void bringSpider( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        spider.teleport( location );
    }

    public void respawnSpider( Player player )
    {
        spider.remove();
        spawnSpider( player );
    }

    public Location getLocation(Player player )
    {
        return spider.getLocation();
    }
}