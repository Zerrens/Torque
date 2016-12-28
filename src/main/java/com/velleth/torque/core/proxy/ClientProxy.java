package com.velleth.torque.core.proxy;

import com.velleth.torque.core.registry.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Zerren on 12/26/2016.
 */
public class ClientProxy extends CommonProxy {

    public static Random rand = new Random();
    public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

    @Override
    public void registerBlockClient() {
        ModBlocks.registerClient();
    }

    @Override
    public void registerItemClient() {
        //ModItems.registerClient();
    }

    @Override
    public void initArmorRender() {
        /*armorModels.put(CRItems.o2mask, new ModelO2Mask());
        armorModels.put(CRItems.thrustPack, new ModelThrustPack());*/
    }

    @Override
    public void playSoundCentered(World world, float x, float y, float z, String soundName, float volume, float pitch) {
        //world.playSoundEffect(Math.floor(x) + 0.5, Math.floor(y) + 0.5, Math.floor(z) + 0.5, soundName, volume, pitch);
    }

    @Override
    public void playSound(World world, float x, float y, float z, String soundName, float volume, float pitch) {
        //world.playSoundEffect(x, y, z, soundName, volume, pitch);
    }

    private boolean shouldSpawnParticle() {
        Minecraft mc = FMLClientHandler.instance().getClient();

        int particleSetting = mc.gameSettings.particleSetting;

        if (particleSetting == 1 && rand.nextInt(3) == 0) {
            particleSetting = 2;
        }

        return particleSetting <= 1;
    }
}
