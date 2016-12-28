package com.velleth.torque;

import com.velleth.torque.core.proxy.CommonProxy;
import com.velleth.torque.handler.TorqueConfig;
import com.velleth.torque.handler.TorqueGUI;
import com.velleth.torque.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

/**
 * Created by Zerren on 12/26/2016.
 */
@Mod(modid= Reference.ModInfo.MOD_ID, name=Reference.ModInfo.MOD_NAME, version=Reference.ModInfo.VERSION, guiFactory = Reference.ModInfo.GUIFACTORY_CLASS)
public class Torque {

    @Mod.Instance(Reference.ModInfo.MOD_ID)
    public static Torque instance;

    @SidedProxy(modId = Reference.ModInfo.MOD_ID, clientSide = Reference.ModInfo.CLIENTPROXY_CLASS, serverSide = Reference.ModInfo.COMMONPROXY_CLASS)
    public static CommonProxy proxy;

    public static Logger log;

    public static CreativeTabs cTabTorque = new CreativeTabs(Reference.ModInfo.MOD_ID) {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.IRON_INGOT);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        TorqueConfig.init(event.getSuggestedConfigurationFile());

        MinecraftForge.EVENT_BUS.register(new TorqueConfig());
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new TorqueGUI());

        log = event.getModLog();

        //ModFluids.init();
        proxy.registerBlockCommon();
        proxy.registerItemCommon();
        //ModPotions.init();

        //CRDictionary.init();
        //PacketHandler.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        /*TileEntities.init();

        proxy.initTESR();
        proxy.initItemRender();
        proxy.initISBRH();
        proxy.initArmorRender();*/

        proxy.registerBlockClient();
        proxy.registerItemClient();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        /*Recipes.init();
        MultiblockCost.init();

        FMLCommonHandler.instance().bus().register(new CRTickHandler());
        MinecraftForge.EVENT_BUS.register(new CRTickHandler());

        if(event.getSide() == Side.CLIENT) {
            CRHotkey.init();
            FMLCommonHandler.instance().bus().register(new ClientProxy());
        }*/
    }
}
