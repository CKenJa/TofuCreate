package mod.ckenja.tofucreate.fluid;

import com.tterrag.registrate.builders.FluidBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.FluidStack;

public class ColorFluidType extends com.simibubi.create.AllFluids.TintedFluidType {

    private int color;

    public static FluidBuilder.FluidTypeFactory create(int fogColor) {
        return (p, s, f) -> {
            ColorFluidType fluidType = new ColorFluidType(p, s, f);
            fluidType.color = fogColor;
            return fluidType;
        };
    }

    private ColorFluidType(Properties properties, ResourceLocation stillTexture,
                           ResourceLocation flowingTexture) {
        super(properties, stillTexture, flowingTexture);
    }

    @Override
    protected int getTintColor(FluidStack stack) {
        return color;
    }

    @Override
    protected int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
        return color;
    }
}