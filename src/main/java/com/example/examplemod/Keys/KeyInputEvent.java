package com.example.examplemod.Keys;

import com.example.examplemod.Movements.BlockEdgeEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyInputEvent {


    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
        // Toggle scaffold
        if (Keyboard.isKeyDown(Keyboard.KEY_CAPITAL)) {
            BlockEdgeEvent.toggle();
        }

        // Toggle stairs
        if (Keyboard.isKeyDown(Keyboard.KEY_TAB)) {
            BlockEdgeEvent.toggleStairs();
        }
    }

    @SubscribeEvent
    public void onInputUpdate(InputUpdateEvent event) {
        boolean NeedSneaking = BlockEdgeEvent.getSneak();
        if (NeedSneaking) {
            event.getMovementInput().sneak = true;
        }
        else if (!NeedSneaking) {
            event.getMovementInput().sneak = false;
        }
    }
}
