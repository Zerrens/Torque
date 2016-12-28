package com.velleth.torque.core.registry;

import com.velleth.torque.Torque;
import com.velleth.torque.block.BlockTorque;
import com.velleth.torque.block.BlockWoodenMachine;
import com.velleth.torque.reference.Names;
import com.velleth.torque.utility.CoreUtility;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyHelper;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import torque.api.block.TorqueBlocks;

/**
 * Created by Zerren on 12/26/2016.
 */
public class ModBlocks {

    public static void init() {
        TorqueBlocks.WOODEN_MACHINE_0 = new BlockWoodenMachine(Names.Blocks.WOODEN_MACHINE_0, Torque.cTabTorque);
    }

    public static void registerCommon() {
        registerFull(TorqueBlocks.WOODEN_MACHINE_0);
    }

    public static void registerClient() {
        initBlockModels(TorqueBlocks.WOODEN_MACHINE_0, Names.Blocks.WOODEN_MACHINE_0_TYPES);
    }

    private static void initBlockModels(Block block, String[] types) {
        Item item = block.g;
        for (int i = 0; i < types.length; i++) {
            ModelBakery.registerItemVariants(item, CoreUtility.itemModelResourceLocation(name + "/" + types[i]));
            registerModel(item, i, name + "/" + types[i]);
        }
    }

    private static void registerModel(Item item, int meta, String name) {
        FMLClientHandler.instance().getClient().getRenderItem().getItemModelMesher().register(item, meta, CoreUtility.itemModelResourceLocation(name));
    }

    private static void registerFull(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
    }
}
