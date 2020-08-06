package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Player;

import java.util.UUID;

public class zombie
{
    private ConfigManager config = new ConfigManager();
    private Zombie zombie;

    public void spawnZombie(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("zombie") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "zombie" );

        zombie = player.getWorld().spawn( player.getLocation(), Zombie.class );
        zombie.setCustomName( name );
        zombie.setInvulnerable( true );
        zombie.setCustomNameVisible( true );
        zombie.setTarget( player );
        petSpawner.makePet( zombie, player.getPlayer() );

    }

    @Deprecated
    public void rideZombie( Player player )
    {
        zombie.setPassenger( player );
    }

    @Deprecated
    public void hatZombie( Player player )
    {
        player.setPassenger( zombie );
    }

    public void removeZombie( Player player )
    {
        zombie.remove();
    }

    public void bringZombie( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        zombie.teleport( location );
    }

    public boolean babify()
    {
        return false;
    }

    public void setBabyZombie( Player player )
    {
        zombie.remove();
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("zombie") || config.getLastPet(player.getUniqueId() ).equals("babyzombie") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "babyzombie" );

        zombie = player.getWorld().spawn( player.getLocation(), Zombie.class );
        zombie.setCustomName( name );
        zombie.setInvulnerable( true );
        zombie.setCustomNameVisible( true );
        zombie.setTarget( player );
        zombie.setBaby( true );
        petSpawner.makePet( zombie, player.getPlayer() );
    }

    public Location getLocation(Player player )
    {
        return zombie.getLocation();
    }

    public void respawnZombie( Player player )
    {
        if( config.getLastPet( player.getUniqueId() ).equals("babyzombie") )
        {
            setBabyZombie( player );
        }
        else
        {
            removeZombie( player );
            spawnZombie( player );
        }
    }
}