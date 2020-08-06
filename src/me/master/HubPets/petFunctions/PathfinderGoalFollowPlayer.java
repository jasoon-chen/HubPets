package me.master.HubPets.petFunctions;

import net.minecraft.server.v1_16_R1.*;

public class PathfinderGoalFollowPlayer extends PathfinderGoal {

    private EntityInsentient entity;
    private EntityPlayer owner;
    private double speed;
    private float distanceSquared;

    public PathfinderGoalFollowPlayer(EntityInsentient entity, EntityPlayer owner, double speed, float distance)
    {
        this.entity = entity;
        this.owner = owner;
        this.speed = speed;
        this.distanceSquared = distance * distance;
        this.a();
    }

    @Override
    public boolean a()
    {
        return (owner != null && owner.isAlive() && entity.h(owner) > (double)distanceSquared);
    }

    @Override
    public void d() {
        entity.getNavigation().n();
    }

    @Override
    public void e() {
        entity.getControllerLook().a(owner, 10.0F, (float)entity.bD());
        entity.getNavigation().a(owner, speed);
    }
}
