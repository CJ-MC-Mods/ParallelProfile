package com.cjm721.paralleltick.profile;

import com.cjm721.paralleltick.TickExecutor;
import com.cjm721.paralleltick.api.ParallelInternalTick;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

public class ConfigurableBlock extends Block implements ITileEntityProvider{

    public ConfigurableBlock() {
        super(Material.ROCK);

        setRegistryName("config_block");

        setCreativeTab(ConfigurableTE.creativeTab);
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
        GameRegistry.registerTileEntity(ConfigTE.class, "configTE");
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new ConfigTE();
    }

    public static class ConfigTE extends TileEntity implements ParallelInternalTick {

        public ConfigTE() {
            TickExecutor.INSTANCE.addToInternalTick(this);
        }

        @Override
        public boolean internalTick() {
            if(isInvalid() || this.getWorld().isRemote)
                return false;
            try {
                Thread.sleep(ConfigurableConfig.teSleepTimeMicro,ConfigurableConfig.teSleepTimeNano);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

}
