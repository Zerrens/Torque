package com.velleth.torque.core.registry;

import com.velleth.torque.Torque;
import com.velleth.torque.block.shaft.BlockShaftWood;
import com.velleth.torque.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import torque.api.block.TorqueBlocks;

/**
 * Created by Zerren on 12/26/2016.
 */
public class ModBlocks {

    public static void init() {
        TorqueBlocks.SHAFT_WOOD = new BlockShaftWood(Names.Blocks.SHAFT_WOOD, Torque.cTabTorque);
    }

    public static void registerCommon() {
        registerFull(TorqueBlocks.SHAFT_WOOD);
    }

    public static void registerClient() {
        TorqueBlocks.SHAFT_WOOD.initModel();
    }

    private static void registerModel(Item item, int meta, String name) {
        //FMLClientHandler.instance().getClient().getRenderItem().getItemModelMesher().register(item, meta, CoreUtility.itemModelResourceLocation(name));
    }

    private static void registerFull(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
    }
}
