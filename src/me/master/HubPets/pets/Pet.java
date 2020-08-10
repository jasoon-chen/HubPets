package me.master.HubPets.pets;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;

public class Pet
{
    public static ArrayList<String> petname = new ArrayList<String>( Arrays.asList(
            "Witch", "Cat", "Chicken", "Cow", "Horse", "Mooshroom", "Ocelot", "Pig",
            "Rabbit", "Sheep", "Snow Golem", "Villager", "Enderman", "Irongolem", "Spider",
            "Wolf", "Blaze", "Creeper", "Donkey", "Skeleton", "Mule", "Wither Skeleton",
            "Zombie", "Silverfish", "Fox")
    );

    public static ArrayList<Material> petegg = new ArrayList<Material>( Arrays.asList(
            Material.WITCH_SPAWN_EGG, Material.CAT_SPAWN_EGG, Material.CHICKEN_SPAWN_EGG, Material.COW_SPAWN_EGG, Material.HORSE_SPAWN_EGG, Material.MOOSHROOM_SPAWN_EGG, Material.OCELOT_SPAWN_EGG, Material.PIG_SPAWN_EGG,
            Material.RABBIT_SPAWN_EGG, Material.SHEEP_SPAWN_EGG, Material.PUMPKIN, Material.VILLAGER_SPAWN_EGG, Material.ENDERMAN_SPAWN_EGG, Material.IRON_BLOCK, Material.SPIDER_SPAWN_EGG,
            Material.WOLF_SPAWN_EGG, Material.BLAZE_SPAWN_EGG, Material.CREEPER_SPAWN_EGG, Material.DONKEY_SPAWN_EGG, Material.SKELETON_SPAWN_EGG, Material.MULE_SPAWN_EGG, Material.WITHER_SKELETON_SPAWN_EGG,
            Material.ZOMBIE_SPAWN_EGG, Material.SILVERFISH_SPAWN_EGG, Material.FOX_SPAWN_EGG)
    );

    public static ArrayList<String> petpermission = new ArrayList<>( Arrays.asList(
            "hubpets.pet.type.witch", "hubpets.pet.type.cat", "hubpets.pet.type.chicken", "hubpets.pet.type.cow", "hubpets.pet.type.horse", "hubpets.pet.type.horse", "hubpets.pet.type.ocelot", "hubpets.pet.type.pig",
            "hubpets.pet.type.rabbit", "hubpets.pet.type.sheep", "hubpets.pet.type.snowgolem", "hubpets.pet.type.villager", "hubpets.pet.type.enderman", "hubpets.pet.type.irongolem", "hubpets.pet.type.spider",
            "hubpets.pet.type.wolf","hubpets.pet.type.blaze","hubpets.pet.type.creeper","hubpets.pet.type.donkey","hubpets.pet.type.skeleton","hubpets.pet.type.mule","hubpets.pet.type.witherskeleton",
            "hubpets.pet.type.zombie","hubpets.pet.type.silverfish", "hubpets.pet.type.fox"
    ));

    private String name;
    private Material egg;
    private boolean continue1 = true;

    public Pet( String name, Material egg )
    {
        this.name = name;
        this.egg = egg;
    }

    public Pet()
    {
    }

    public String getName( int index )
    {
        return petname.get( index );
    }

    public Material getEgg( int index )
    {
        return petegg.get( index );
    }

    public int size()
    {
        return petname.size();
    }

    public String getPermission( int index )
    {
        return petpermission.get( index );
    }
}
