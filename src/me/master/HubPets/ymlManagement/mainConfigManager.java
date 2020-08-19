package me.master.HubPets.ymlManagement;

import java.io.File;
import java.io.IOException;

import me.master.HubPets.HubPetsMAIN;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class mainConfigManager
{
    private HubPetsMAIN plugin = HubPetsMAIN.getPlugin(HubPetsMAIN.class);

    // Files & File Configs Here
    public File playersfile = new File(plugin.getDataFolder(), "config.yml");
    public FileConfiguration playerscfg = YamlConfiguration.loadConfiguration(playersfile);
    // --------------------------

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


    public FileConfiguration loadData()
    {
        if (playersfile.exists())
            playerscfg = YamlConfiguration.loadConfiguration( playersfile );
        return playerscfg;
    }


    public boolean getColoredPetName()
    {
        FileConfiguration test = loadData();
        return test.getBoolean( "colored-petnames");
    }

    public boolean getKillPet()
    {
        FileConfiguration test = loadData();
        return test.getBoolean( "kill-pet" );
    }

    public String getHubWorld()
    {
        FileConfiguration test = loadData();
        return test.getString( "hub-world" );
    }

    public Integer getDistance()
    {
        FileConfiguration test = loadData();
        return test.getInt( "maximum-distance" );
    }

    public Boolean getHubTool()
    {
        FileConfiguration test = loadData();
        return test.getBoolean( "hub-tool" );
    }

    public int getHubToolSlot()
    {
        FileConfiguration test = loadData();
        return test.getInt( "hub-tool-slot" );
    }
    public boolean getMoveHubTool()
    {
        FileConfiguration test = loadData();
        return test.getBoolean( "hub-tool-move");
    }
}
