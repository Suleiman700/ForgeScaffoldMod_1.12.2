package com.example.examplemod.Movements;

import com.example.examplemod.Data;
import com.example.examplemod.chat.Chat;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class BlockEdgeEvent {

    public static boolean Enabled = false;
    public static boolean Sneak = false;
    public static boolean LockView = true;
    public static boolean AutoPlace = false;

    // Enable / Disable
    public static void toggle() {
        if (Enabled) {
            Enabled = false;
            Chat.SendMessage("Scaffold Disabled", "red");
        }
        else if (!Enabled) {
            Enabled = true;
            Chat.SendMessage("Scaffold Enabled", "green");
        }
        Sneak = Enabled;
    }

    // Get sneak state
    public static boolean getSneak() {
        return Sneak;
    }

    // Set sneak state
    public static void setSneak(boolean state) {
        Sneak = state;
        Chat.SendMessage("Scaffold Sneak: " + state, "green");
    }

    // Toggle AutoPlace
    public static void toggleAutoPlace() {
        if (AutoPlace) AutoPlace = false;
        else AutoPlace = true;
        Chat.SendMessage("Scaffold AutoPlace: " + AutoPlace, "green");
    }

    // Toggle LockView
    public static void toggleLockView() {
        if (LockView) LockView = false;
        else LockView = true;
        Chat.SendMessage("Scaffold LockView: " + LockView, "green");
    }



    
    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return; // see EntityPlayer.onUpdate
        if (event.player instanceof EntityPlayerSP) {
            final EntityPlayerSP player = (EntityPlayerSP) event.player;

//            player.movementInput.sneak = true;
//            Minecraft.getMinecraft().player.setSneaking(true);

            // Store player looking at direction
//            int LookingDirection2 = MathHelper.floor((double)((event.player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
//            Chat.SendMessage(String.valueOf(MathHelper.floor((double)((event.player.rotationYaw * 8F) / 360F) + 0.5D) & 7), "green");
            int LookingDirection2 = MathHelper.floor((double)((event.player.rotationYaw * 8F) / 360F) + 0.5D) & 7;
            Data.setLookingDirection(LookingDirection2);
            String LookingDirection = Data.getLookingDirection();

            float playerX = (float) player.posX;
            float playerY = (float) player.posY;
            float playerZ = (float) player.posZ;
            float playerHeadPitch = player.rotationPitch;
//            float playerHeadYaw = player.rotationYaw;
            float blockUnderX = player.getPosition().down().getX();
//            float blockUnderY = player.getPosition().down().getY();
            float blockUnderZ = player.getPosition().down().getZ();

            if (!Enabled) return;

//            Chat.SendMessage(LookingDirection, "red");

            if (LookingDirection=="SOUTH"){
                if (playerZ < blockUnderZ) {
                    // System.out.println("SOUTH OUT");
                    Sneak = true;

                    if (LockView) {
                        player.rotationPitch = Float.parseFloat("82.9"); // Set camera pitch
                        player.rotationYaw = Float.parseFloat("0"); // Set camera yaw
                    }

                    if (AutoPlace) {
                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
                    }
                } else {
                    Sneak = false;
                }
                if (playerHeadPitch > 65 && playerHeadPitch < 86) {
                }
            }

            else if (LookingDirection=="SOUTH_WEST") {
                if (playerHeadPitch > 70 && playerHeadPitch < 85) {
                    Sneak = true;

                    if (LockView) {
                        player.rotationPitch = Float.parseFloat("77.7"); // Set camera pitch
                        player.rotationYaw = Float.parseFloat("47.7"); // Set camera yaw
                    }

                    if (AutoPlace) {
                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
                    }
                } else {
                    Sneak = false;
                }
            }

            else if (LookingDirection=="WEST") {
                if (playerX > blockUnderX) {
                    Sneak = true;

                    if (LockView) {
                        player.rotationPitch = Float.parseFloat("82.9"); // Set camera pitch
                        player.rotationYaw = Float.parseFloat("90"); // Set camera yaw
                    }

                    if (AutoPlace) {
                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
                    }
                } else {
                    Sneak = false;
                }
            }

            else if (LookingDirection=="WEST_NORTH") {
                if (playerHeadPitch > 70 && playerHeadPitch < 85) {
                    Sneak = true;

                    if (LockView) {
                        player.rotationPitch = Float.parseFloat("79.6"); // Set camera pitch
                        player.rotationYaw = Float.parseFloat("134.0"); // Set camera yaw
                    }

                    if (AutoPlace) {
                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
                    }
                } else {
                    Sneak = false;
                }
            }

            else if (LookingDirection=="NORTH") {
                if (playerZ > blockUnderZ) {
                    if (LockView) {
                        player.rotationPitch = Float.parseFloat("82.5"); // Set camera pitch
                        player.rotationYaw = Float.parseFloat("-180"); // Set camera yaw
                    }

                    if (AutoPlace) {
                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
                    }

                    Sneak = true;
                } else {
                    Sneak = false;
                }
            }

            else if (LookingDirection=="NORTH_EAST") {
                if (playerHeadPitch > 70 && playerHeadPitch < 85) {
                    Sneak = true;

                    if (LockView) {
                        player.rotationPitch = Float.parseFloat("79.6"); // Set camera pitch
                        player.rotationYaw = Float.parseFloat("-134.0"); // Set camera yaw
                    }

                    if (AutoPlace) {
                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
                    }
                } else {
                    Sneak = false;
                }
            }

            else if (LookingDirection=="EAST") {
                if (playerX < blockUnderX) {
                    Sneak = true;

                    if (LockView) {
                        player.rotationPitch = Float.parseFloat("82.9"); // Set camera pitch
                        player.rotationYaw = Float.parseFloat("-90"); // Set camera yaw
                    }

                    if (AutoPlace) {
                        KeyBinding.onTick(new GameSettings().keyBindUseItem.getKeyCode()); // Right click (place block)
                    }
                } else {
                    Sneak = false;
                }
            }
        }
    }
}
