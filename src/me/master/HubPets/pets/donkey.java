package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Donkey;
import org.bukkit.entity.Player;

import java.util.UUID;

public class donkey
{
    private ConfigManager config = new ConfigManager();
    private Donkey donkey;

    public void spawnDonkey(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("donkey") ||  config.getLastPet(player.getUniqueId() ).equals("babydonkey") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "donkey" );

        donkey = player.getWorld().spawn( player.getLocation(), Donkey.class );
        donkey.setCustomName( name );
        donkey.setInvulnerable( true );
        donkey.setCustomNameVisible( true );
        donkey.setTarget( player );
        petSpawner.makePet( donkey, player.getPlayer() );

    }

    @Deprecated
    public void rideDonkey( Player player )
    {
        donkey.setPassenger( player );
    }

    @Deprecated
    public void hatDonkey( Player player )
    {
        player.setPassenger( donkey );
    }

    public void removeDonkey( Player player )
    {
        donkey.remove();
    }

    public void bringDonkey( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        donkey.teleport( location );
    }

    public void setBabyDonkey( Player player )
    {
        donkey.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("donkey") || config.getLastPet(player.getUniqueId() ).equals("babydonkey") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babydonkey" );

        donkey = player.getWorld().spawn( player.getLocation(), Donkey.class );
        donkey.setCustomName( name );
        donkey.setInvulnerable( true );
        donkey.setCustomNameVisible( true );
        donkey.setTarget( player );
        donkey.setBaby();
        petSpawner.makePet( donkey, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return donkey.getLocation();
    }

    public void respawnDonkey( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babydonkey") )
        {
            setBabyDonkey( player );
        }
        else
        {
            removeDonkey( player );
            spawnDonkey( player );
        }
    }
}