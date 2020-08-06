package me.master.HubPets.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;

public interface CommandInterface
{
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args);
}