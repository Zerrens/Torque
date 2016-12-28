package com.velleth.torque.utility;

import com.velleth.torque.reference.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Zerren on 12/26/2016.
 */
public final class CoreUtility {

    /*public static String translate(String key) {
        String result = StatCollector.translateToLocal(key);
        int comment = result.indexOf('#');
        return (comment > 0) ? result.substring(0, comment).trim() : result;
    }

    public static void addColoredChat(String message, EnumChatFormatting format, EntityPlayer player) {
        if (player == null) return;

        String translated = format + translate(message);
        ChatComponentText comp = new ChatComponentText(translated);
        player.addChatComponentMessage(comp);
    }

    public static void addChat(String message, EntityPlayer player) {
        if (player == null) return;

        String translated = translate(message);
        ChatComponentText comp = new ChatComponentText(translated);
        player.addChatComponentMessage(comp);
    }

    public static ModelResourceLocation itemModelResourceLocation(String name) {
        return new ModelResourceLocation(Reference.ModInfo.MOD_ID + ":" + name, "inventory");
    }

    public static Item getItem(String name) {
        return GameRegistry.findItem(Reference.ModInfo.MOD_ID, name);
    }*/
}
