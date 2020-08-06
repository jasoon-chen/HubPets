package me.master.HubPets.ymlManagement;

import java.io.File;
import java.io.IOException;

import me.master.HubPets.HubPetsMAIN;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class mainPluginManager
{
    private HubPetsMAIN plugin = HubPetsMAIN.getPlugin(HubPetsMAIN.class);

    // Files & File Configs Here
    public File playersfile = new File(plugin.getDataFolder(), "plugin.yml");
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


    public String getVersion()
    {
        FileConfiguration test = loadData();
        return test.getString("version");
    }
}
