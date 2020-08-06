package me.master.HubPets.petFunctions;

import me.master.HubPets.HubPetsMAIN;
import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.ymlManagement.mainConfigManager;
import me.master.HubPets.pets.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public class petListener implements Listener
{
    private creeper creeper = new creeper();
    private witch witch = new witch();
    private cat cat = new cat();
    private chicken chicken = new chicken();
    private horse horse = new horse();
    private cow cow = new cow();
    private mooshroom mooshroom = new mooshroom();
    private ocelot ocelot = new ocelot();
    private pig pig = new pig();
    private rabbit rabbit = new rabbit();
    private sheep sheep = new sheep();
    private snowgolem snowgolem = new snowgolem();
    private enderman enderman = new enderman();
    private villager villager = new villager();
    private irongolem irongolem = new irongolem();
    private spider spider = new spider();
    private wolf wolf = new wolf();
    private blaze blaze = new blaze();
    private donkey donkey = new donkey();
    private skeleton skeleton = new skeleton();
    private mule mule = new mule();
    private witherskeleton witherskeleton = new witherskeleton();
    private zombie zombie = new zombie();
    private silverfish silverfish = new silverfish();

    private ArrayList<UUID> uuid = new ArrayList<UUID>();
    private ArrayList<String> pet123 = new ArrayList<String>();

    public ConfigManager config = new ConfigManager();
    public mainConfigManager config1 = new mainConfigManager();

    @EventHandler
    public void InvenClick( InventoryClickEvent event )
    {
        Player player = (Player) event.getWhoClicked();
        InventoryView open = event.getView();
        ItemStack item = event.getCurrentItem();

        if (open == null)
        {
            return;
        }

        if (open.getTitle().equals( "Pet Selector" ) )
        {
            event.setCancelled(true);

            if (item == null || !item.hasItemMeta())
            {
                return;
            }

            // Select items without selecting a pet
            if ( item.getItemMeta().getDisplayName().equals( "§eBabyify" ) && config.getLastPet( player.getUniqueId() ).equals("none" ) )
            {
                player.closeInventory();
                player.sendMessage( "§8[§cHubPets§8] §6You do not have a selected pet. Do /pets to select a pet." );
                return;
            }

            if ( item.getItemMeta().getDisplayName().equals( "§eName" ) && config.getLastPet( player.getUniqueId() ).equals("none" ) )
            {
                player.closeInventory();
                player.sendMessage( "§8[§cHubPets§8] §6You do not have a selected pet. Do /pets to select a pet." );
                return;
            }

            if ( item.getItemMeta().getDisplayName().equals( "§eSit" ) && config.getLastPet( player.getUniqueId() ).equals("none" ) )
            {
                player.closeInventory();
                player.sendMessage( "§8[§cHubPets§8] §6You do not have a selected pet. Do /pets to select a pet." );
                return;
            }

            if ( item.getItemMeta().getDisplayName().equals( "§eHat" ) && config.getLastPet( player.getUniqueId() ).equals("none" ) )
            {
                player.closeInventory();
                player.sendMessage( "§8[§cHubPets§8] §6You do not have a selected pet. Do /pets to select a pet." );
                return;
            }

            if ( item.getItemMeta().getDisplayName().equals( "§eBring" ) && config.getLastPet( player.getUniqueId() ).equals("none" ) )
            {
                player.closeInventory();
                player.sendMessage( "§8[§cHubPets§8] §6You do not have a selected pet. Do /pets to select a pet." );
                return;
            }

            if ( item.getItemMeta().getDisplayName().equals( "§eRemove" ) && config.getLastPet( player.getUniqueId() ).equals("none" ) )
            {
                player.closeInventory();
                player.sendMessage( "§8[§cHubPets§8] §6You do not have a selected pet. Do /pets to select a pet." );
                return;
            }

            if ( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet( player.getUniqueId() ).equals("none" ) )
            {
                player.closeInventory();
                player.sendMessage( "§8[§cHubPets§8] §6You do not have a selected pet. Do /pets to select a pet." );
                return;
            }

            // Creeper =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aCreeper Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.creeper") || player.hasPermission( "hubpets.pet.type.creeper.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        creeper.spawnCreeper(player);
                        config.setLastPet(player.getUniqueId(), "creeper");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Creeper Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Creeper Pet." );
                    return;
                }
            }

            // Creeper - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "creeper" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.creeper.babify" ) || player.hasPermission( "hubpets.pet.type.creeper.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Creeper does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Creeper Pet." );
                    return;
                }
            }

            // Creeper - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "creeper" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.creeper.name" ) || player.hasPermission( "hubpets.pet.type.creeper.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Creeper Pet." );
                    return;
                }
            }

            // Creeper - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "creeper" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.creeper.sit" ) || player.hasPermission( "hubpets.pet.type.creeper.*") )
                {
                    player.closeInventory();
                    creeper.rideCreeper( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Creeper Pet." );
                    return;
                }
            }

            // Creeper - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "creeper" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.creeper.hat" ) || player.hasPermission( "hubpets.pet.type.creeper.*") )
                {
                    player.closeInventory();
                    creeper.hatCreeper( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Creeper Pet." );
                    return;
                }
            }

            // Creeper - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "creeper" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.creeper.bring" ) || player.hasPermission( "hubpets.pet.type.creeper.*") )
                {
                    player.closeInventory();
                    creeper.bringCreeper( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Creeper Pet." );
                    return;
                }
            }

            // Creeper - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "creeper" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.creeper.remove" ) || player.hasPermission( "hubpets.pet.type.creeper.*") )
                {
                    player.closeInventory();
                    creeper.removeCreeper( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Creeper Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Creeper Pet." );
                    return;
                }
            }

            // Creeper - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "creeper" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.creeper.respawn" ) || player.hasPermission( "hubpets.pet.type.creeper.*") )
                {
                    player.closeInventory();
                    creeper.respawnCreeper( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Creeper Pet." );
                    return;
                }
            }

            // Witch =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aWitch Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witch") || player.hasPermission( "hubpets.pet.type.witch.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        witch.spawnWitch(player);
                        config.setLastPet(player.getUniqueId(), "witch");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Witch Pet.");
                        player.closeInventory();
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Witch Pet." );
                    return;
                }
            }

            // Witch - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "witch" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witch.babify" ) || player.hasPermission( "hubpets.pet.type.witch.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Witch does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Witch Pet." );
                    return;
                }
            }

            // Witch - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "witch" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witch.name" ) || player.hasPermission( "hubpets.pet.type.witch.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Witch Pet." );
                    return;
                }
            }

            // Witch - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "witch" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witch.sit" ) || player.hasPermission( "hubpets.pet.type.witch.*") )
                {
                    player.closeInventory();
                    witch.rideWitch( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Witch Pet." );
                    return;
                }
            }

            // Witch - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "witch" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witch.hat" ) || player.hasPermission( "hubpets.pet.type.witch.*") )
                {
                    player.closeInventory();
                    witch.hatWitch( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Witch Pet." );
                    return;
                }
            }

            // Witch - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "witch" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witch.bring" ) || player.hasPermission( "hubpets.pet.type.witch.*") )
                {
                    player.closeInventory();
                    witch.bringWitch( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Witch Pet." );
                    return;
                }
            }

            // Witch - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "witch" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witch.remove" ) || player.hasPermission( "hubpets.pet.type.witch.*") )
                {
                    player.closeInventory();
                    witch.removeWitch( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Witch Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Witch Pet." );
                    return;
                }
            }

            // Witch - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "witch" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witch.respawn" ) || player.hasPermission( "hubpets.pet.type.witch.*") )
                {
                    player.closeInventory();
                    witch.respawnWitch( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Witch Pet." );
                    return;
                }
            }

            // Cat =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aCat Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.cat") || player.hasPermission( "hubpets.pet.type.cat.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        cat.spawnCat(player);
                        config.setLastPet(player.getUniqueId(), "cat");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Cat Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Cat Pet." );
                    return;
                }
            }

            // Cat - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "cat" ) || config.getLastPet(player.getUniqueId()).equals( "babycat" )))
            {
                if( player.hasPermission( "hubpets.pet.type.cat.babify" ) || player.hasPermission( "hubpets.pet.type.cat.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babycat") )
                    {
                        player.closeInventory();
                        cat.removeCat( player );
                        cat.spawnCat( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully change your Baby Cat to a regular Cat." );
                        return;
                    }
                    player.closeInventory();
                    cat.removeCat( player );
                    cat.setBabyCat( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Cat to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Cat Pet." );
                    return;
                }
            }

            // Cat - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "cat" ) || config.getLastPet(player.getUniqueId()).equals( "babycat" )))
            {
                if( player.hasPermission( "hubpets.pet.type.cat.name" ) || player.hasPermission( "hubpets.pet.type.cat.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Cat Pet." );
                    return;
                }
            }

            // Cat - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "cat" ) || config.getLastPet(player.getUniqueId()).equals( "babycat" )))
            {
                if( player.hasPermission( "hubpets.pet.type.cat.sit" ) || player.hasPermission( "hubpets.pet.type.cat.*") )
                {
                    player.closeInventory();
                    cat.rideCat( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Cat Pet." );
                    return;
                }
            }

            // Cat - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "cat" ) || config.getLastPet(player.getUniqueId()).equals( "babycat" )))
            {
                if( player.hasPermission( "hubpets.pet.type.cat.hat" ) || player.hasPermission( "hubpets.pet.type.cat.*") )
                {
                    player.closeInventory();
                    cat.hatCat( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Cat Pet." );
                    return;
                }
            }

            // Cat - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "cat" ) || config.getLastPet(player.getUniqueId()).equals( "babycat" )))
            {
                if( player.hasPermission( "hubpets.pet.type.cat.bring" ) || player.hasPermission( "hubpets.pet.type.cat.*") )
                {
                    player.closeInventory();
                    cat.bringCat( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Cat Pet." );
                    return;
                }
            }

            // Cat - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "cat" ) || config.getLastPet(player.getUniqueId()).equals( "babycat" )))
            {
                if( player.hasPermission( "hubpets.pet.type.cat.remove" ) || player.hasPermission( "hubpets.pet.type.cat.*") )
                {
                    player.closeInventory();
                    cat.removeCat( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Cat Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Cat Pet." );
                    return;
                }
            }

            // Cat - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "cat" ) || config.getLastPet(player.getUniqueId()).equals( "babycat" )))
            {
                if( player.hasPermission( "hubpets.pet.type.cat.respawn" ) || player.hasPermission( "hubpets.pet.type.cat.*") )
                {
                    player.closeInventory();
                    cat.respawnCat( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Cat Pet." );
                    return;
                }
            }

            // Chicken =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aChicken Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.chicken") || player.hasPermission( "hubpets.pet.type.chicken.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        chicken.spawnChicken(player);
                        config.setLastPet(player.getUniqueId(), "chicken");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Cat Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Cat Pet." );
                    return;
                }
            }

            // Chicken - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "chicken" ) || config.getLastPet(player.getUniqueId()).equals( "babychicken" )))
            {
                if( player.hasPermission( "hubpets.pet.type.chicken.babify" ) || player.hasPermission( "hubpets.pet.type.chicken.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babychicken") )
                    {
                        player.closeInventory();
                        chicken.removeChicken( player );
                        chicken.spawnChicken( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Chicken to a regular Chicken." );
                        return;
                    }
                    player.closeInventory();
                    chicken.removeChicken( player );
                    chicken.setBabyChicken( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Chicken to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Cat Pet." );
                    return;
                }
            }

            // Chicken - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "chicken" ) || config.getLastPet(player.getUniqueId()).equals( "babychicken" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.chicken.name" ) || player.hasPermission( "hubpets.pet.type.chicken.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Chicken Pet." );
                    return;
                }
            }

            // Chicken - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "chicken" ) || config.getLastPet(player.getUniqueId()).equals( "babychicken" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.chicken.sit" ) || player.hasPermission( "hubpets.pet.type.chicken.*") )
                {
                    player.closeInventory();
                    chicken.rideChicken( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Chicken Pet." );
                    return;
                }
            }

            // Chicken - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "chicken" ) || config.getLastPet(player.getUniqueId()).equals( "babychicken" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.chicken.hat" ) || player.hasPermission( "hubpets.pet.type.chicken.*") )
                {
                    player.closeInventory();
                    chicken.hatChicken( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Chicken Pet." );
                    return;
                }
            }

            // Chicken - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "chicken" ) || config.getLastPet(player.getUniqueId()).equals( "babychicken" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.chicken.bring" ) || player.hasPermission( "hubpets.pet.type.chicken.*") )
                {
                    player.closeInventory();
                    chicken.bringChicken( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Chicken Pet." );
                    return;
                }
            }

            // Chicken - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "chicken" ) || config.getLastPet(player.getUniqueId()).equals( "babychicken" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.chicken.remove" ) || player.hasPermission( "hubpets.pet.type.chicken.*") )
                {
                    player.closeInventory();
                    chicken.removeChicken( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Chicken Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Chicken Pet." );
                    return;
                }
            }

            // Chicken - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "chicken" ) || config.getLastPet(player.getUniqueId()).equals( "babychicken" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.chicken.respawn" ) || player.hasPermission( "hubpets.pet.type.chicken.*") )
                {
                    player.closeInventory();
                    chicken.respawnChicken( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Chicken Pet." );
                    return;
                }
            }

            // Horse =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aHorse Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.horse") || player.hasPermission( "hubpets.pet.type.horse.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        horse.spawnHorse(player);
                        config.setLastPet(player.getUniqueId(), "horse");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Horse Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Horse Pet." );
                    return;
                }
            }

            // Horse - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "horse" ) || config.getLastPet(player.getUniqueId()).equals( "babyhorse" )))
            {
                if( player.hasPermission( "hubpets.pet.type.horse.babify" ) || player.hasPermission( "hubpets.pet.type.horse.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babyhorse") )
                    {
                        player.closeInventory();
                        horse.removeHorse( player );
                        horse.spawnHorse( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Horse to a regular Horse." );
                        return;
                    }
                    player.closeInventory();
                    horse.removeHorse( player );
                    horse.setBabyHorse( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Horse to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Horse Pet." );
                    return;
                }
            }

            // Horse - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "horse" ) || config.getLastPet(player.getUniqueId()).equals( "babyhorse" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.horse.name" ) || player.hasPermission( "hubpets.pet.type.horse.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Chicken Pet." );
                    return;
                }
            }

            // Horse - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "horse" ) || config.getLastPet(player.getUniqueId()).equals( "babyhorse" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.horse.sit" ) || player.hasPermission( "hubpets.pet.type.horse.*") )
                {
                    player.closeInventory();
                    horse.rideHorse( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Horse Pet." );
                    return;
                }
            }

            // Horse - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "horse" ) || config.getLastPet(player.getUniqueId()).equals( "babyhorse" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.horse.hat" ) || player.hasPermission( "hubpets.pet.type.horse.*") )
                {
                    player.closeInventory();
                    horse.hatHorse( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Horse Pet." );
                    return;
                }
            }

            // Horse - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "horse" ) || config.getLastPet(player.getUniqueId()).equals( "babyhorse" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.horse.bring" ) || player.hasPermission( "hubpets.pet.type.horse.*") )
                {
                    player.closeInventory();
                    horse.bringHorse( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Horse Pet." );
                    return;
                }
            }

            // Horse - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "horse" ) || config.getLastPet(player.getUniqueId()).equals( "babyhorse" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.horse.remove" ) || player.hasPermission( "hubpets.pet.type.horse.*") )
                {
                    player.closeInventory();
                    horse.removeHorse( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Horse Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Horse Pet." );
                    return;
                }
            }

            // Horse - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "horse" ) || config.getLastPet(player.getUniqueId()).equals( "babyhorse" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.horse.respawn" ) || player.hasPermission( "hubpets.pet.type.horse.*") )
                {
                    player.closeInventory();
                    horse.respawnHorse( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Horse Pet." );
                    return;
                }
            }

            // Cow =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aCow Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.cow") || player.hasPermission( "hubpets.pet.type.cow.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        cow.spawnCow(player);
                        config.setLastPet(player.getUniqueId(), "cow");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Cow Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Horse Pet." );
                    return;
                }
            }

            // Cow - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "cow" ) || config.getLastPet(player.getUniqueId()).equals( "babycow" )))
            {
                if( player.hasPermission( "hubpets.pet.type.cow.babify" ) || player.hasPermission( "hubpets.pet.type.cow.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babycow") )
                    {
                        player.closeInventory();
                        cow.removeCow( player );
                        cow.spawnCow( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Cow to a regular Cow." );
                        return;
                    }
                    player.closeInventory();
                    cow.removeCow( player );
                    cow.setBabyCow( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Cow to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Cow Pet." );
                    return;
                }
            }

            // Cow - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "cow" ) || config.getLastPet(player.getUniqueId()).equals( "babycow" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.cow.name" ) || player.hasPermission( "hubpets.pet.type.cow.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Cow Pet." );
                    return;
                }
            }

            // Cow - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "cow" ) || config.getLastPet(player.getUniqueId()).equals( "babycow" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.cow.sit" ) || player.hasPermission( "hubpets.pet.type.cow.*") )
                {
                    player.closeInventory();
                    cow.rideCow( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Cow Pet." );
                    return;
                }
            }

            // Cow - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "cow" ) || config.getLastPet(player.getUniqueId()).equals( "babycow" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.cow.hat" ) || player.hasPermission( "hubpets.pet.type.cow.*") )
                {
                    player.closeInventory();
                    cow.hatCow( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Cow Pet." );
                    return;
                }
            }

            // Cow - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "cow" ) || config.getLastPet(player.getUniqueId()).equals( "babycow" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.cow.bring" ) || player.hasPermission( "hubpets.pet.type.cow.*") )
                {
                    player.closeInventory();
                    cow.bringCow( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Cow Pet." );
                    return;
                }
            }

            // Cow - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "cow" ) || config.getLastPet(player.getUniqueId()).equals( "babycow" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.cow.remove" ) || player.hasPermission( "hubpets.pet.type.cow.*") )
                {
                    player.closeInventory();
                    cow.removeCow( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Cow Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Cow Pet." );
                    return;
                }
            }

            // Cow - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "cow" ) || config.getLastPet(player.getUniqueId()).equals( "babycow" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.cow.respawn" ) || player.hasPermission( "hubpets.pet.type.cow.*") )
                {
                    player.closeInventory();
                    cow.repsawnCow( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Cow Pet." );
                    return;
                }
            }

            // Mooshroom  =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aMooshroom Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.mooshroom") || player.hasPermission( "hubpets.pet.type.mooshroom.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        mooshroom.spawnMooshroom(player);
                        config.setLastPet(player.getUniqueId(), "mooshroom");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Mooshroom Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Mooshroom Pet." );
                    return;
                }
            }

            // Mooshroom - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "mooshroom" ) || config.getLastPet(player.getUniqueId()).equals( "babymooshroom" )))
            {
                if( player.hasPermission( "hubpets.pet.type.mooshroom.babify" ) || player.hasPermission( "hubpets.pet.type.mooshroom.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babymooshroom") )
                    {
                        player.closeInventory();
                        mooshroom.removeMooshroom( player );
                        mooshroom.spawnMooshroom( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Cow to a regular Cow." );
                        return;
                    }
                    player.closeInventory();
                    mooshroom.removeMooshroom( player );
                    mooshroom.setBabyMooshroom( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Mooshroom to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Mooshroom Pet." );
                    return;
                }
            }

            // Mooshroom - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "mooshroom" ) || config.getLastPet(player.getUniqueId()).equals( "babymooshroom" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.mooshroom.name" ) || player.hasPermission( "hubpets.pet.type.mooshroom.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Mooshroom Pet." );
                    return;
                }
            }

            // Mooshroom - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "mooshroom" ) || config.getLastPet(player.getUniqueId()).equals( "babymooshroom" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.mooshroom.sit" ) || player.hasPermission( "hubpets.pet.type.mooshroom.*") )
                {
                    player.closeInventory();
                    mooshroom.rideMooshroom( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Mooshroom Pet." );
                    return;
                }
            }

            // Mooshroom - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "mooshroom" ) || config.getLastPet(player.getUniqueId()).equals( "babymooshroom" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.mooshroom.hat" ) || player.hasPermission( "hubpets.pet.type.mooshroom.*") )
                {
                    player.closeInventory();
                    mooshroom.hatMooshroom( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Mooshroom Pet." );
                    return;
                }
            }

            // Mooshroom - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "mooshroom" ) || config.getLastPet(player.getUniqueId()).equals( "babymooshroom" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.mooshroom.bring" ) || player.hasPermission( "hubpets.pet.type.mooshroom.*") )
                {
                    player.closeInventory();
                    mooshroom.bringMooshroom( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Mooshroom Pet." );
                    return;
                }
            }

            // Mooshroom - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "mooshroom" ) || config.getLastPet(player.getUniqueId()).equals( "babymooshroom" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.mooshroom.remove" ) || player.hasPermission( "hubpets.pet.type.mooshroom.*") )
                {
                    player.closeInventory();
                    mooshroom.removeMooshroom( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Mooshroom Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Mooshroom Pet." );
                    return;
                }
            }

            // Mooshroom - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "mooshroom" ) || config.getLastPet(player.getUniqueId()).equals( "babymooshroom" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.mooshroom.respawn" ) || player.hasPermission( "hubpets.pet.type.mooshroom.*") )
                {
                    player.closeInventory();
                    mooshroom.respawnMooshroom( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Mooshroom Pet." );
                    return;
                }
            }

            // Ocelot  =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aOcelot Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.ocelot") || player.hasPermission( "hubpets.pet.type.ocelot.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        ocelot.spawnOcelot(player);
                        config.setLastPet(player.getUniqueId(), "ocelot");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Ocelot Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Ocelot Pet." );
                    return;
                }
            }

            // Ocelot - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "ocelot" ) || config.getLastPet(player.getUniqueId()).equals( "babyocelot" )))
            {
                if( player.hasPermission( "hubpets.pet.type.ocelot.babify" ) || player.hasPermission( "hubpets.pet.type.ocelot.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babyocelot") )
                    {
                        player.closeInventory();
                        ocelot.removeOcelot( player );
                        ocelot.spawnOcelot( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Ocelot to a regular Ocelot." );
                        return;
                    }
                    player.closeInventory();
                    ocelot.removeOcelot( player );
                    ocelot.setBabyOcelot( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Ocelot to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Mooshroom Pet." );
                    return;
                }
            }

            // Ocelot - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "ocelot" ) || config.getLastPet(player.getUniqueId()).equals( "babyocelot" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.ocelot.name" ) || player.hasPermission( "hubpets.pet.type.ocelot.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Ocelot Pet." );
                    return;
                }
            }

            // Ocelot - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "ocelot" ) || config.getLastPet(player.getUniqueId()).equals( "babyocelot" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.ocelot.sit" ) || player.hasPermission( "hubpets.pet.type.ocelot.*") )
                {
                    player.closeInventory();
                    ocelot.rideOcelot( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Ocelot Pet." );
                    return;
                }
            }

            // Ocelot - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "ocelot" ) || config.getLastPet(player.getUniqueId()).equals( "babyocelot" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.ocelot.hat" ) || player.hasPermission( "hubpets.pet.type.ocelot.*") )
                {
                    player.closeInventory();
                    ocelot.hatOcelot( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Ocelot Pet." );
                    return;
                }
            }

            // Ocelot - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "ocelot" ) || config.getLastPet(player.getUniqueId()).equals( "babyocelot" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.ocelot.bring" ) || player.hasPermission( "hubpets.pet.type.ocelot.*") )
                {
                    player.closeInventory();
                    ocelot.bringOcelot( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Ocelot Pet." );
                    return;
                }
            }

            // Ocelot - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "ocelot" ) || config.getLastPet(player.getUniqueId()).equals( "babyocelot" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.ocelot.remove" ) || player.hasPermission( "hubpets.pet.type.ocelot.*") )
                {
                    player.closeInventory();
                    ocelot.removeOcelot( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Ocelot Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Ocelot Pet." );
                    return;
                }
            }

            // Ocelot - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "ocelot" ) || config.getLastPet(player.getUniqueId()).equals( "babymooshroom" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.ocelot.respawn" ) || player.hasPermission( "hubpets.pet.type.ocelot.*") )
                {
                    player.closeInventory();
                    ocelot.respawnOcelot( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Ocelot Pet." );
                    return;
                }
            }

            // Pig  =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aPig Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.pig") || player.hasPermission( "hubpets.pet.type.pig.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        pig.spawnPig(player);
                        config.setLastPet(player.getUniqueId(), "pig");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Pig Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Pig Pet." );
                    return;
                }
            }

            // Pig - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "pig" ) || config.getLastPet(player.getUniqueId()).equals( "babypig" )))
            {
                if( player.hasPermission( "hubpets.pet.type.pig.babify" ) || player.hasPermission( "hubpets.pet.type.pig.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babypig") )
                    {
                        player.closeInventory();
                        pig.removePig( player );
                        pig.spawnPig( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Pig to a regular Pig." );
                        return;
                    }
                    player.closeInventory();
                    pig.removePig( player );
                    pig.setBabyPig( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Pig to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Pig Pet." );
                    return;
                }
            }

            // Pig - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "pig" ) || config.getLastPet(player.getUniqueId()).equals( "babypig" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.pig.name" ) || player.hasPermission( "hubpets.pet.type.pig.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Pig Pet." );
                    return;
                }
            }

            // Pig - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "pig" ) || config.getLastPet(player.getUniqueId()).equals( "babypig" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.pig.sit" ) || player.hasPermission( "hubpets.pet.type.pig.*") )
                {
                    player.closeInventory();
                    pig.ridePig( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Pig Pet." );
                    return;
                }
            }

            // Pig - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "pig" ) || config.getLastPet(player.getUniqueId()).equals( "babypig" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.pig.hat" ) || player.hasPermission( "hubpets.pet.type.pig.*") )
                {
                    player.closeInventory();
                    pig.hatPig( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Pig Pet." );
                    return;
                }
            }

            // Pig - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "pig" ) || config.getLastPet(player.getUniqueId()).equals( "babypig" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.pig.bring" ) || player.hasPermission( "hubpets.pet.type.pig.*") )
                {
                    player.closeInventory();
                    pig.bringPig( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Pig Pet." );
                    return;
                }
            }

            // Pig - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "pig" ) || config.getLastPet(player.getUniqueId()).equals( "babypig" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.pig.remove" ) || player.hasPermission( "hubpets.pet.type.pig.*") )
                {
                    player.closeInventory();
                    pig.removePig( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Pig Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Pig Pet." );
                    return;
                }
            }

            // Pig - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "pig" ) || config.getLastPet(player.getUniqueId()).equals( "babypig" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.pig.respawn" ) || player.hasPermission( "hubpets.pet.type.pig.*") )
                {
                    player.closeInventory();
                    pig.respawnPig( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Pig Pet." );
                    return;
                }
            }

            // Rabbit  =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aRabbit Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.rabbit") || player.hasPermission( "hubpets.pet.type.rabbit.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        rabbit.spawnRabbit(player);
                        config.setLastPet(player.getUniqueId(), "rabbit");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Rabbit Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Rabbit Pet." );
                    return;
                }
            }

            // Rabbit - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "rabbit" ) || config.getLastPet(player.getUniqueId()).equals( "babyrabbit" )))
            {
                if( player.hasPermission( "hubpets.pet.type.rabbit.babify" ) || player.hasPermission( "hubpets.pet.type.rabbit.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babyrabbit") )
                    {
                        player.closeInventory();
                        rabbit.removeRabbit( player );
                        rabbit.spawnRabbit( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Rabbit to a regular Rabbit." );
                        return;
                    }
                    player.closeInventory();
                    rabbit.removeRabbit( player );
                    rabbit.setBabyRabbit( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Rabbit to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Rabbit Pet." );
                    return;
                }
            }

            // Rabbit - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "rabbit" ) || config.getLastPet(player.getUniqueId()).equals( "babyrabbit" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.rabbit.name" ) || player.hasPermission( "hubpets.pet.type.rabbit.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Rabbit Pet." );
                    return;
                }
            }

            // Rabbit - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "rabbit" ) || config.getLastPet(player.getUniqueId()).equals( "babyrabbit" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.rabbit.sit" ) || player.hasPermission( "hubpets.pet.type.rabbit.*") )
                {
                    player.closeInventory();
                    rabbit.rideRabbit( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Rabbit Pet." );
                    return;
                }
            }

            // Rabbit - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "rabbit" ) || config.getLastPet(player.getUniqueId()).equals( "babyrabbit" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.rabbit.hat" ) || player.hasPermission( "hubpets.pet.type.rabbit.*") )
                {
                    player.closeInventory();
                    rabbit.hatRabbit( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Rabbit Pet." );
                    return;
                }
            }

            // Rabbit - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "rabbit" ) || config.getLastPet(player.getUniqueId()).equals( "babyrabbit" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.rabbit.bring" ) || player.hasPermission( "hubpets.pet.type.rabbit.*") )
                {
                    player.closeInventory();
                    rabbit.bringRabbit( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Rabbit Pet." );
                    return;
                }
            }

            // Rabbit - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "rabbit" ) || config.getLastPet(player.getUniqueId()).equals( "babyrabbit" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.rabbit.remove" ) || player.hasPermission( "hubpets.pet.type.rabbit.*") )
                {
                    player.closeInventory();
                    rabbit.removeRabbit( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Rabbit Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Pig Pet." );
                    return;
                }
            }

            // Rabbit - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "rabbit" ) || config.getLastPet(player.getUniqueId()).equals( "babyrabbit" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.rabbit.respawn" ) || player.hasPermission( "hubpets.pet.type.rabbit.*") )
                {
                    player.closeInventory();
                    rabbit.respawnRabbit( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Rabbit Pet." );
                    return;
                }
            }

            // Sheep  =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aSheep Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.sheep") || player.hasPermission( "hubpets.pet.type.sheep.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        sheep.spawnSheep(player);
                        config.setLastPet(player.getUniqueId(), "sheep");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Sheep Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Sheep Pet." );
                    return;
                }
            }

            // Sheep - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "sheep" ) || config.getLastPet(player.getUniqueId()).equals( "babysheep" )))
            {
                if( player.hasPermission( "hubpets.pet.type.sheep.babify" ) || player.hasPermission( "hubpets.pet.type.sheep.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babysheep") )
                    {
                        player.closeInventory();
                        sheep.removeSheep( player );
                        sheep.spawnSheep( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Sheep to a regular Sheep." );
                        return;
                    }
                    player.closeInventory();
                    sheep.removeSheep( player );
                    sheep.setBabySheep( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Sheep to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Rabbit Pet." );
                    return;
                }
            }

            // Sheep - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "sheep" ) || config.getLastPet(player.getUniqueId()).equals( "babysheep" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.sheep.name" ) || player.hasPermission( "hubpets.pet.type.sheep.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Sheep Pet." );
                    return;
                }
            }

            // Sheep - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "sheep" ) || config.getLastPet(player.getUniqueId()).equals( "babysheep" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.sheep.sit" ) || player.hasPermission( "hubpets.pet.type.sheep.*") )
                {
                    player.closeInventory();
                    sheep.rideSheep( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Sheep Pet." );
                    return;
                }
            }

            // Sheep - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "sheep" ) || config.getLastPet(player.getUniqueId()).equals( "babysheep" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.sheep.hat" ) || player.hasPermission( "hubpets.pet.type.sheep.*") )
                {
                    player.closeInventory();
                    sheep.hatSheep( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Sheep Pet." );
                    return;
                }
            }

            // Sheep - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "sheep" ) || config.getLastPet(player.getUniqueId()).equals( "babysheep" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.sheep.bring" ) || player.hasPermission( "hubpets.pet.type.sheep.*") )
                {
                    player.closeInventory();
                    sheep.bringSheep( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Sheep Pet." );
                    return;
                }
            }

            // Sheep - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "sheep" ) || config.getLastPet(player.getUniqueId()).equals( "babysheep" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.sheep.remove" ) || player.hasPermission( "hubpets.pet.type.sheep.*") )
                {
                    player.closeInventory();
                    sheep.removeSheep( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Sheep Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Sheep Pet." );
                    return;
                }
            }

            // Sheep - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "sheep" ) || config.getLastPet(player.getUniqueId()).equals( "babysheep" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.sheep.respawn" ) || player.hasPermission( "hubpets.pet.type.sheep.*") )
                {
                    player.closeInventory();
                    sheep.respawnSheep( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Sheep Pet." );
                    return;
                }
            }

            // Snowman =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aSnow Golem Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.snowgolem") || player.hasPermission( "hubpets.pet.type.snowgolem.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        snowgolem.spawnGolem(player);
                        config.setLastPet(player.getUniqueId(), "snowgolem");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Snowgolem Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Snowgolem Pet." );
                    return;
                }
            }

            // Snowman - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "snowgolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.snowgolem.babify" ) || player.hasPermission( "hubpets.pet.type.snowgolem.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Snowgolem does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Snowgolem Pet." );
                    return;
                }
            }

            // Snowman - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "snowgolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.snowgolem.name" ) || player.hasPermission( "hubpets.pet.type.snowgolem.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Snowgolem Pet." );
                    return;
                }
            }

            // Snowman - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "snowgolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.snowgolem.sit" ) || player.hasPermission( "hubpets.pet.type.snowgolem.*") )
                {
                    player.closeInventory();
                    snowgolem.rideGolem( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Snowgolem Pet." );
                    return;
                }
            }

            // Snowman - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "snowgolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.snowgolem.hat" ) || player.hasPermission( "hubpets.pet.type.snowgolem.*") )
                {
                    player.closeInventory();
                    snowgolem.hatGolem( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Snowgolem Pet." );
                    return;
                }
            }

            // Snowman - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "snowgolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.snowgolem.bring" ) || player.hasPermission( "hubpets.pet.type.snowgolem.*") )
                {
                    player.closeInventory();
                    snowgolem.bringGolem( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Snowgolem Pet." );
                    return;
                }
            }

            // Snowman - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "snowgolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.snowgolem.remove" ) || player.hasPermission( "hubpets.pet.type.snowgolem.*") )
                {
                    player.closeInventory();
                    snowgolem.removeGolem( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Snowgolem Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Snowgolem Pet." );
                    return;
                }
            }

            // Snowman - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "snowgolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.snowgolem.respawn" ) || player.hasPermission( "hubpets.pet.type.snowgolem.*") )
                {
                    player.closeInventory();
                    snowgolem.respawnGolem( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Snowgolem Pet." );
                    return;
                }
            }

            // Villager  =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aVillager Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.villager") || player.hasPermission( "hubpets.pet.type.villager.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        villager.spawnVillager(player);
                        config.setLastPet(player.getUniqueId(), "villager");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Villager Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Villager Pet." );
                    return;
                }
            }

            // Villager - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "villager" ) || config.getLastPet(player.getUniqueId()).equals( "babyvillager" )))
            {
                if( player.hasPermission( "hubpets.pet.type.villager.babify" ) || player.hasPermission( "hubpets.pet.type.villager.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babysheep") )
                    {
                        player.closeInventory();
                        villager.removeVillager( player );
                        villager.spawnVillager( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Villager to a regular Villager." );
                        return;
                    }
                    player.closeInventory();
                    villager.removeVillager( player );
                    villager.setBabyVillager( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Villager to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Villager Pet." );
                    return;
                }
            }

            // Villager - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "villager" ) || config.getLastPet(player.getUniqueId()).equals( "babyvillager" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.villager.name" ) || player.hasPermission( "hubpets.pet.type.villager.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Villager Pet." );
                    return;
                }
            }

            // Villager - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "villager" ) || config.getLastPet(player.getUniqueId()).equals( "babyvillager" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.villager.sit" ) || player.hasPermission( "hubpets.pet.type.villager.*") )
                {
                    player.closeInventory();
                    villager.rideVillager( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Villager Pet." );
                    return;
                }
            }

            // Villager - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "villager" ) || config.getLastPet(player.getUniqueId()).equals( "babyvillager" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.villager.hat" ) || player.hasPermission( "hubpets.pet.type.villager.*") )
                {
                    player.closeInventory();
                    villager.hatVillager( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Villager Pet." );
                    return;
                }
            }

            // Villager - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "villager" ) || config.getLastPet(player.getUniqueId()).equals( "babyvillager" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.villager.bring" ) || player.hasPermission( "hubpets.pet.type.villager.*") )
                {
                    player.closeInventory();
                    villager.bringVillager( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Villager Pet." );
                    return;
                }
            }

            // Villager - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "villager" ) || config.getLastPet(player.getUniqueId()).equals( "babyvillager" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.villager.remove" ) || player.hasPermission( "hubpets.pet.type.villager.*") )
                {
                    player.closeInventory();
                    villager.removeVillager( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Villager Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Villager Pet." );
                    return;
                }
            }

            // Villager - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "villager" ) || config.getLastPet(player.getUniqueId()).equals( "babyvillager" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.villager.respawn" ) || player.hasPermission( "hubpets.pet.type.villager.*") )
                {
                    player.closeInventory();
                    villager.respawnVillager( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Villager Pet." );
                    return;
                }
            }

            // Enderman =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aEnderman Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.enderman") || player.hasPermission( "hubpets.pet.type.enderman.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        enderman.spawnEnderman(player);
                        config.setLastPet(player.getUniqueId(), "enderman");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Enderman Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Enderman Pet." );
                    return;
                }
            }

            // Enderman - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "enderman" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.enderman.babify" ) || player.hasPermission( "hubpets.pet.type.enderman.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Enderman does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Enderman Pet." );
                    return;
                }
            }

            // Enderman - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "enderman" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.enderman.name" ) || player.hasPermission( "hubpets.pet.type.enderman.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Enderman Pet." );
                    return;
                }
            }

            // Enderman - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "enderman" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.enderman.sit" ) || player.hasPermission( "hubpets.pet.type.enderman.*") )
                {
                    player.closeInventory();
                    enderman.rideEnderman( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Enderman Pet." );
                    return;
                }
            }

            // Enderman - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "enderman" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.enderman.hat" ) || player.hasPermission( "hubpets.pet.type.enderman.*") )
                {
                    player.closeInventory();
                    enderman.hatEnderman( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Enderman Pet." );
                    return;
                }
            }

            // Enderman - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "enderman" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.enderman.bring" ) || player.hasPermission( "hubpets.pet.type.enderman.*") )
                {
                    player.closeInventory();
                    enderman.bringEnderman( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Enderman Pet." );
                    return;
                }
            }

            // Enderman - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "enderman" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.enderman.remove" ) || player.hasPermission( "hubpets.pet.type.enderman.*") )
                {
                    player.closeInventory();
                    enderman.removeEnderman( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Enderman Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Enderman Pet." );
                    return;
                }
            }

            // Enderman - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "enderman" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.enderman.respawn" ) || player.hasPermission( "hubpets.pet.type.enderman.*") )
                {
                    player.closeInventory();
                    enderman.respawnEnderman( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Enderman Pet." );
                    return;
                }
            }

            // Irongolem =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aIrongolem Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.irongolem") || player.hasPermission( "hubpets.pet.type.irongolem.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        irongolem.spawnIrongolem(player);
                        config.setLastPet(player.getUniqueId(), "irongolem");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Irongolem Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Irongolem Pet." );
                    return;
                }
            }

            // Irongolem - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "irongolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.irongolem.babify" ) || player.hasPermission( "hubpets.pet.type.irongolem.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Irongolem does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Irongolem Pet." );
                    return;
                }
            }

            // Irongolem - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "irongolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.irongolem.name" ) || player.hasPermission( "hubpets.pet.type.irongolem.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Irongolem Pet." );
                    return;
                }
            }

            // Irongolem - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "irongolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.irongolem.sit" ) || player.hasPermission( "hubpets.pet.type.irongolem.*") )
                {
                    player.closeInventory();
                    irongolem.rideIrongolem( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Irongolem Pet." );
                    return;
                }
            }

            // Irongolem - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "irongolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.irongolem.hat" ) || player.hasPermission( "hubpets.pet.type.irongolem.*") )
                {
                    player.closeInventory();
                    irongolem.hatIrongolem( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Irongolem Pet." );
                    return;
                }
            }

            // Irongolem - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "irongolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.irongolem.bring" ) || player.hasPermission( "hubpets.pet.type.irongolem.*") )
                {
                    player.closeInventory();
                    irongolem.bringIrongolem( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Irongolem Pet." );
                    return;
                }
            }

            // Irongolem - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "irongolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.irongolem.remove" ) || player.hasPermission( "hubpets.pet.type.irongolem.*") )
                {
                    player.closeInventory();
                    irongolem.removeIrongolem( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Irongolem Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Irongolem Pet." );
                    return;
                }
            }

            // Irongolem - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "irongolem" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.irongolem.respawn" ) || player.hasPermission( "hubpets.pet.type.irongolem.*") )
                {
                    player.closeInventory();
                    irongolem.respawnIrongolem( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Irongolem Pet." );
                    return;
                }
            }

            // Spider =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aSpider Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.spider") || player.hasPermission( "hubpets.pet.type.spider.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        spider.spawnSpider(player);
                        config.setLastPet(player.getUniqueId(), "spider");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Spider Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Spider Pet." );
                    return;
                }
            }

            // Spider - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "spider" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.spider.babify" ) || player.hasPermission( "hubpets.pet.type.spider.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Spider does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Spider Pet." );
                    return;
                }
            }

            // Spider - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "spider" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.spider.name" ) || player.hasPermission( "hubpets.pet.type.spider.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Spider Pet." );
                    return;
                }
            }

            // Spider - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "spider" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.spider.sit" ) || player.hasPermission( "hubpets.pet.type.spider.*") )
                {
                    player.closeInventory();
                    spider.rideSpider( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Spider Pet." );
                    return;
                }
            }

            // Spider - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "spider" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.spider.hat" ) || player.hasPermission( "hubpets.pet.type.spider.*") )
                {
                    player.closeInventory();
                    spider.hatSpider( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Spider Pet." );
                    return;
                }
            }

            // Spider - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "spider" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.spider.bring" ) || player.hasPermission( "hubpets.pet.type.spider.*") )
                {
                    player.closeInventory();
                    spider.bringSpider( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Spider Pet." );
                    return;
                }
            }

            // Spider - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "spider" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.spider.remove" ) || player.hasPermission( "hubpets.pet.type.spider.*") )
                {
                    player.closeInventory();
                    spider.removeSpider( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Spider Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Irongolem Pet." );
                    return;
                }
            }

            // Spider - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "spider" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.spider.respawn" ) || player.hasPermission( "hubpets.pet.type.spider.*") )
                {
                    player.closeInventory();
                    spider.respawnSpider( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Spider Pet." );
                    return;
                }
            }

            // Wolf  =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aWolf Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.wolf") || player.hasPermission( "hubpets.pet.type.wolf.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        wolf.spawnWolf(player);
                        config.setLastPet(player.getUniqueId(), "wolf");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Wolf Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Wolf Pet." );
                    return;
                }
            }

            // Wolf - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "wolf" ) || config.getLastPet(player.getUniqueId()).equals( "babywolf" )))
            {
                if( player.hasPermission( "hubpets.pet.type.wolf.babify" ) || player.hasPermission( "hubpets.pet.type.wolf.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babywolf") )
                    {
                        player.closeInventory();
                        wolf.removeWolf( player );
                        wolf.spawnWolf( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully changed your baby Wolf to a regular Wolf." );
                        return;
                    }
                    player.closeInventory();
                    wolf.removeWolf( player );
                    wolf.setBabyWolf( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Wolf to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Wolf Pet." );
                    return;
                }
            }

            // Wolf - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "wolf" ) || config.getLastPet(player.getUniqueId()).equals( "babywolf" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.wolf.name" ) || player.hasPermission( "hubpets.pet.type.wolf.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Wolf Pet." );
                    return;
                }
            }

            // Wolf - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "wolf" ) || config.getLastPet(player.getUniqueId()).equals( "babywolf" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.wolf.sit" ) || player.hasPermission( "hubpets.pet.type.wolf.*") )
                {
                    player.closeInventory();
                    wolf.rideWolf( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Wolf Pet." );
                    return;
                }
            }

            // Wolf - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "wolf" ) || config.getLastPet(player.getUniqueId()).equals( "babywolf" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.wolf.hat" ) || player.hasPermission( "hubpets.pet.type.wolf.*") )
                {
                    player.closeInventory();
                    wolf.hatWolf( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Wolf Pet." );
                    return;
                }
            }

            // Wolf - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "wolf" ) || config.getLastPet(player.getUniqueId()).equals( "babywolf" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.wolf.bring" ) || player.hasPermission( "hubpets.pet.type.wolf.*") )
                {
                    player.closeInventory();
                    wolf.bringWolf( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Wolf Pet." );
                    return;
                }
            }

            // Wolf - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "wolf" ) || config.getLastPet(player.getUniqueId()).equals( "babywolf" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.wolf.remove" ) || player.hasPermission( "hubpets.pet.type.wolf.*") )
                {
                    player.closeInventory();
                    wolf.removeWolf( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Wolf Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Villager Pet." );
                    return;
                }
            }

            // Wolf - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "wolf" ) || config.getLastPet(player.getUniqueId()).equals( "babywolf" )) )
            {
                if( player.hasPermission( "hubpets.pet.type.wolf.respawn" ) || player.hasPermission( "hubpets.pet.type.wolf.*") )
                {
                    player.closeInventory();
                    wolf.respawnWolf( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Wolf Pet." );
                    return;
                }
            }

            // Blaze =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aBlaze Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.blaze") || player.hasPermission( "hubpets.pet.type.blaze.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        blaze.spawnBlaze(player);
                        config.setLastPet(player.getUniqueId(), "blaze");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Blaze Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Blaze Pet." );
                    return;
                }
            }

            // Blaze - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "blaze" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.blaze.babify" ) || player.hasPermission( "hubpets.pet.type.blaze.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Blaze does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Blaze Pet." );
                    return;
                }
            }

            // Blaze - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "blaze" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.blaze.name" ) || player.hasPermission( "hubpets.pet.type.blaze.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Blaze Pet." );
                    return;
                }
            }

            // Blaze - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "blaze" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.blaze.sit" ) || player.hasPermission( "hubpets.pet.type.blaze.*") )
                {
                    player.closeInventory();
                    blaze.rideBlaze( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Blaze Pet." );
                    return;
                }
            }

            // Blaze - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "blaze" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.blaze.hat" ) || player.hasPermission( "hubpets.pet.type.blaze.*") )
                {
                    player.closeInventory();
                    blaze.hatBlaze( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Blaze Pet." );
                    return;
                }
            }

            // Blaze - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "blaze" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.blaze.bring" ) || player.hasPermission( "hubpets.pet.type.blaze.*") )
                {
                    player.closeInventory();
                    blaze.bringBlaze( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Blaze Pet." );
                    return;
                }
            }

            // Blaze - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "blaze" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.blaze.remove" ) || player.hasPermission( "hubpets.pet.type.blaze.*") )
                {
                    player.closeInventory();
                    blaze.removeBlaze( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Blaze Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Irongolem Pet." );
                    return;
                }
            }

            // Blaze - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "blaze" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.blaze.respawn" ) || player.hasPermission( "hubpets.pet.type.blaze.*") )
                {
                    player.closeInventory();
                    blaze.respawnBlaze( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Blaze Pet." );
                    return;
                }
            }

            // Donkey =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aDonkey Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.donkey") || player.hasPermission( "hubpets.pet.type.donkey.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        donkey.spawnDonkey(player);
                        config.setLastPet(player.getUniqueId(), "donkey");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Donkey Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Donkey Pet." );
                    return;
                }
            }

            // Donkey - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "donkey" ) || config.getLastPet(player.getUniqueId()).equals( "babydonkey" )))
            {
                if( player.hasPermission( "hubpets.pet.type.donkey.babify" ) || player.hasPermission( "hubpets.pet.type.donkey.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babydonkey") )
                    {
                        player.closeInventory();
                        donkey.removeDonkey( player );
                        donkey.spawnDonkey( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully change your Baby Donkey to a regular Donkey." );
                        return;
                    }
                    player.closeInventory();
                    donkey.removeDonkey( player );
                    donkey.setBabyDonkey( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Donkey to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Donkey Pet." );
                    return;
                }
            }

            // Donkey - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "donkey" ) || config.getLastPet(player.getUniqueId()).equals( "babydonkey" )))
            {
                if( player.hasPermission( "hubpets.pet.type.donkey.name" ) || player.hasPermission( "hubpets.pet.type.donkey.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Donkey Pet." );
                    return;
                }
            }

            // Donkey - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "donkey" ) || config.getLastPet(player.getUniqueId()).equals( "babydonkey" )))
            {
                if( player.hasPermission( "hubpets.pet.type.donkey.sit" ) || player.hasPermission( "hubpets.pet.type.donkey.*") )
                {
                    player.closeInventory();
                    donkey.rideDonkey( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Donkey Pet." );
                    return;
                }
            }

            // Donkey - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "donkey" ) || config.getLastPet(player.getUniqueId()).equals( "babydonkey" )))
            {
                if( player.hasPermission( "hubpets.pet.type.donkey.hat" ) || player.hasPermission( "hubpets.pet.type.donkey.*") )
                {
                    player.closeInventory();
                    donkey.hatDonkey( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Donkey Pet." );
                    return;
                }
            }

            // Donkey - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "donkey" ) || config.getLastPet(player.getUniqueId()).equals( "babydonkey" )))
            {
                if( player.hasPermission( "hubpets.pet.type.donkey.bring" ) || player.hasPermission( "hubpets.pet.type.donkey.*") )
                {
                    player.closeInventory();
                    donkey.bringDonkey( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Donkey Pet." );
                    return;
                }
            }

            // Donkey - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "donkey" ) || config.getLastPet(player.getUniqueId()).equals( "babydonkey" )))
            {
                if( player.hasPermission( "hubpets.pet.type.donkey.remove" ) || player.hasPermission( "hubpets.pet.type.donkey.*") )
                {
                    player.closeInventory();
                    donkey.removeDonkey( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Donkey Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Donkey Pet." );
                    return;
                }
            }

            // Donkey - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "donkey" ) || config.getLastPet(player.getUniqueId()).equals( "babydonkey" )))
            {
                if( player.hasPermission( "hubpets.pet.type.donkey.respawn" ) || player.hasPermission( "hubpets.pet.type.donkey.*") )
                {
                    player.closeInventory();
                    donkey.respawnDonkey( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Donkey Pet." );
                    return;
                }
            }

            // Skeleton =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aSkeleton Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.skeleton") || player.hasPermission( "hubpets.pet.type.skeleton.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        skeleton.spawnSkeleton(player);
                        config.setLastPet(player.getUniqueId(), "skeleton");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Skeleton Pet.");
                        player.closeInventory();
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Skeleton Pet." );
                    return;
                }
            }

            // Skeleton - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "skeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.skeleton.babify" ) || player.hasPermission( "hubpets.pet.type.skeleton.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Skeleton does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Skeleton Pet." );
                    return;
                }
            }

            // Skeleton - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "skeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.skeleton.name" ) || player.hasPermission( "hubpets.pet.type.skeleton.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Skeleton Pet." );
                    return;
                }
            }

            // Skeleton - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "skeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.skeleton.sit" ) || player.hasPermission( "hubpets.pet.type.skeleton.*") )
                {
                    player.closeInventory();
                    skeleton.rideSkeleton( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Skeleton Pet." );
                    return;
                }
            }

            // Skeleton - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "skeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.skeleton.hat" ) || player.hasPermission( "hubpets.pet.type.skeleton.*") )
                {
                    player.closeInventory();
                    skeleton.hatSkeleton( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Skeleton Pet." );
                    return;
                }
            }

            // Skeleton - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "skeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.skeleton.bring" ) || player.hasPermission( "hubpets.pet.type.skeleton.*") )
                {
                    player.closeInventory();
                    skeleton.bringSkeleton( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Skeleton Pet." );
                    return;
                }
            }

            // Skeleton - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "skeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.skeleton.remove" ) || player.hasPermission( "hubpets.pet.type.skeleton.*") )
                {
                    player.closeInventory();
                    skeleton.removeSkeleton( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Skeleton Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Skeleton Pet." );
                    return;
                }
            }

            // Skeleton - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "skeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.skeleton.respawn" ) || player.hasPermission( "hubpets.pet.type.skeleton.*") )
                {
                    player.closeInventory();
                    skeleton.respawnSkeleton( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Skeleton Pet." );
                    return;
                }
            }

            // Mule =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aMule Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.mule") || player.hasPermission( "hubpets.pet.type.mule.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        mule.spawnMule(player);
                        config.setLastPet(player.getUniqueId(), "mule");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Mule Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Mule Pet." );
                    return;
                }
            }

            // Mule - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "mule" ) || config.getLastPet(player.getUniqueId()).equals( "babymule" )))
            {
                if( player.hasPermission( "hubpets.pet.type.mule.babify" ) || player.hasPermission( "hubpets.pet.type.mule.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babymule") )
                    {
                        player.closeInventory();
                        mule.removeMule( player );
                        mule.spawnMule( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully change your Baby Mule to a regular Mule." );
                        return;
                    }
                    player.closeInventory();
                    mule.removeMule( player );
                    mule.setBabyMule( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Mule to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Mule Pet." );
                    return;
                }
            }

            // Mule - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "mule" ) || config.getLastPet(player.getUniqueId()).equals( "babymule" )))
            {
                if( player.hasPermission( "hubpets.pet.type.mule.name" ) || player.hasPermission( "hubpets.pet.type.mule.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Mule Pet." );
                    return;
                }
            }

            // Mule - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "mule" ) || config.getLastPet(player.getUniqueId()).equals( "babymule" )))
            {
                if( player.hasPermission( "hubpets.pet.type.mule.sit" ) || player.hasPermission( "hubpets.pet.type.mule.*") )
                {
                    player.closeInventory();
                    mule.rideMule( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Mule Pet." );
                    return;
                }
            }

            // Mule - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "mule" ) || config.getLastPet(player.getUniqueId()).equals( "babymule" )))
            {
                if( player.hasPermission( "hubpets.pet.type.mule.hat" ) || player.hasPermission( "hubpets.pet.type.mule.*") )
                {
                    player.closeInventory();
                    mule.hatMule( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Mule Pet." );
                    return;
                }
            }

            // Mule - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "mule" ) || config.getLastPet(player.getUniqueId()).equals( "babymule" )))
            {
                if( player.hasPermission( "hubpets.pet.type.mule.bring" ) || player.hasPermission( "hubpets.pet.type.mule.*") )
                {
                    player.closeInventory();
                    mule.bringMule( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Mule Pet." );
                    return;
                }
            }

            // Mule - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "mule" ) || config.getLastPet(player.getUniqueId()).equals( "babymule" )))
            {
                if( player.hasPermission( "hubpets.pet.type.mule.remove" ) || player.hasPermission( "hubpets.pet.type.mule.*") )
                {
                    player.closeInventory();
                    mule.removeMule( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Mule Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Mule Pet." );
                    return;
                }
            }

            // Mule - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "mule" ) || config.getLastPet(player.getUniqueId()).equals( "babymule" )))
            {
                if( player.hasPermission( "hubpets.pet.type.mule.respawn" ) || player.hasPermission( "hubpets.pet.type.mule.*") )
                {
                    player.closeInventory();
                    mule.respawnMule( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Mule Pet." );
                    return;
                }
            }

            // Wither Skeleton =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aWither Skeleton Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witherskeleton") || player.hasPermission( "hubpets.pet.type.witherskeleton.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        witherskeleton.spawnWitherskeleton(player);
                        config.setLastPet(player.getUniqueId(), "witherskeleton");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Wither Skeleton Pet.");
                        player.closeInventory();
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Wither Skeleton Pet." );
                    return;
                }
            }

            // Wither Skeleton - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "witherskeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witherskeleton.babify" ) || player.hasPermission( "hubpets.pet.type.witherskeleton.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Wither Skeleton does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Wither Skeleton Pet." );
                    return;
                }
            }

            // Wither Skeleton - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "witherskeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witherskeleton.name" ) || player.hasPermission( "hubpets.pet.type.witherskeleton.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Wither Skeleton Pet." );
                    return;
                }
            }

            // Wither Skeleton - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "witherskeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witherskeleton.sit" ) || player.hasPermission( "hubpets.pet.type.witherskeleton.*") )
                {
                    player.closeInventory();
                    witherskeleton.rideWitherskeleton( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Wither Skeleton Pet." );
                    return;
                }
            }

            // Wither Skeleton - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "witherskeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witherskeleton.hat" ) || player.hasPermission( "hubpets.pet.type.witherskeleton.*") )
                {
                    player.closeInventory();
                    witherskeleton.hatWitherskeleton( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Wither Skeleton Pet." );
                    return;
                }
            }

            // Wither Skeleton - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "witherskeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witherskeleton.bring" ) || player.hasPermission( "hubpets.pet.type.witherskeleton.*") )
                {
                    player.closeInventory();
                    witherskeleton.bringWitherskeleton( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Wither Skeleton Pet." );
                    return;
                }
            }

            // Wither Skeleton - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "witherskeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witherskeleton.remove" ) || player.hasPermission( "hubpets.pet.type.witherskeleton.*") )
                {
                    player.closeInventory();
                    witherskeleton.removeWitherskeleton( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Wither Skeleton Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Wither Skeleton Pet." );
                    return;
                }
            }

            // Wither Skeleton - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "witherskeleton" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.witherskeleton.respawn" ) || player.hasPermission( "hubpets.pet.type.witherskeleton.*") )
                {
                    player.closeInventory();
                    witherskeleton.respawnWitherskeleton( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Wither Skeleton Pet." );
                    return;
                }
            }

            // Zombie =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aZombie Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.zombie") || player.hasPermission( "hubpets.pet.type.zombie.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        zombie.spawnZombie(player);
                        config.setLastPet(player.getUniqueId(), "zombie");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Zombie Pet.");
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Zombie Pet." );
                    return;
                }
            }

            // Zombie - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && (config.getLastPet(player.getUniqueId()).equals( "zombie" ) || config.getLastPet(player.getUniqueId()).equals( "babyzombie" )))
            {
                if( player.hasPermission( "hubpets.pet.type.zombie.babify" ) || player.hasPermission( "hubpets.pet.type.zombie.*") )
                {
                    if( config.getLastPet( player.getUniqueId()).equals("babyzombie") )
                    {
                        player.closeInventory();
                        zombie.removeZombie( player );
                        zombie.spawnZombie( player );
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully change your Baby Zombie to a regular Zombie." );
                        return;
                    }
                    player.closeInventory();
                    zombie.removeZombie( player );
                    zombie.setBabyZombie( player );
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully set the Zombie to a baby." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Zombie Pet." );
                    return;
                }
            }

            // Zombie - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && (config.getLastPet(player.getUniqueId()).equals( "zombie" ) || config.getLastPet(player.getUniqueId()).equals( "babyzombie" )))
            {
                if( player.hasPermission( "hubpets.pet.type.zombie.name" ) || player.hasPermission( "hubpets.pet.type.zombie.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Mule Pet." );
                    return;
                }
            }

            // Zombie - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && (config.getLastPet(player.getUniqueId()).equals( "zombie" ) || config.getLastPet(player.getUniqueId()).equals( "babyzombie" )))
            {
                if( player.hasPermission( "hubpets.pet.type.zombie.sit" ) || player.hasPermission( "hubpets.pet.type.zombie.*") )
                {
                    player.closeInventory();
                    zombie.rideZombie( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Zombie Pet." );
                    return;
                }
            }

            // Zombie - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && (config.getLastPet(player.getUniqueId()).equals( "zombie" ) || config.getLastPet(player.getUniqueId()).equals( "babyzombie" )))
            {
                if( player.hasPermission( "hubpets.pet.type.zombie.hat" ) || player.hasPermission( "hubpets.pet.type.zombie.*") )
                {
                    player.closeInventory();
                    zombie.hatZombie( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Zombie Pet." );
                    return;
                }
            }

            // Zombie - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && (config.getLastPet(player.getUniqueId()).equals( "zombie" ) || config.getLastPet(player.getUniqueId()).equals( "babyzombie" )))
            {
                if( player.hasPermission( "hubpets.pet.type.zombie.bring" ) || player.hasPermission( "hubpets.pet.type.zombie.*") )
                {
                    player.closeInventory();
                    zombie.bringZombie( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Zombie Pet." );
                    return;
                }
            }

            // Zombie - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && (config.getLastPet(player.getUniqueId()).equals( "zombie" ) || config.getLastPet(player.getUniqueId()).equals( "babyzombie" )))
            {
                if( player.hasPermission( "hubpets.pet.type.zombie.remove" ) || player.hasPermission( "hubpets.pet.type.zombie.*") )
                {
                    player.closeInventory();
                    zombie.removeZombie( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Zombie Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Zombie Pet." );
                    return;
                }
            }

            // Zombie - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && (config.getLastPet(player.getUniqueId()).equals( "zombie" ) || config.getLastPet(player.getUniqueId()).equals( "babyzombie" )))
            {
                if( player.hasPermission( "hubpets.pet.type.zombie.respawn" ) || player.hasPermission( "hubpets.pet.type.zombie.*") )
                {
                    player.closeInventory();
                    zombie.respawnZombie( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Zombie Pet." );
                    return;
                }
            }

            // Silverfish =========================================================================================================================
            if ( item.getItemMeta().getDisplayName().equals( "§aSilverfish Pet" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.silverfish") || player.hasPermission( "hubpets.pet.type.silverfish.*"))
                {
                    if( config.getLastPet( player.getUniqueId() ).equals("none") )
                    {
                        silverfish.spawnSilverfish(player);
                        config.setLastPet(player.getUniqueId(), "silverfish");
                        config.savePlayers();
                        config.reloadPlayers();
                        player.sendMessage( "§8[§cHubPets§8] §6Successfully spawned in the Silverfish Pet.");
                        player.closeInventory();
                        return;
                    }
                    else
                    {
                        player.closeInventory();
                        player.sendMessage( "§8[§cHubPets§8] §6You have already selected your pet " + config.getLastPet( player.getUniqueId() ) + " . Remove your pet to select another pet.");
                        return;
                    }
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to spawn the Silverfish Pet." );
                    return;
                }
            }

            // Silverfish - Babify
            if( item.getItemMeta().getDisplayName().equals( "§eBabyify") && config.getLastPet(player.getUniqueId()).equals( "silverfish" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.silverfish.babify" ) || player.hasPermission( "hubpets.pet.type.silverfish.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Silverfish does not support the babify feature." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to babify the Silverfish Pet." );
                    return;
                }
            }

            // Silverfish - Name
            if( item.getItemMeta().getDisplayName().equals( "§eName") && config.getLastPet(player.getUniqueId()).equals( "silverfish" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.silverfish.name" ) || player.hasPermission( "hubpets.pet.type.silverfish.*") )
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6Do /pet name <PETNAME> to name your pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to name the Silverfish Pet." );
                    return;
                }
            }

            // Silverfish - Sit
            if( item.getItemMeta().getDisplayName().equals( "§eSit") && config.getLastPet(player.getUniqueId()).equals( "silverfish" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.silverfish.sit" ) || player.hasPermission( "hubpets.pet.type.silverfish.*") )
                {
                    player.closeInventory();
                    silverfish.rideSilverfish( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to sit on the Silverfish Pet." );
                    return;
                }
            }

            // Silverfish - Hat
            if( item.getItemMeta().getDisplayName().equals( "§eHat") && config.getLastPet(player.getUniqueId()).equals( "silverfish" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.silverfish.hat" ) || player.hasPermission( "hubpets.pet.type.silverfish.*") )
                {
                    player.closeInventory();
                    silverfish.hatSilverfish( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to hat the Silverfish Pet." );
                    return;
                }
            }

            // Silverfish - Bring
            if( item.getItemMeta().getDisplayName().equals( "§eBring") && config.getLastPet(player.getUniqueId()).equals( "silverfish" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.silverfish.bring" ) || player.hasPermission( "hubpets.pet.type.silverfish.*") )
                {
                    player.closeInventory();
                    silverfish.bringSilverfish( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to bring the Silverfish Pet." );
                    return;
                }
            }

            // Silverfish - Remove
            if( item.getItemMeta().getDisplayName().equals( "§eRemove") && config.getLastPet(player.getUniqueId()).equals( "silverfish" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.silverfish.remove" ) || player.hasPermission( "hubpets.pet.type.silverfish.*") )
                {
                    player.closeInventory();
                    silverfish.removeSilverfish( player );
                    config.setLastPet( player.getUniqueId(), "none" );
                    config.savePlayers();
                    config.reloadPlayers();
                    player.sendMessage( "§8[§cHubPets§8] §6Successfully removed the Silverfish Pet." );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to remove the Silverfish Pet." );
                    return;
                }
            }

            // Silverfish - Respawn
            if( item.getItemMeta().getDisplayName().equals( "§eRespawn" ) && config.getLastPet(player.getUniqueId()).equals( "silverfish" ) )
            {
                if( player.hasPermission( "hubpets.pet.type.silverfish.respawn" ) || player.hasPermission( "hubpets.pet.type.silverfish.*") )
                {
                    player.closeInventory();
                    silverfish.respawnSilverfish( player );
                    return;
                }
                else
                {
                    player.closeInventory();
                    player.sendMessage( "§8[§cHubPets§8] §6You do not have permission to respawn the Silverfish Pet." );
                    return;
                }
            }
        }

    }

    @EventHandler
    public void onJoin( PlayerJoinEvent event )
    {
        if( config.getLastPet( event.getPlayer().getUniqueId() ) == null )
        {
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("witch") )
        {
            witch.spawnWitch( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "witch" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("cat") )
        {
            cat.spawnCat( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "cat" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babycat") )
        {
            cat.setBabyCat( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babycat" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("chicken") )
        {
            chicken.spawnChicken( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "chicken" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babychicken") )
        {
            chicken.setBabyChicken( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babychicken" );

            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("cow") )
        {
            cow.spawnCow( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "cow" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babycow") )
        {
            cow.setBabyCow( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babycow" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("horse") )
        {
            horse.spawnHorse( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "horse" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babyhorse") )
        {
            horse.setBabyHorse( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babyhorse" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("mooshroom") )
        {
            mooshroom.spawnMooshroom( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "mooshroom" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babymooshroom") )
        {
            mooshroom.setBabyMooshroom( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babymooshroom" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("ocelot") )
        {
            ocelot.spawnOcelot( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "ocelot" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babyocelot") )
        {
            ocelot.setBabyOcelot( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babyocelot" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("pig") )
        {
            pig.spawnPig( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "pig" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babypig") )
        {
            pig.setBabyPig( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babypig" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("rabbit") )
        {
            rabbit.spawnRabbit( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "rabbit" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babyrabbit") )
        {
            rabbit.setBabyRabbit( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babyrabbit" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("sheep") )
        {
            sheep.spawnSheep( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "sheep" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babysheep") )
        {
            sheep.setBabySheep( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babysheep" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("snowgolem") )
        {
            snowgolem.spawnGolem( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "snowgolem" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("villager") )
        {
            villager.spawnVillager( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "villager" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("enderman") )
        {
            enderman.spawnEnderman( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "enderman" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("irongolem") )
        {
            irongolem.spawnIrongolem( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "irongolem" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("spider") )
        {
            spider.spawnSpider( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "spider" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("wolf") )
        {
            wolf.spawnWolf( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "wolf" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babywolf") )
        {
            wolf.setBabyWolf( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babywolf" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("blaze") )
        {
            blaze.spawnBlaze( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "blaze" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("creeper") )
        {
            creeper.spawnCreeper( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "creeper" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("donkey") )
        {
            donkey.spawnDonkey( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "donkey" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babydonkey") )
        {
            donkey.setBabyDonkey( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babydonkey" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("skeleton") )
        {
            skeleton.spawnSkeleton( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "skeleton" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("mule") )
        {
            mule.spawnMule( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "mule" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babymule") )
        {
            mule.setBabyMule( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babymule" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("witherskeleton") )
        {
            witherskeleton.spawnWitherskeleton( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "witherskeleton" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("zombie") )
        {
            zombie.spawnZombie( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "zombie" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babyzombie") )
        {
            zombie.setBabyZombie( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "babyzombie" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("silverfish") )
        {
            silverfish.spawnSilverfish( event.getPlayer() );
            uuid.add( event.getPlayer().getUniqueId() );
            pet123.add( "silverfish" );
            return;
        }
    }

    @EventHandler
    public void addEntites( PlayerMoveEvent event )
    {
        if( uuid.size() > 0 && pet123.size() > 0 )
        {
            for( int i = 0; i < uuid.size(); i++ )
            {
                config.setLastPet( uuid.get(i), pet123.get(i) );
            }
        }
        if( uuid.size() > 0 && pet123.size() > 0 )
        {
            for( int i = 0; i < uuid.size(); i++ )
            {
                uuid.remove(i);
                pet123.remove(i);
            }
        }
    }

    @EventHandler
    public void onLeave( PlayerQuitEvent event )
    {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("none") )
        {
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("witch") )
        {
            witch.removeWitch( player );
            config.setLastPet( uuid, "witch" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("cat") )
        {
            cat.removeCat(player);
            config.setLastPet( uuid, "cat" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babycat") )
        {
            cat.removeCat(player);
            config.setLastPet( uuid, "babycat" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("chicken") )
        {
            chicken.removeChicken(player);
            config.setLastPet( uuid, "chicken" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babychicken") )
        {
            chicken.removeChicken(player);
            config.setLastPet( uuid, "babychicken" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("cow") )
        {
            cow.removeCow(player);
            config.setLastPet( uuid, "cow" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babycow") )
        {
            cow.removeCow(player);
            config.setLastPet( uuid, "babycow" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("horse") )
        {
            horse.removeHorse(player);
            config.setLastPet( uuid, "horse" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babyhorse") )
        {
            horse.removeHorse(player);
            config.setLastPet( uuid, "babyhorse" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("mooshroom") )
        {
            mooshroom.removeMooshroom(player);
            config.setLastPet( uuid, "mooshroom" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babymooshroom") )
        {
            mooshroom.removeMooshroom(player);
            config.setLastPet( uuid, "babymooshroom" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("ocelot") )
        {
            ocelot.respawnOcelot(player);
            config.setLastPet( uuid, "ocelot" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babyocelot") )
        {
            ocelot.respawnOcelot(player);
            config.setLastPet( uuid, "babyocelot" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("pig") )
        {
            pig.respawnPig(player);
            config.setLastPet( uuid, "pig" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babypig") )
        {
            pig.respawnPig(player);
            config.setLastPet( uuid, "babypig" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("rabbit") )
        {
            rabbit.respawnRabbit(player);
            config.setLastPet( uuid, "rabbit" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babyrabbit") )
        {
            rabbit.respawnRabbit(player);
            config.setLastPet( uuid, "babyrabbit" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("sheep") )
        {
            sheep.respawnSheep(player);
            config.setLastPet( uuid, "sheep" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babysheep") )
        {
            sheep.respawnSheep(player);
            config.setLastPet( uuid, "babysheep" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("snowgolem") )
        {
            snowgolem.removeGolem(player);
            config.setLastPet( uuid, "snowgolem" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("villager") )
        {
            villager.respawnVillager(player);
            config.setLastPet( uuid, "villager" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("enderman") )
        {
            enderman.removeEnderman(player);
            config.setLastPet( uuid, "enderman" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("irongolem") )
        {
            irongolem.removeIrongolem(player);
            config.setLastPet( uuid, "irongolem" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("spider") )
        {
            spider.removeSpider(player);
            config.setLastPet( uuid, "spider" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("wolf") )
        {
            wolf.respawnWolf(player);
            config.setLastPet( uuid, "wolf" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babywolf") )
        {
            wolf.respawnWolf(player);
            config.setLastPet( uuid, "babywolf" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("blaze") )
        {
            blaze.removeBlaze(player);
            config.setLastPet( uuid, "blaze" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("creeper") )
        {
            creeper.removeCreeper(player);
            config.setLastPet( uuid, "creeper" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("donkey") )
        {
            donkey.removeDonkey(player);
            config.setLastPet( uuid, "donkey" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babydonkey") )
        {
            donkey.removeDonkey(player);
            config.setLastPet( uuid, "babydonkey" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("skeleton") )
        {
            skeleton.removeSkeleton(player);
            config.setLastPet( uuid, "skeletom" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("mule") )
        {
            mule.removeMule(player);
            config.setLastPet( uuid, "mule" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babymule") )
        {
            mule.removeMule(player);
            config.setLastPet( uuid, "babymule" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("witherskeleton") )
        {
            witherskeleton.removeWitherskeleton(player);
            config.setLastPet( uuid, "witherskeleton" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("zombie") )
        {
            zombie.removeZombie(player);
            config.setLastPet( uuid, "zombie" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("babyzombie") )
        {
            zombie.removeZombie(player);
            config.setLastPet( uuid, "babyzombie" );
            return;
        }
        else if( config.getLastPet( event.getPlayer().getUniqueId() ).equals("silverfish") )
        {
            silverfish.removeSilverfish(player);
            config.setLastPet( uuid, "silverfish" );
            return;
        }
    }

    @EventHandler
    public boolean noDamage( EntityDamageEvent event )
    {
        if( event.getEntity() instanceof Player )
        {
            return false;
        }
        if( config1.getKillPet() == false )
        {
            event.setCancelled( true );
        }
        return true;
    }

    @EventHandler
    public boolean teleportPet( PlayerMoveEvent event )
    {
        Player player = event.getPlayer();
        
        Location owner = player.getLocation();
        String ownerfacing = player.getFacing().toString();

        if( config.getLastPet( player.getUniqueId() ).equals("none") )
        {
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("witch") )
        {
            Location cat1 = witch.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    witch.bringWitch(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    witch.bringWitch(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("cat") || config.getLastPet( player.getUniqueId() ).equals("babycat") )
        {
            Location cat1 = cat.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    cat.bringCat(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    cat.bringCat(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("chicken") || config.getLastPet( player.getUniqueId() ).equals("babychicken") )
        {
            
            Location cat1 = chicken.getLocation( player );

            if ( Math.abs(owner.getX()) - Math.abs(cat1.getX()) > config1.getDistance())
            {
                chicken.bringChicken(player);
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("cow") || config.getLastPet( player.getUniqueId() ).equals("babycow") )
        {
            Location cat1 = cow.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    cow.bringCow(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    cow.bringCow(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("horse") || config.getLastPet( player.getUniqueId() ).equals("babyhorse") )
        {
            Location cat1 = horse.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    horse.bringHorse(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    horse.bringHorse(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("mooshroom") || config.getLastPet( player.getUniqueId() ).equals("mooshroom") )
        {
            Location cat1 = mooshroom.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    mooshroom.bringMooshroom(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    mooshroom.bringMooshroom(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("ocelot") || config.getLastPet( player.getUniqueId() ).equals("babyocelot") )
        {
            Location cat1 = ocelot.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    ocelot.bringOcelot(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    ocelot.bringOcelot(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("pig") || config.getLastPet( player.getUniqueId() ).equals("babypig") )
        {
            Location cat1 = pig.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    pig.bringPig(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    pig.bringPig(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("rabbit") || config.getLastPet( player.getUniqueId() ).equals("babyrabbit") )
        {
            Location cat1 = rabbit.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    rabbit.bringRabbit(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    rabbit.bringRabbit(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("sheep") || config.getLastPet( player.getUniqueId() ).equals("babysheep") )
        {
            Location cat1 = sheep.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    sheep.bringSheep(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    sheep.bringSheep(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("snowgolem") )
        {
            Location cat1 = snowgolem.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    snowgolem.bringGolem(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    snowgolem.bringGolem(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("villager") )
        {
            Location cat1 = villager.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    villager.bringVillager(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    villager.bringVillager(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("enderman") )
        {
            Location cat1 = enderman.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    enderman.bringEnderman(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    enderman.bringEnderman(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("irongolem") )
        {
            Location cat1 = irongolem.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    irongolem.bringIrongolem(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    irongolem.bringIrongolem(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("spider") )
        {
            Location cat1 = spider.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    spider.bringSpider(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    spider.bringSpider(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("wolf") || config.getLastPet( player.getUniqueId() ).equals("babywolf") )
        {
            
            Location cat = wolf.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat.getBlockZ())) > config1.getDistance())
                {
                    wolf.bringWolf(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat.getBlockZ())) > config1.getDistance())
                {
                    wolf.bringWolf(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("blaze") )
        {
            Location cat1 = blaze.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    blaze.bringBlaze(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    blaze.bringBlaze(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("creeper") )
        {
            Location cat1 = creeper.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    creeper.bringCreeper(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    creeper.bringCreeper(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("donkey") || config.getLastPet( player.getUniqueId() ).equals("babydonkey") )
        {
            Location cat1 = donkey.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    donkey.bringDonkey(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    donkey.bringDonkey(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("skeleton") )
        {
            Location cat1 = skeleton.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    skeleton.bringSkeleton(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    skeleton.bringSkeleton(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("mule") || config.getLastPet( player.getUniqueId() ).equals("babymule") )
        {
            Location cat1 = mule.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    mule.bringMule(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    mule.bringMule(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("witherskeleton") )
        {
            Location cat1 = witherskeleton.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    witherskeleton.bringWitherskeleton(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    witherskeleton.bringWitherskeleton(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("zombie") )
        {
            Location cat1 = zombie.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    zombie.bringZombie(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    zombie.bringZombie(player);
                }
            }
            return true;
        }
        else if( config.getLastPet( player.getUniqueId() ).equals("silverfish") )
        {
            Location cat1 = silverfish.getLocation( player );

            if( ownerfacing.equals("NORTH") || ownerfacing.equals("SOUTH") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    silverfish.bringSilverfish(player);
                }
            }
            else if( ownerfacing.equals("WEST") || ownerfacing.equals("EAST") )
            {
                if ( Math.abs(Math.abs(owner.getBlockZ()) - Math.abs(cat1.getBlockZ())) > config1.getDistance())
                {
                    silverfish.bringSilverfish(player);
                }
            }
            return true;
        }
        return true;
    }
}