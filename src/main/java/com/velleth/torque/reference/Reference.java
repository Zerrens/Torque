package com.velleth.torque.reference;

/**
 * Created by Zerren on 12/26/2016.
 */
public final class Reference {

    public static final class ModInfo {
        public static final String MOD_ID = "torque";
        public static final String MOD_NAME = "Torque";
        public static final String VERSION = "1.0.0";
        public static final String CLIENTPROXY_CLASS = "com.velleth.torque.core.proxy.ClientProxy";
        public static final String COMMONPROXY_CLASS = "com.velleth.torque.core.proxy.CommonProxy";
        public static final String GUIFACTORY_CLASS = "com.velleth.torque.client.gui.GuiFactory";

        public static final String CR_RESOURCE_PREFIX = Reference.ModInfo.MOD_ID.toLowerCase() + ":";
    }
}
