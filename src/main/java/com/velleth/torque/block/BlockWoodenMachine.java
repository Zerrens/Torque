package com.velleth.torque.block;

import com.velleth.torque.reference.Names;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IStringSerializable;

/**
 * Created by Zerren on 12/26/2016.
 */
public class BlockWoodenMachine extends BlockTorque {
    public static final PropertyEnum TYPES = PropertyEnum.create(Names.Blocks.WOODEN_MACHINE_0, EnumTypes.class);

    public BlockWoodenMachine(String name, CreativeTabs tab) {
        super(name, TYPES, Material.WOOD, 1.5F, 3.0F, SoundType.WOOD, tab);
    }

    public enum EnumTypes implements IStringSerializable {
        SHAFT(0, "shaft");

        private final int meta;
        private final String name;
        private static final EnumTypes[] META_LOOKUP = new EnumTypes[values().length];

        EnumTypes(int meta, String name) {
            this.meta = meta;
            this.name = name;
        }

        public int getMetadata() {
            return this.meta;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public static EnumTypes byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName() {
            return this.name;
        }

        static {
            for (EnumTypes types : values()) {
                META_LOOKUP[types.getMetadata()] = types;
            }
        }
    }
}
