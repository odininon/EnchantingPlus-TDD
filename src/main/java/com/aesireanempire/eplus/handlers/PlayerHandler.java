package com.aesireanempire.eplus.handlers;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by freyja
 */
public final class PlayerHandler
{
    private PlayerHandler()
    {
    }

    public static boolean canPlayerAfford(EntityPlayer player, int level)
    {
        return player.experienceLevel >= level;
    }

    public static void removeLevelsFromPlayer(EntityPlayer entityPlayer, int levels)
    {
        entityPlayer.addExperienceLevel(-levels);
    }

    public static void addLevelsToPlayer(EntityPlayer entityPlayer, int levels)
    {
        entityPlayer.addExperienceLevel(levels);
    }
}
