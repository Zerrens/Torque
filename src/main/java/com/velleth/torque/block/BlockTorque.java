package com.velleth.torque.block;

import com.velleth.torque.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Zerren on 12/26/2016.
 */
public class BlockTorque extends Block {

    protected PropertyHelper PROPERTY_METADATA;

    public BlockTorque(String name, PropertyHelper property, Material material, float hardness, float resistance, SoundType sound, CreativeTabs tab) {
        super(material);
        //this.setUnlocalizedName(name);
        buildUnlocalizedName(name);
        this.setRegistryName(name);
        this.PROPERTY_METADATA = property;
        this.setCreativeTab(tab);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setSoundType(sound);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    public boolean hasMetaTypes() {
        return PROPERTY_METADATA != null;
    }

    private void buildUnlocalizedName(String name) {
        this.setUnlocalizedName(Reference.ModInfo.MOD_ID + "." + name);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int damageDropped(IBlockState state) {
        if (PROPERTY_METADATA != null)
            return getMetaFromState(state);

        return super.damageDropped(state);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
        if (hasMetaTypes())
            for (int i = 0; i < PROPERTY_METADATA.getAllowedValues().size(); i++) {
                list.add(new ItemStack(item, 1, i));
            }
        else super.getSubBlocks(item, tab, list);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.ModInfo.CR_RESOURCE_PREFIX, super.getUnlocalizedName().substring(super.getUnlocalizedName().indexOf(".") + 1));
    }
}

