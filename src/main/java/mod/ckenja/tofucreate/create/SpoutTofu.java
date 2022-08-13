package mod.ckenja.tofucreate.create;

import baguchan.tofucraft.utils.RecipeHelper;
import com.simibubi.create.api.behaviour.BlockSpoutingBehaviour;
import com.simibubi.create.content.contraptions.fluids.actors.SpoutTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fluids.FluidStack;
import net.minecraft.world.level.Level;

public class SpoutTofu extends BlockSpoutingBehaviour {
    @Override
    public int fillBlock(Level world, BlockPos pos, SpoutTileEntity spout, FluidStack availableFluid, boolean simulate) {
        ItemStack result = RecipeHelper.getBitternResult(world.getFluidState(pos).getType());
        if(result == null)
            return 0;
        world.setBlock(pos, Block.byItem(result.getItem()).defaultBlockState(), 11);
        world.levelEvent(2001, pos, Block.getId(world.getBlockState(pos)));
        return 250;
    }
}