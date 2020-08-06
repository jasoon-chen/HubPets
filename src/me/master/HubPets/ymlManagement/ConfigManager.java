package me.master.HubPets.ymlManagement;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import me.master.HubPets.HubPetsMAIN;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager
{
    private HubPetsMAIN plugin = HubPetsMAIN.getPlugin(HubPetsMAIN.class);

    // Files & File Configs Here
    public File playersfile = new File( plugin.getDataFolder(), "playerInformation.yml" );
    public FileConfiguration playerscfg = YamlConfiguration.loadConfiguration(playersfile);
    // --------------------------
    public void setup() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        playersfile = new File(plugin.getDataFolder(), "playerInformation.yml");

        if (!playersfile.exists()) {
            try {
                playersfile.createNewFile();
                // Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "The playerInformation.yml file has been created");
            } catch (IOException e) {
                // Bukkit.getServer().getConsoleSender()
                        // .sendMessage(ChatColor.RED + "Could not create the playerInformation.yml file");
            }
        }
        playerscfg = YamlConfiguration.loadConfiguration(playersfile);
    }

    public void savePlayers()
    {
        try {
            playerscfg.save(playersfile);
            // Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "The playerInformation.yml file has been saved");

        } catch (IOException e) {
            // Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the playerInformation.yml file");
        }
    }

    public void reloadPlayers()
    {
        playerscfg = YamlConfiguration.loadConfiguration(playersfile);
        // Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "The playerInformation.yml file has been reload");
    }

    public File getFile()
    {
        return playersfile;
    }

    public boolean inPlayer( UUID uuid )
    {
        boolean inPlayer = false;
        if( playerscfg.contains( "User." + uuid.toString() ) )
        {
            inPlayer = true;
        }
        else inPlayer = false;
        return inPlayer;
    }
    public void addPlayers( UUID uuid )
    {
        // Find index of CraftPlayer{name=masterguyonfire}
        String usernameinfo = Bukkit.getPlayer( uuid ).toString();
        int firstpos = usernameinfo.indexOf("}");

        String newusername = usernameinfo.substring(17, firstpos);
        playerscfg.set( "User." + uuid.toString() + ".username", newusername );
        playerscfg.set( "User." + uuid.toString() + ".lastPet", "none" );
        playerscfg.set( "User." + uuid.toString() + ".lastPetName", "none" );
        savePlayers();
        reloadPlayers();
    }

    public FileConfiguration loadData()
    {
        if (playersfile.exists())
        {
            reloadPlayers();
            playerscfg = YamlConfiguration.loadConfiguration(playersfile);
        }
        return playerscfg;
    }

    public String getLastPet( UUID uuid )
    {
        FileConfiguration test = loadData();
        return test.getString("User." + uuid.toString() + ".lastPet");
    }

    public void setLastPet( UUID uuid, String pet)
    {
        FileConfiguration test = loadData();
        test.set( "User." + uuid.toString() + ".lastPet", pet );
        savePlayers();
        reloadPlayers();
    }

    public void setLastPetName( UUID uuid, String name )
    {
        FileConfiguration test = loadData();
        test.set( "User." + uuid.toString() + ".lastPetName", name );
        savePlayers();
        reloadPlayers();
    }

    public String getLastPetName( UUID uuid )
    {
        savePlayers();
        reloadPlayers();
        FileConfiguration test = loadData();
        return Objects.requireNonNull(test.getString("User." + uuid.toString() + ".lastPetName"));
    }

    public void saveOtherSource( File config )
    {
        playerscfg = YamlConfiguration.loadConfiguration( config );
    }
}
