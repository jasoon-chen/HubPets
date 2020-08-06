package me.master.HubPets.commands;

import me.master.HubPets.pets.Pet;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import java.util.ArrayList;

import static net.md_5.bungee.api.ChatColor.*;

public class petTool implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args ) {
        Player player = (Player) sender;

        if ( player.hasPermission("hubpets.petcommand.pets.list") )
        {
            if (sender instanceof Player) {
                // Create the inventory
                Inventory petSelector = Bukkit.createInventory(player, 45, "Pet Selector");

                // Put Items into the inventory
                Pet pet = new Pet();

                // Chat Color
                ChatColor hasperm = RED;

                // Integer of where to place it in the inventory
                for (int i = 0; i < pet.size(); i++)
                {
                    ItemStack item = new ItemStack(pet.getEgg(i), 1);

                    // Put a description of the Item
                    ItemMeta item1meta = item.getItemMeta();
                    if (player.hasPermission( pet.getPermission(i) ) )
                    {
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

                player.openInventory(petSelector);

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
            return true;
        }
        return true;
    }
}
