package mod.ckenja.tofucreate;

import com.mojang.logging.LogUtils;
import com.simibubi.create.Create;
import com.simibubi.create.compat.tconstruct.SpoutCasting;
import mod.ckenja.tofucreate.create.SpoutTofu;
import mod.ckenja.tofucreate.item.ItemRegister;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.simibubi.create.api.behaviour.BlockSpoutingBehaviour.addCustomSpoutInteraction;

@Mod(BuildConfig.MODID)
public class TofuCreate {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static Item ChargedElementCannon;
    public static final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public TofuCreate(){
        ItemRegister.ITEMS.register(modEventBus);
        addCustomSpoutInteraction(Create.asResource("tofucreate"), new SpoutTofu());
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::processIMC);
        //https://cadiboo.github.io/tutorials/1.15.2/forge/1.4-proxies/
        //プロキシ、いらない
        //DistExecutor.safeRunForDist(()-> ClientProxy::new, () -> ServerProxy::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("登録");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        //使い道、なさそう
    }

    private void processIMC(final InterModProcessEvent event) {
        //そもそも名前なんでこんなわかりにくやつなの
    }
}