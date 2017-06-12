package com.cjm721.paralleltick.profile;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ConfigurableTE.MODID, dependencies = "after:paralleltick")
public class ConfigurableTE {

    public static final String MODID = "configurablete";

    public static CreativeTabs creativeTab;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        creativeTab = new CreativeTabs(MODID) {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.BANNER);
            }
        };
        GameRegistry.register(new ConfigurableBlock());
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        System.out.println(String.format("Sleep amount micro: %d nano: %d", ConfigurableConfig.teSleepTimeMicro, ConfigurableConfig.teSleepTimeNano));
    }

}
