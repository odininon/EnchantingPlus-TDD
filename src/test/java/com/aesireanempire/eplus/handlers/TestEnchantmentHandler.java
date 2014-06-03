package com.aesireanempire.eplus.handlers;

import com.aesireanempire.eplus.helpers.EnchantmentObj;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by freyja
 */
public class TestEnchantmentHandler
{
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddsEnchantmentToItem() throws Exception
    {
        ItemSword itemSword = new ItemSword(Item.ToolMaterial.EMERALD);
        ItemStack itemStack = new ItemStack(itemSword);

        EnchantmentObj enchantmentObj = EnchantmentObj.createEnchantmentObj(Enchantment.sharpness, 1);

        EnchantmentHandler.addEnchantmentTo(enchantmentObj, itemStack);

        assertEquals(1, EnchantmentHandler.getNumberOfEnchantments(itemStack));
        assertTrue(EnchantmentHandler.containsEnchantment(Enchantment.sharpness, itemStack));
    }

    @Test
    public void testAddsMultipleEnchantmentsToItem() throws Exception
    {
        ItemSword itemSword = new ItemSword(Item.ToolMaterial.EMERALD);
        ItemStack itemStack = new ItemStack(itemSword);

        EnchantmentHandler.addEnchantmentsTo(itemStack, EnchantmentObj.createEnchantmentObj(Enchantment.sharpness, 1), EnchantmentObj.createEnchantmentObj(Enchantment.baneOfArthropods, 1));

        assertEquals(2, EnchantmentHandler.getNumberOfEnchantments(itemStack));
        assertTrue(EnchantmentHandler.containsEnchantment(Enchantment.sharpness, itemStack));
        assertTrue(EnchantmentHandler.containsEnchantment(Enchantment.baneOfArthropods, itemStack));
    }

    @Test
    public void testAddsMultipleDuplicateEnchantmentsToItem() throws Exception
    {
        ItemSword itemSword = new ItemSword(Item.ToolMaterial.EMERALD);
        ItemStack itemStack = new ItemStack(itemSword);

        EnchantmentHandler.addEnchantmentTo(EnchantmentObj.createEnchantmentObj(Enchantment.sharpness, 1), itemStack);
        EnchantmentHandler.addEnchantmentTo(EnchantmentObj.createEnchantmentObj(Enchantment.sharpness, 2), itemStack);

        assertEquals(1, EnchantmentHandler.getNumberOfEnchantments(itemStack));
        assertTrue(EnchantmentHandler.containsEnchantmentLevel(Enchantment.sharpness, 2, itemStack));
    }

    @Test
    public void testRemovesEnchantmentFromItemWithNoneRemaining() throws Exception
    {
        ItemSword itemSword = new ItemSword(Item.ToolMaterial.EMERALD);
        ItemStack itemStack = new ItemStack(itemSword);

        EnchantmentHandler.addEnchantmentTo(EnchantmentObj.createEnchantmentObj(Enchantment.sharpness, 1), itemStack);
        assertEquals(1, EnchantmentHandler.getNumberOfEnchantments(itemStack));

        EnchantmentHandler.removeEnchantmentFrom(Enchantment.sharpness, itemStack);
        assertEquals(0, EnchantmentHandler.getNumberOfEnchantments(itemStack));
    }

    @Test
    public void testRemovesEnchantmentFromItemWithLeftovers() throws Exception
    {
        ItemSword itemSword = new ItemSword(Item.ToolMaterial.EMERALD);
        ItemStack itemStack = new ItemStack(itemSword);

        EnchantmentHandler.addEnchantmentsTo(itemStack, EnchantmentObj.createEnchantmentObj(Enchantment.sharpness, 1), EnchantmentObj.createEnchantmentObj(Enchantment.baneOfArthropods, 1));

        assertEquals(2, EnchantmentHandler.getNumberOfEnchantments(itemStack));

        EnchantmentHandler.removeEnchantmentFrom(Enchantment.sharpness, itemStack);
        assertEquals(1, EnchantmentHandler.getNumberOfEnchantments(itemStack));
    }
}
