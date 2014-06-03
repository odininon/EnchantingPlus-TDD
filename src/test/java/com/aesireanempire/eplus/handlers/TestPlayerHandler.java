package com.aesireanempire.eplus.handlers;

import net.minecraft.entity.player.EntityPlayer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by freyja
 */
public class TestPlayerHandler
{
    @Mock
    EntityPlayer player;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPlayerCanNotAfford() throws Exception
    {
        assertFalse(PlayerHandler.canPlayerAfford(player, 5));
    }

    @Test
    public void testPlayerLevelEqualTo() throws Exception
    {
        player.experienceLevel = 5;
        assertTrue(PlayerHandler.canPlayerAfford(player, 5));
    }

    @Test
    public void testOkayerLevelGreaterThen() throws Exception
    {
        player.experienceLevel = 10;
        assertTrue(PlayerHandler.canPlayerAfford(player, 5));
    }

    @Test
    public void testRemoveLevelsFromPlayer() throws Exception
    {
        player.experienceLevel = 10;

        Mockito.doCallRealMethod().when(player).addExperienceLevel(Matchers.anyInt());

        PlayerHandler.removeLevelsFromPlayer(player, 5);

        assertEquals(5, player.experienceLevel);
    }

    @Test
    public void testAddsLevelsToPlayer() throws Exception
    {
        player.experienceLevel = 10;

        Mockito.doCallRealMethod().when(player).addExperienceLevel(Matchers.anyInt());

        PlayerHandler.addLevelsToPlayer(player, 5);

        assertEquals(15, player.experienceLevel);
    }
}
