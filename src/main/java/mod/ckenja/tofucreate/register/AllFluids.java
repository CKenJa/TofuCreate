package mod.ckenja.tofucreate.register;

import baguchan.tofucraft.TofuCraftReload;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.util.entry.FluidEntry;
import mod.ckenja.tofucreate.TofuCreate;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class AllFluids {
    public static final CreateRegistrate registrate = TofuCreate.registrate;

    public static final FluidEntry<VirtualFluid> SOYMILK_ANNIN =
            registrate.virtualFluid("soymilk_annin", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFFFFFF, 0xFFFFFF), VirtualFluid::new)
                    .lang("Soymilk Annin")
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_APPLE =
            registrate.virtualFluid("soymilk_apple", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFEEDC85, 0xEEDC85), VirtualFluid::new)
                    .lang("Soymilk Apple")
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_COCOA =
            registrate.virtualFluid("soymilk_cocoa", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFF8B3C0D, 0x8B3C0D), VirtualFluid::new)
                    .lang("Soymilk Cocoa")
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_FRUITS =
            registrate.virtualFluid("soymilk_fruits", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFF7C00A, 0xF7C00A), VirtualFluid::new)
                    .lang("Soymilk Fruits")
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_HONEY =
            registrate.virtualFluid("soymilk_honey", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFFA65B, 0xFFA65B), VirtualFluid::new)
                    .lang("Soymilk Honey")
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_KINAKO =
            registrate.virtualFluid("soymilk_kinako", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFD3B92C, 0xD3B92C), VirtualFluid::new)
                    .lang("Soymilk Kinako")
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_PUDDING =
            registrate.virtualFluid("soymilk_pudding", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFEEDC85, 0xEEDC85), VirtualFluid::new)
                    .lang("Soymilk Pudding")
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_PUMPKIN =
            registrate.virtualFluid("soymilk_pumpkin", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFFFFA556, 0xFFA556), VirtualFluid::new)
                    .lang("Soymilk Pumpkin")
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_RAMUNE =
            registrate.virtualFluid("soymilk_ramune", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), create(0xFF9EC4FB, 0x9EC4FB), VirtualFluid::new)
                    .lang("Soymilk Ramune")
                    .register();
    public static void register() {}


    public static FluidBuilder.FluidTypeFactory create(int color) {
        return (p, s, f) -> {
            FluidType fluidType = defaultFluidType(p, s, f, color, color);
            return fluidType;
        };
    }

    public static FluidBuilder.FluidTypeFactory create(int color, int colorBlock) {
        return (p, s, f) -> {
            FluidType fluidType = defaultFluidType(p, s, f, color, colorBlock);
            return fluidType;
        };
    }

    public static FluidType defaultFluidType(FluidType.Properties properties, ResourceLocation stillTexture,
                                             ResourceLocation flowingTexture, int color, int colorBlock) {
        return new FluidType(properties) {
            @Override
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new IClientFluidTypeExtensions() {
                    @Override
                    public ResourceLocation getStillTexture() {
                        return stillTexture;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return flowingTexture;
                    }

                    @Override
                    public int getTintColor(FluidStack stack) {
                        return color;
                    }

                    @Override
                    public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
                        return colorBlock;
                    }


                });
            }
        };
    }
}
