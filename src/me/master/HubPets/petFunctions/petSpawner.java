package me.master.HubPets.petFunctions;

import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_16_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import java.lang.reflect.Field;
import java.util.UUID;

public class petSpawner
{
    private static Field gsa;
    private static Field goalSelector;
    private static Field targetSelector;
    static {
        try {
            gsa = PathfinderGoalSelector.class.getDeclaredField("b");
            gsa.setAccessible(true);
            goalSelector = EntityInsentient.class.getDeclaredField("goalSelector");
            goalSelector.setAccessible(true);
            targetSelector = EntityInsentient.class.getDeclaredField("targetSelector");
            targetSelector.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    public static void makePet(LivingEntity entity, Player owner)
    {
        EntityLiving entityLiving = ((CraftLivingEntity)entity).getHandle();
        if (entityLiving instanceof EntityInsentient) {
            EntityPlayer entityPlayer = ((CraftPlayer)owner).getHandle();
            EntityInsentient entityInsentient = (EntityInsentient)entityLiving;
            entityInsentient.goalSelector = new PathfinderGoalSelector(entityInsentient.world.getMethodProfilerSupplier());
            entityInsentient.targetSelector = new PathfinderGoalSelector(entityInsentient.world.getMethodProfilerSupplier());
            entityInsentient.goalSelector.a(0, new PathfinderGoalFloat(entityInsentient));
            entityInsentient.goalSelector.a(1, new PathfinderGoalFollowPlayer(entityInsentient, entityPlayer, 1.75D, 2.0F));
        } else {
            throw new IllegalArgumentException(entityLiving.getClass().getSimpleName() + " is not an instance of an EntityInsentient.");
        }
    }

    public static class PathfinderGoalWalktoTile extends PathfinderGoal
    {
        private EntityInsentient entity;
        private PathEntity path;
        private UUID p;
        public PathfinderGoalWalktoTile(EntityInsentient entitycreature, UUID p)
        {
            this.entity = entitycreature;
            this.p = p;
        }
        @Override
        public boolean a()
        {
            if (Bukkit.getPlayer(p) == null)
            {
                return path != null;
            }
            Location targetLocation = Bukkit.getPlayer(p).getLocation();
            boolean flag = this.entity.getNavigation().m();
            this.entity.getNavigation();
            this.path = this.entity.getNavigation().a( targetLocation.getX() + 3, targetLocation.getY() + 3, targetLocation.getZ() + 3, 0);
            this.entity.getNavigation();
            if (this.path != null) {
                this.c();
            }
            return this.path != null;
        }
        @Override
        public void c()
        {
            this.entity.getNavigation().a(this.path, 1D);
        }
    }
}
