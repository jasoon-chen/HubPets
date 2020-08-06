package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import java.util.UUID;

public class villager
{
    private ConfigManager config = new ConfigManager();
    private Villager villager;

    public void spawnVillager(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("villager") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "sheep" );

        villager = player.getWorld().spawn( player.getLocation(), Villager.class );
        villager.setCustomName( name );
        villager.setInvulnerable( true );
        villager.setCustomNameVisible( true );
        villager.setTarget( player );
        petSpawner.makePet( villager, player.getPlayer() );

    }

    @Deprecated
    public void rideVillager( Player player )
    {
        villager.setPassenger( player );
    }

    @Deprecated
    public void hatVillager( Player player )
    {
        player.setPassenger( villager );
    }

    public void removeVillager( Player player )
    {
        villager.remove();
    }

    public void bringVillager( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        villager.teleport( location );
    }

    public void setBabyVillager( Player player )
    {
        villager.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("villager") || config.getLastPet(player.getUniqueId() ).equals("babyvillager") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babyvillager" );

        villager = player.getWorld().spawn( player.getLocation(), Villager.class );
        villager.setCustomName( name );
        villager.setInvulnerable( true );
        villager.setCustomNameVisible( true );
        villager.setTarget( player );
        villager.setBaby();
        petSpawner.makePet( villager, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return villager.getLocation();
    }

    public void respawnVillager( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babyvillager") )
        {
            setBabyVillager( player );
        }
        else
        {
            removeVillager( player );
            spawnVillager( player );
        }
    }
}