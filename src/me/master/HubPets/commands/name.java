package me.master.HubPets.commands;

import me.master.HubPets.ymlManagement.ConfigManager;
import me.master.HubPets.ymlManagement.mainConfigManager;
import me.master.HubPets.pets.Pet;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class name implements CommandInterface {
    private ConfigManager config = new ConfigManager();
    private mainConfigManager config1 = new mainConfigManager();
    private Pet pet = new Pet();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length >= 1)
        {
            String message = "";
            if (args.length == 2)
            {
                message = args[1];
            } else if (args.length == 3)
            {
                message = args[1] + " " + args[2];
            } else if (args.length == 4)
            {
                message = args[1] + " " + args[2] + " " + args[3];
            } else if (args.length == 5)
            {
                message = args[1] + " " + args[2] + " " + args[3] + " " + args[4];
            } else if (args.length > 6)
            {
                player.sendMessage("§8[§cHubPets§8] §6A pet name can only have at most 4 spaces.");
                return true;
            }

            // Check if the colored pet names is true or false
            if (config1.getColoredPetName() == true && message.contains("&")) {
                if (player.hasPermission("hubpets.pet.type." + config.getLastPet(player.getUniqueId()) + ".coloredname") == true) {
                    message = message.replaceAll("&([a-z0-9])", "§$1");
                }

                if (message.contains("&") && !(player.hasPermission("hubpets.pet.type." + config.getLastPet(player.getUniqueId()) + ".coloredname")) == false) {
                    player.sendMessage("§8[§cHubPets§8] §6You do not have permission to have a colored pet name.");
                    return true;
                }
            }

            if (config1.getColoredPetName() == false && message.contains("&")) {
                player.sendMessage("§8[§cHubPets§8] §6The administrator did not allow colored pet names.");
                return true;
            }

            if (!(config.getLastPet(player.getUniqueId()).equals("none"))) {
                config.setLastPetName(player.getUniqueId(), message);
                player.sendMessage("§8[§cHubPets§8] §6Respawn your pet to completely change your pets name.");
            } else
                player.sendMessage("§8[§cHubPets§8] §6You do not have a pet selected. Do /pets to select a pet.");
        } else {
            player.sendMessage("§8[§cHubPets§8] §6Invalid command. Do /pet help to list all of the valid commands.");
            return true;
        }
        return true;
    }
}
