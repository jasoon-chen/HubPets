package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;

import java.util.UUID;

public class cow
{
    private ConfigManager config = new ConfigManager();
    private Cow cow;

    public void spawnCow(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("cow") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "cow" );

        cow = player.getWorld().spawn( player.getLocation(), Cow.class );
        cow.setCustomName( name );
        cow.setInvulnerable( true );
        cow.setCustomNameVisible( true );
        cow.setTarget( player );
        petSpawner.makePet( cow, player.getPlayer() );

    }

    @Deprecated
    public void rideCow( Player player )
    {
        cow.setPassenger( player );
    }

    @Deprecated
    public void hatCow( Player player )
    {
        player.setPassenger( cow );
    }

    public void removeCow( Player player )
    {
        cow.remove();
    }

    public void bringCow( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        cow.teleport( location );
    }

    public void setBabyCow( Player player )
    {
        cow.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("cow") || config.getLastPet(player.getUniqueId() ).equals("babycow") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babycow" );

        cow = player.getWorld().spawn( player.getLocation(), Cow.class );
        cow.setCustomName( name );
        cow.setInvulnerable( true );
        cow.setCustomNameVisible( true );
        cow.setTarget( player );
        cow.setBaby();
        petSpawner.makePet( cow, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return cow.getLocation();
    }

    public void repsawnCow( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babycow") )
        {
            setBabyCow( player );
        }
        else
        {
            removeCow( player );
            spawnCow( player );
        }
    }
}
