package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Player;

import java.util.UUID;

public class mooshroom
{
    private ConfigManager config = new ConfigManager();
    private MushroomCow mooshroom;

    public void spawnMooshroom(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("mooshroom") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "mooshroom" );

        mooshroom = player.getWorld().spawn( player.getLocation(), MushroomCow.class );
        mooshroom.setCustomName( name );
        mooshroom.setInvulnerable( true );
        mooshroom.setCustomNameVisible( true );
        mooshroom.setTarget( player );
        petSpawner.makePet( mooshroom, player.getPlayer() );

    }

    @Deprecated
    public void rideMooshroom( Player player )
    {
        mooshroom.setPassenger( player );
    }

    @Deprecated
    public void hatMooshroom( Player player )
    {
        player.setPassenger( mooshroom );
    }

    public void removeMooshroom( Player player )
    {
        mooshroom.remove();
    }

    public void bringMooshroom( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        mooshroom.teleport( location );
    }

    public void setBabyMooshroom( Player player )
    {
        mooshroom.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("mooshroom") || config.getLastPet(player.getUniqueId() ).equals("babymooshroom") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babymooshroom" );

        mooshroom = player.getWorld().spawn( player.getLocation(), MushroomCow.class );
        mooshroom.setCustomName( name );
        mooshroom.setInvulnerable( true );
        mooshroom.setCustomNameVisible( true );
        mooshroom.setTarget( player );
        mooshroom.setBaby();
        petSpawner.makePet( mooshroom, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return mooshroom.getLocation();
    }

    public void respawnMooshroom( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babymooshroom") )
        {
            setBabyMooshroom( player );
        }
        else
        {
            removeMooshroom( player );
            spawnMooshroom( player );
        }
    }
}
