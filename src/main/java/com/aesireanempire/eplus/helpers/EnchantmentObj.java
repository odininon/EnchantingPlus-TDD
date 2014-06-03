package com.aesireanempire.eplus.helpers;

import net.minecraft.enchantment.Enchantment;

/**
 * Created by freyja
 */
public class EnchantmentObj
{
    private final Enchantment m_enchantment;
    private final int m_level;

    private EnchantmentObj(Enchantment enchantment, int level)
    {
        m_enchantment = enchantment;
        m_level = level;
    }

    public static EnchantmentObj createEnchantmentObj(Enchantment enchantment, int level)
    {
        return new EnchantmentObj(enchantment, level);
    }

    public final int getLevel()
    {
        return m_level;
    }

    public final Enchantment getEnchantment()
    {
        return m_enchantment;
    }
}
