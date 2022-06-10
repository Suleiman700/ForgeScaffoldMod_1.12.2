package com.example.examplemod;

import com.example.examplemod.Keys.KeyInputEvent;
import com.example.examplemod.Movements.BlockEdgeEvent;
import com.example.examplemod.chat.Chat;
import com.example.examplemod.chat.Commands;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "suleimanscaffoldmod";
    public static final String NAME = "Suleiman Scaffold Mod";
    public static final String VERSION = "1.2";


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new Commands());
        MinecraftForge.EVENT_BUS.register(new Chat());

        // Keybindings
        MinecraftForge.EVENT_BUS.register(new KeyInputEvent());

        // Movement
        FMLCommonHandler.instance().bus().register(new BlockEdgeEvent());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
