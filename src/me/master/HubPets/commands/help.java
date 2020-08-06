package me.master.HubPets.commands;

import me.master.HubPets.pets.Pet;
import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.ymlManagement.mainConfigManager;
import me.master.HubPets.ymlManagement.mainPluginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.md_5.bungee.api.ChatColor.*;

public class help implements CommandInterface {
    private ConfigManager config = new ConfigManager();
    private mainConfigManager config1 = new mainConfigManager();
    private Pet pet = new Pet();
    private mainPluginManager config2 = new mainPluginManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player player = (Player) sender;
        player.sendMessage(BOLD + "" + GRAY + "———————" + RESET + GOLD + " HubPets Help " + RESET + GRAY + BOLD + "———————");
        player.sendMessage(GOLD + "/pet help" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " Shows the user all of HubPets commands.");
        player.sendMessage(GOLD + "/pet info" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " Shows the user all of HubPets information.");
        player.sendMessage(GOLD + "/pet name [name]" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " Allows the user to name their selected pet.");
        player.sendMessage(GOLD + "/pets" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " Prompts the user to a Pet Selector GUI.");
        return true;
    }
}
