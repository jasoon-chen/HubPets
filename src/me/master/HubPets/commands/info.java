package me.master.HubPets.commands;

import me.master.HubPets.ymlManagement.mainPluginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.md_5.bungee.api.ChatColor.*;

public class info implements CommandInterface {
    private mainPluginManager config2 = new mainPluginManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        player.sendMessage(BOLD + "" + GRAY + "———————" + RESET + GOLD + " HubPets Information " + RESET + GRAY + BOLD + "———————");
        player.sendMessage(GOLD + "Author" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " JaxonTekk");
        player.sendMessage(GOLD + "HubPets Discord Server" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " mQg3vHs");
        player.sendMessage(GOLD + "Plugin Version" + RESET + DARK_GRAY + "" + BOLD + " » " + RESET + GRAY + " 1.0.0");
        player.sendMessage(GRAY + "Join our discord server for a custom HubPets plugin or if you have any questions regarding the plugin.");
        return true;
    }
}