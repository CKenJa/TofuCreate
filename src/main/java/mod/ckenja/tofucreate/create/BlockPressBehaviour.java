package mod.ckenja.tofucreate.create;

import mod.ckenja.tofucreate.TofuCreate;
import baguchan.tofucraft.utils.RecipeHelper;
import com.simibubi.create.content.contraptions.components.press.MechanicalPressTileEntity;
import com.simibubi.create.foundation.tileEntity.TileEntityBehaviour;
import com.simibubi.create.foundation.tileEntity.behaviour.BehaviourType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static com.simibubi.create.content.contraptions.components.press.PressingBehaviour.CYCLE;
import static com.simibubi.create.content.contraptions.components.press.PressingBehaviour.ENTITY_SCAN;

public class BlockPressBehaviour extends TileEntityBehaviour {

    public static final BehaviourType<BlockPressBehaviour> TYPE = new BehaviourType<>();
    //public PressingBehaviour pressingBehaviour;
    public MechanicalPressTileEntity pressTileEntity;
    int entityScanCooldown;
    boolean onBlock;
    public BlockPressBehaviour(MechanicalPressTileEntity tileEntity) {
        super(tileEntity);
        pressTileEntity = tileEntity;
        onBlock = false;
        entityScanCooldown = ENTITY_SCAN;
    }
    public BehaviourType<?> getType(){
        return TYPE;
        //return new BehaviourType<>("tofu_block_press_behaviour");
    }
    @Override
    public void tick() {
        super.tick();

        Level level = getWorld();
        BlockPos worldPosition = getPos();
        TofuCreate.LOGGER.debug(String.valueOf(worldPosition));

        if(!pressTileEntity.pressingBehaviour.running || level == null){
            if(level != null && !level.isClientSide) {
                if (pressTileEntity.getKineticSpeed() == 0)
                    return;
                if (entityScanCooldown > 0)
                    entityScanCooldown--;
                if (entityScanCooldown <= 0) {
                    entityScanCooldown = ENTITY_SCAN;
                    ItemStack result = RecipeHelper.getBitternResult(level.getFluidState(worldPosition.below(2)).getType());
                    if (result != null) {
                        onBlock = true;
                        pressTileEntity.pressingBehaviour.running = true;
                        pressTileEntity.pressingBehaviour.prevRunningTicks = 0;
                        pressTileEntity.pressingBehaviour.runningTicks = 0;
                        pressTileEntity.pressingBehaviour.particleItems.clear();
                        pressTileEntity.pressingBehaviour.mode.headOffset = 19f / 16f;
                        tileEntity.sendData();
                    }
                }
            }
            return;
        }
        if (pressTileEntity.pressingBehaviour.runningTicks == CYCLE / 2 && pressTileEntity.getKineticSpeed() != 0) {
            pressTileEntity.pressingBehaviour.particleItems.clear();
            if (onBlock) {
                onBlock = false;
                if (level.isClientSide)
                    return;
                else
                    tileEntity.sendData();
                ItemStack result = RecipeHelper.getBitternResult(level.getFluidState(worldPosition.below(2)).getType());
                if (result == null)
                    return;
                level.setBlock(worldPosition.below(2), Block.byItem(result.getItem()).defaultBlockState(), 11);
                level.levelEvent(2001, worldPosition.below(2), Block.getId(level.getBlockState(worldPosition.below(2))));
            }
        }
    }
}
