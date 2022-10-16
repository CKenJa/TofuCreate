package mod.ckenja.tofucreate.create;

import com.simibubi.create.content.contraptions.components.structureMovement.MovementBehaviour;
import com.simibubi.create.content.contraptions.components.structureMovement.MovementContext;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class BlockPressMovementBehavior implements MovementBehaviour {
    //アニメーション
    @Override
    public void tick(MovementContext context) {
        if (context.world.isClientSide)
            return;
        if (!context.stall)
            //動作後
            return;

    }

    //処理開始
    @Override
    public void visitNewPosition(MovementContext context, BlockPos pos) {
        if (context.world.isClientSide)
            return;
        //動作中は止めておく
        //context.stall = a != null
    }

    //visitNewPositionに使われるっぽい。
    @Override
    public Vec3 getActiveAreaOffset(MovementContext context) {
        return Vec3.atLowerCornerOf(Direction.DOWN.getNormal()).scale(2);
    }
}
