package com.example.examplemod.chat;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;

public class Chat {
    public static void SendMessage(String message, String color) {
        EntityPlayer player = Minecraft.getMinecraft().player;

        switch (color) {
            case "green":
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.GREEN)));
                break;
            case "blue":
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.BLUE)));
                break;
            case "yellow":
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.YELLOW)));
                break;
            case "white":
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.WHITE)));
                break;
            case "red":
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.RED)));
                break;
            default:
                player.sendMessage(new TextComponentString(message).setStyle(new Style().setColor(TextFormatting.WHITE)));
        }
    }

    public static void showScaffoldHelp() {
        EntityPlayer player = Minecraft.getMinecraft().player;
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("===[ Scaffold Commands] ===").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("#scaffold_help => This message").setStyle(new Style().setColor(TextFormatting.RED)));
        player.sendMessage(new TextComponentString("#scaffold_toggle => Toggle scaffold").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#scaffold_toggle"))));
        player.sendMessage(new TextComponentString("#scaffold_autoplace_toggle => Toggle auto block placement").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#scaffold_autoplace_toggle"))));
        player.sendMessage(new TextComponentString("#scaffold_lockview_toggle => Toggle lock view").setStyle(new Style().setColor(TextFormatting.RED).setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "#scaffold_lockview_toggle"))));
        player.sendMessage(new TextComponentString("You can always toggle Scaffold using RShift+Z").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("=====================").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
        player.sendMessage(new TextComponentString("").setStyle(new Style().setColor(TextFormatting.LIGHT_PURPLE)));
    }
}
