package com.velleth.torque.core.proxy;

import com.velleth.torque.core.registry.ModBlocks;
import net.minecraft.world.World;

/**
 * Created by Zerren on 12/26/2016.
 */
public class CommonProxy {

    public void registerBlockCommon() {
        ModBlocks.init();
        ModBlocks.registerCommon();
    }

    public void registerItemCommon() {
        //ModItems.init();;
        //ModItems.registerCommon();
    }

    public void registerBlockClient() { }

    public void registerItemClient() { }

    public void initArmorRender() { }

    public void playSoundCentered(World world, float x, float y, float z, String soundName, float volume, float pitch) { }

    public void playSound(World world, float x, float y, float z, String soundName, float volume, float pitch) { }
}
