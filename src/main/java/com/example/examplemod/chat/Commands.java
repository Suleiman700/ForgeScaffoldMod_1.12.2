package com.example.examplemod.chat;

import com.example.examplemod.Movements.BlockEdgeEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Commands {

    @SubscribeEvent
    public void clientChat(ClientChatReceivedEvent event) {
        ITextComponent message = event.getMessage();

        String playerMessage = null;
        playerMessage = message.getFormattedText();

        if (playerMessage != null) {
            System.out.println(playerMessage);
            // Scaffold
            if (playerMessage.contains("#scaffold_")) {
                if (playerMessage.contains("#scaffold_help")) {
                    Chat.showScaffoldHelp();
                }
                if (playerMessage.contains("#scaffold_toggle")) {
                    BlockEdgeEvent.toggle();
                }
                else if (playerMessage.contains("#scaffold_autoplace_toggle")) {
                    BlockEdgeEvent.toggleAutoPlace();
                }
                else if (playerMessage.contains("#scaffold_lockview_toggle")) {
                    BlockEdgeEvent.toggleLockView();
                }
                event.setCanceled(true);
            }
        }
    }
}
