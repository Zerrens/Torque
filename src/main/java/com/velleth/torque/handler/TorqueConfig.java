package com.velleth.torque.handler;

import com.velleth.torque.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created by Zerren on 12/26/2016.
 */
public class TorqueConfig {
    public static Configuration config;

    public static int testValue;

    public static void init(File configFile){

        if (config == null) {
            config = new Configuration(configFile);
            loadConfigValues();
            if (config.hasChanged())
                config.save();
        }
    }

    //name, category, default, minimum, maximum, comment
    private static void loadConfigValues() {
        testValue = config.getInt("test", "general", 5, 1, 10, "Arbitrary config value");
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(Reference.ModInfo.MOD_ID)) {
            loadConfigValues();
        }
    }
}
