package me.master.HubPets.pets;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.petFunctions.petSpawner;

import org.bukkit.Location;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Player;

import java.util.UUID;

public class silverfish
{
    private ConfigManager config = new ConfigManager();
    private Silverfish silverfish;

    public void spawnSilverfish(Player player)
    {
        String name = player.getPlayer().getDisplayName() + "'s Pet";
        UUID uuid = player.getPlayer().getUniqueId();

        if( config.getLastPet(player.getUniqueId() ).equals("silverfish") )
        {
            if( !(config.getLastPetName( player.getUniqueId()).equals("none" )) )
            {
                name = config.getLastPetName( player.getPlayer().getUniqueId() );
            }
        }
        config.setLastPet( uuid, "blaze" );

        silverfish = player.getWorld().spawn( player.getLocation(), Silverfish.class );
        silverfish.setCustomName( name );
        silverfish.setInvulnerable( true );
        silverfish.setCustomNameVisible( true );
        silverfish.setTarget( player );
        petSpawner.makePet( silverfish, player.getPlayer() );

    }

    @Deprecated
    public void rideSilverfish( Player player )
    {
        silverfish.setPassenger( player );
    }

    @Deprecated
    public void hatSilverfish( Player player )
    {
        player.setPassenger( silverfish );
    }

    public void removeSilverfish( Player player )
    {
        silverfish.remove();
    }

    public void bringSilverfish( Player player )
    {
        Location location = player.getLocation().add( 3, 0, 0 );
        silverfish.teleport( location );
    }

    public boolean babify()
    {
        return false;
    }

    public void respawnSilverfish( Player player )
    {
        silverfish.remove();
        spawnSilverfish( player );
    }
    public Location getLocation(Player player )
    {
        return silverfish.getLocation();
    }
}