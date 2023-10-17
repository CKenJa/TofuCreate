package mod.ckenja.tofucreate.register;

import baguchan.tofucraft.TofuCraftReload;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import mod.ckenja.tofucreate.TofuCreate;
import mod.ckenja.tofucreate.fluid.ColorFluidType;
import net.minecraft.resources.ResourceLocation;

public class AllFluids {
    public static final CreateRegistrate registrate = TofuCreate.registrate;

    public static final FluidEntry<VirtualFluid> SOYMILK_ANNIN =
            registrate.virtualFluid("soymilk_annin", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0xFFFFFF), VirtualFluid::new)
                    .lang("Soymilk Annin")
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_APPLE =
            registrate.virtualFluid("soymilk_apple", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0xEEDC85), VirtualFluid::new)
                    .lang("Soymilk Apple")
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_COCOA =
            registrate.virtualFluid("soymilk_cocoa", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0x8B3C0D), VirtualFluid::new)
                    .lang("Soymilk Cocoa")
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_FRUITS =
            registrate.virtualFluid("soymilk_fruits", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0xF7C00A), VirtualFluid::new)
                    .lang("Soymilk Fruits")
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_HONEY =
            registrate.virtualFluid("soymilk_honey", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0xFFA65B), VirtualFluid::new)
                    .lang("Soymilk Honey")
                    .register();
    public static final FluidEntry<VirtualFluid> SOYMILK_KINAKO =
            registrate.virtualFluid("soymilk_kinako", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0xD3B92C), VirtualFluid::new)
            .lang("Soymilk Kinako")
            .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_PUDDING =
            registrate.virtualFluid("soymilk_pudding", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0xEEDC85), VirtualFluid::new)
                    .lang("Soymilk Pudding")
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_PUMPKIN =
            registrate.virtualFluid("soymilk_pumpkin", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0xFFA556), VirtualFluid::new)
                    .lang("Soymilk Pumpkin")
                    .register();

    public static final FluidEntry<VirtualFluid> SOYMILK_RAMUNE =
            registrate.virtualFluid("soymilk_ramune", new ResourceLocation(TofuCraftReload.MODID, "block/soymilk"), new ResourceLocation(TofuCraftReload.MODID, "block/soymilk_flow"), ColorFluidType.create(0x9EC4FB), VirtualFluid::new)
                    .lang("Soymilk Ramune")
                    .register();
    public static void register() {}


}
