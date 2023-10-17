package mod.ckenja.tofucreate.recipe;

import baguchan.tofucraft.recipe.BitternRecipe;
import baguchan.tofucraft.registry.TofuRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.stream.Stream;

public class BrittenRecipe implements BlockRecipeHelper{

    @Override
    public boolean applyInWorld(Level world, BlockPos pos){
        BlockState blockstate = transformBlock(world.getBlockState(pos.below(2)).getBlock().defaultBlockState());
        if(blockstate==null) return false;
        world.setBlock(pos,blockstate, 11);
        world.levelEvent(2001, pos, Block.getId(world.getBlockState(pos)));
        return true;
    }
    @Override
    public BlockState transformBlock(BlockState block) {
        Fluid fluid = block.getFluidState().getType();
        Stream<Recipe<?>> tofuRecipe = ServerLifecycleHooks.getCurrentServer().getRecipeManager().getRecipes().stream().filter((recipex) -> recipex.getType() == TofuRecipes.RECIPETYPE_BITTERN);

        for (Object recipe : tofuRecipe.toList()) {
            if (recipe instanceof BitternRecipe && ((BitternRecipe) recipe).getFluid().test(new FluidStack(fluid, 1000))) {
                return Block.byItem(((BitternRecipe) recipe).getResultItem().getItem()).defaultBlockState();
            }
        }
        return null;
    }
}
