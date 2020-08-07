package me.master.HubPets;

import me.master.HubPets.commands.*;
import me.master.HubPets.petFunctions.petListener;
import me.master.HubPets.pets.Pet;
import me.master.HubPets.pets.witch;
import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.ymlManagement.mainConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static net.md_5.bungee.api.ChatColor.*;

public class HubPetsMAIN extends JavaPlugin implements Listener
{
    public static HubPetsMAIN plugin;
    private ConfigManager cfgm;
    private mainConfigManager cfgm1;
    public HashMap<UUID, PermissionAttachment> playerPermissions = new HashMap<>();
    private ArrayList<UUID> uuid = new ArrayList<UUID>();
    private ArrayList<String> answer = new ArrayList<String>();

    public void onEnable()
    {
        cfgm1 = new mainConfigManager();
        plugin = this;

        // Announce to the console that the plugin has been enabled
        getServer().getConsoleSender().sendMessage( ChatColor.GREEN + "[HubPets] HubPets has been loaded." );
        getServer().getPluginManager().registerEvents( new petListener(), this );

        loadConfig();

        // playerInformation
        Bukkit.getPluginManager().registerEvents( this, this );

        // pets
        this.getCommand("pets").setExecutor( new petTool() );

        loadConfigManager();
        registerCommands();

    }

    public void onDisable()
    {
        for( Entity e : Bukkit.getWorld( cfgm1.getHubWorld() ).getEntities() )
        {
            e.remove();
        }
    }

    // Load Config
    public void loadConfig()
    {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    @EventHandler
    public void dropTool( PlayerDropItemEvent event )
    {
        if( event.getItemDrop().getItemStack().getType() == Material.BONE )
        {
            event.setCancelled( true );
        }
    }

    @EventHandler
    public void onJoin( PlayerJoinEvent event )
    {
        if( cfgm1.getHubTool() == true )
        {
            // Prepare the Pet Selector Item
            int petslot = cfgm1.getHubToolSlot();

            Player player = event.getPlayer();

            Inventory inventory = player.getInventory();

            ItemStack petTool = new ItemStack(Material.BONE, 1);

            ArrayList<String> petToolDescription = new ArrayList<>();
            petToolDescription.add(GRAY + "Click here to get the Pet Selector GUI.");

            ItemMeta petTool1 = petTool.getItemMeta();
            petTool1.setDisplayName(YELLOW + "Pet Selector");
            petTool1.setLore(petToolDescription);
            petTool.setItemMeta(petTool1);
            player.getInventory().setItem( petslot, petTool );
        }

        if( cfgm.playerscfg.contains( "User." + uuid.toString() ) == true )
        {
            return;
        }
        else
        {
            cfgm.addPlayers(event.getPlayer().getUniqueId());
        }

    }

    @EventHandler
    public void onLeave( PlayerQuitEvent event )
    {
        if( cfgm1.getHubTool() == true )
        {
            // Prepare the Pet Selector Item
            int petslot = cfgm1.getHubToolSlot();

            Player player = event.getPlayer();

            Inventory inventory = player.getInventory();

            ItemStack petTool = new ItemStack(Material.AIR, 1);

            player.getInventory().setItem( petslot, petTool );
        }
    }

    public void loadConfigManager()
    {
        cfgm = new ConfigManager();
        cfgm.setup();
        cfgm.savePlayers();
        cfgm.reloadPlayers();
    }

    public void saveDefaultConfig()
    {
        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveResource("config.yml", false);
        }
    }

    public void registerCommands()
    {
        CommandHandler handler = new CommandHandler();

        handler.register("pet", new help());

        handler.register("help", new help() );
        getCommand("pet").setExecutor(handler);

        handler.register("info", new info() );
        getCommand("pet").setExecutor(handler);

        handler.register("name", new name() );
        getCommand("pet").setExecutor(handler);
    }

    @EventHandler
    public void clickPetTool( PlayerInteractEvent event )
    {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if( player.getInventory().getItemInMainHand().getType() == null )
        {
            return;
        }
            if( action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)  )
            {
                String type = player.getInventory().getItemInMainHand().getType().toString();
                if( type.equals("BONE") )
                {
                    if (player.hasPermission("hubpets.petcommand.pets.list")) {
                        // Create the inventory
                        Inventory petSelector = Bukkit.createInventory(player, 45, "Pet Selector");

                        // Put Items into the inventory
                        Pet pet = new Pet();

                        // Chat Color
                        net.md_5.bungee.api.ChatColor hasperm = RED;

                        // Integer of where to place it in the inventory
                        for (int i = 0; i < pet.size(); i++) {
                            ItemStack item = new ItemStack(pet.getEgg(i), 1);

                            // Put a description of the Item
                            ItemMeta item1meta = item.getItemMeta();
                            if (player.hasPermission(pet.getPermission(i))) {
                                hasperm = GREEN;
                            }
                            item1meta.setDisplayName(hasperm + pet.getName(i) + " Pet");
                            item.setItemMeta(item1meta);
                            petSelector.setItem(i, item);
                            hasperm = RED;
                        }

                        // Babify Pet
                        ItemStack babyPet = new ItemStack(Material.CRAFTING_TABLE, 1);

                        // - Description
                        ArrayList<String> babyPetDescription = new ArrayList<>();
                        babyPetDescription.add(GRAY + "Click here to babify your pet.");

                        ItemMeta babyPet1 = babyPet.getItemMeta();
                        babyPet1.setDisplayName(YELLOW + "Babyify");
                        babyPet1.setLore(babyPetDescription);
                        babyPet.setItemMeta(babyPet1);
                        petSelector.setItem(36, babyPet);

                        // Name Pet
                        ItemStack namePet = new ItemStack(Material.NAME_TAG, 1);

                        // - Description
                        ArrayList<String> namePetDescription = new ArrayList<>();
                        namePetDescription.add(GRAY + "Click here to name your pet.");

                        ItemMeta namePet1 = namePet.getItemMeta();
                        namePet1.setDisplayName(YELLOW + "Name");
                        namePet1.setLore(namePetDescription);
                        ItemStack nametag = new ItemStack(Material.NAME_TAG);
                        namePet.setItemMeta(namePet1);
                        petSelector.setItem(37, namePet);

                        // Ride Pet
                        ItemStack followPet = new ItemStack(Material.SADDLE, 1);

                        // - Description
                        ArrayList<String> ridePetDescription = new ArrayList<>();
                        ridePetDescription.add(GRAY + "Click here to sit on your pet.");

                        ItemMeta followPet1 = followPet.getItemMeta();
                        followPet1.setDisplayName(YELLOW + "Sit");
                        followPet1.setLore(ridePetDescription);
                        followPet.setItemMeta(followPet1);
                        petSelector.setItem(38, followPet);

                        // Hat Pet
                        ItemStack hatPet = new ItemStack(Material.IRON_HELMET, 1);

                        // - Description
                        ArrayList<String> hatPetDescription = new ArrayList<>();
                        hatPetDescription.add(GRAY + "Click here to hat your pet.");

                        ItemMeta hatPet1 = hatPet.getItemMeta();
                        hatPet1.setDisplayName(YELLOW + "Hat");
                        hatPet1.setLore(hatPetDescription);
                        hatPet.setItemMeta(hatPet1);
                        petSelector.setItem(39, hatPet);

                        // Bring Pet
                        ItemStack bringPet = new ItemStack(Material.ENDER_PEARL, 1);

                        // - Description
                        ArrayList<String> bringPetDescription = new ArrayList<>();
                        bringPetDescription.add(GRAY + "Click here to bring your pet.");

                        ItemMeta bringPet1 = bringPet.getItemMeta();
                        bringPet1.setDisplayName(YELLOW + "Bring");
                        bringPet1.setLore(bringPetDescription);
                        bringPet.setItemMeta(bringPet1);
                        petSelector.setItem(41, bringPet);

                        // Remove Pet
                        ItemStack removePet = new ItemStack(Material.BONE, 1);

                        // - Description
                        ArrayList<String> removePetDescription = new ArrayList<>();
                        removePetDescription.add(GRAY + "Click here to remove your pet.");

                        ItemMeta removePet1 = removePet.getItemMeta();
                        removePet1.setDisplayName(YELLOW + "Remove");
                        removePet1.setLore(removePetDescription);
                        removePet.setItemMeta(removePet1);
                        petSelector.setItem(42, removePet);

                        // Respawn Pet
                        ItemStack respawnPet = new ItemStack(Material.GOLDEN_APPLE, 1);

                        // - Description
                        ArrayList<String> respawnPetDescription = new ArrayList<>();
                        respawnPetDescription.add(GRAY + "Click here to respawn your pet.");

                        ItemMeta respawnPet1 = respawnPet.getItemMeta();
                        respawnPet1.setDisplayName(YELLOW + "Respawn");
                        respawnPet1.setLore(respawnPetDescription);
                        respawnPet.setItemMeta(respawnPet1);
                        petSelector.setItem(44, respawnPet);

                        player.openInventory(petSelector);
                    }
                }
            }
        }
    }