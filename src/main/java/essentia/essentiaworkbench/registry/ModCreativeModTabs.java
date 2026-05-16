package essentia.essentiaworkbench.registry;

import essentia.essentiaworkbench.EssentiaWorkbench;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EssentiaWorkbench.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("essentiaworkbench_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WORKBENCH_ITEM.get()))
                    .title(Component.translatable("essentiaworkbench.creativetab.essentiaworkbench_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WORKBENCH_ITEM.get());
                    })
                    .build());
}
