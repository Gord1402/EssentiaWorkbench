package essentia.essentiaworkbench.client;

import essentia.essentiaworkbench.EssentiaWorkbench;
import essentia.essentiaworkbench.client.screen.WorkbenchScreen;
import essentia.essentiaworkbench.registry.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EssentiaWorkbench.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() ->
                MenuScreens.register(ModMenuTypes.WORKBENCH_MENU.get(), WorkbenchScreen::new)
        );
    }
}