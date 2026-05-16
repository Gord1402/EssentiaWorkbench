package essentia.essentiaworkbench.registry;

import essentia.essentiaworkbench.EssentiaWorkbench;
import essentia.essentiaworkbench.menus.WorkbenchMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, EssentiaWorkbench.MODID);

    public static final RegistryObject<MenuType<WorkbenchMenu>> WORKBENCH_MENU =
            MENUS.register("workbench_menu",
                    () -> IForgeMenuType.create(WorkbenchMenu::new));
}