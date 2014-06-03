package com.aesireanempire.eplus.handlers;

import com.aesireanempire.eplus.helpers.EnchantmentObj;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

import java.util.Map;

/**
 * Created by freyja
 */
public final class EnchantmentHandler
{
    private EnchantmentHandler()
    {
    }

    public static void addEnchantmentTo(EnchantmentObj enchantmentObj, ItemStack item)
    {
        item.addEnchantment(enchantmentObj.getEnchantment(), enchantmentObj.getLevel());
    }

    public static int getNumberOfEnchantments(ItemStack itemStack)
    {
        return EnchantmentHelper.getEnchantments(itemStack).size();
    }

    public static boolean containsEnchantment(Enchantment enchantment, ItemStack itemStack)
    {
        return EnchantmentHelper.getEnchantments(itemStack).containsKey(enchantment.effectId);
    }

    public static boolean containsEnchantmentLevel(Enchantment enchantment, int level, ItemStack itemStack)
    {
        Integer levelOnItemStack = Integer.valueOf(String.valueOf(EnchantmentHelper.getEnchantments(itemStack).get(enchantment.effectId)));

        return level == levelOnItemStack;
    }

    public static void addEnchantmentsTo(ItemStack itemStack, EnchantmentObj... enchantmentObjs)
    {
        for (EnchantmentObj obj : enchantmentObjs)
        {
            addEnchantmentTo(obj, itemStack);
        }
    }

    public static void removeEnchantmentFrom(Enchantment enchantment, ItemStack itemStack)
    {
        Map<Integer, Integer> enchantments = EnchantmentHelper.getEnchantments(itemStack);

        enchantments.remove(enchantment.effectId);

        EnchantmentHelper.setEnchantments(enchantments, itemStack);
    }
}
