package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Player;

import java.util.UUID;

public class chicken
{
    private ConfigManager config = new ConfigManager();
    private Chicken chicken;

    public void spawnChicken(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("chicken") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "chicken" );

        chicken = player.getWorld().spawn( player.getLocation(), Chicken.class );
        chicken.setCustomName( name );
        chicken.setInvulnerable( true );
        chicken.setCustomNameVisible( true );
        chicken.setTarget( player );
        petSpawner.makePet( chicken, player.getPlayer() );

    }

    @Deprecated
    public void rideChicken( Player player )
    {
        chicken.setPassenger( player );
    }

    @Deprecated
    public void hatChicken( Player player )
    {
        player.setPassenger( chicken );
    }

    public void removeChicken( Player player )
    {
        chicken.remove();
    }

    public void bringChicken( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        chicken.teleport( location );
    }

    public void setBabyChicken( Player player )
    {
        chicken.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("chicken") || config.getLastPet(player.getUniqueId() ).equals("babychicken") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babychicken" );

        chicken = player.getWorld().spawn( player.getLocation(), Chicken.class );
        chicken.setCustomName( name );
        chicken.setInvulnerable( true );
        chicken.setCustomNameVisible( true );
        chicken.setTarget( player );
        chicken.setBaby();
        petSpawner.makePet( chicken, player.getPlayer() );
    }

    public boolean babify()
    {
        return false;
    }

    public Location getLocation(Player player )
    {
        return chicken.getLocation();
    }

    public void respawnChicken( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babychicken") )
        {
            setBabyChicken( player );
        }
        else
        {
            removeChicken( player );
            spawnChicken( player );
        }
    }
}