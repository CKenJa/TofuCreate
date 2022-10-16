package mod.ckenja.tofucreate.register;

import com.simibubi.create.content.contraptions.fluids.VirtualFluid;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.FluidEntry;
import mod.ckenja.tofucreate.TofuCreate;

public class AllFluids {
    public static final CreateRegistrate registrate = TofuCreate.registrate;

    public static final FluidEntry<VirtualFluid> SOYMILK_KINAKO =
        registrate.virtualFluid("soymilk_kinako")
            .lang("Soymilk Kinako")
            .register();
    public static void register() {}
}
