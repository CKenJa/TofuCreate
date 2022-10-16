package mod.ckenja.tofucreate.recipe;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fluids.FluidStack;

//参考
//com/simibubi/create/content/contraptions/components/deployer/ManualApplicationRecipe.java
//com/simibubi/create/api/behaviour/BlockSpoutingBehaviour.java

public abstract class BlockRecipeHelper {
    //指定した座標のブロックに処理を行い、可能ならtrueを返す。simulateなら実際に行わない
    public static boolean BlockRecipesApplyInWorld(Level world, BlockPos pos, FluidStack availableFluid ,boolean simulate){
        return false;
    }
    //処理前ブロックを受けて処理後ブロックを返す
    public abstract Block BlockRecipesApply(Block block);
}
