package com.blackspider.egyptian;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.blackspider.egyptian.blocks.BlockList;
import com.blackspider.egyptian.items.ItemList;

import java.util.stream.Collectors;

@Mod("egyptian")
public class Egyptian
{
	public static Egyptian instance;
	public static final String modid = "egyptian";
    private static final Logger LOGGER = LogManager.getLogger(modid);

    public Egyptian() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Setup method Registered");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	LOGGER.info("Client method Registered");
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("egyptian", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
    	//Items
    	@SubscribeEvent
    	public static void registerItem(final RegistryEvent.Register<Item> event)
    	{
    		event.getRegistry().registerAll
    		(
    				/*>>>>items<<<<*/
    				
    				//gems
    				
    				//ingots
    				ItemList.azurite_stone = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("azurite_stone")),
    				ItemList.senthurite_ingot = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("senthurite_ingot")),
    				
    				//sun bathed
    				ItemList.sun_bathed_gold = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("sun_bathed_gold")),
    				ItemList.sun_bathed_rod = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("sun_bathed_rod")),
    				
    				//plates
    				ItemList.iron_plate = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("iron_plate")),
    				ItemList.gold_plate = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("gold_plate")),
    				
    				//tools
    				ItemList.staff_senthurite = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("staff_senthurite")),
    				ItemList.chisel = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("chisel")),
    				ItemList.hammer = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("hammer")),
    				ItemList.guide_book = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("guide_book")),
    				
    				//patterns
    				ItemList.blank_pattern = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("blank_pattern")),
    				ItemList.pattern_pyramid = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("pattern_pyramid")),
    				
    				//scrolls
    				ItemList.blank_scroll = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("blank_scroll")),
    				ItemList.written_scroll = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("written_scroll")),
    				
    				//misc
    				ItemList.papyrus_paper = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("papyrus_paper")),
    				ItemList.sun_crystal = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("sun_crystal")),
    				
    				
    				/*>>>>blocks<<<<*/
    				ItemList.small_pedestal_block = new BlockItem(BlockList.small_pedestal_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.small_pedestal_block.getRegistryName()),
    				ItemList.sun_bathed_gold_block = new BlockItem(BlockList.sun_bathed_gold_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.sun_bathed_gold_block.getRegistryName())

    		);
    		LOGGER.info("Items Registered");
    	}
    	
    	private static ResourceLocation location(String name) 
    	{
    		return new ResourceLocation(modid, name);
    	}
    	
    	//blocks
        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) 
        {
        	event.getRegistry().registerAll
        	(
        			BlockList.small_pedestal_block = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.STONE)).setRegistryName(location("small_pedestal_block")),
        			BlockList.sun_bathed_gold_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(7).sound(SoundType.METAL)).setRegistryName(location("sun_bathed_gold_block"))
        	);
            LOGGER.info("Blocks Registered");
        }
    }
}
