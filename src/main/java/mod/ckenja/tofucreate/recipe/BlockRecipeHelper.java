package mod.ckenja.tofucreate.recipe;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

//参考
//com/simibubi/create/content/contraptions/components/deployer/ManualApplicationRecipe.java
//com/simibubi/create/api/behaviour/BlockSpoutingBehaviour.java

public interface BlockRecipeHelper {
    //指定した座標のブロックに処理を行い、可能ならtrueを返す。simulateなら実際に行わない
    boolean applyInWorld(Level world, BlockPos pos);
    //処理前ブロックを受けて処理後ブロックを返す
    BlockState transformBlock(BlockState in);
}
