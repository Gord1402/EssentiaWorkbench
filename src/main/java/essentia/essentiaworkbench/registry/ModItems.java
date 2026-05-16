package essentia.essentiaworkbench.registry;

import essentia.essentiaworkbench.EssentiaWorkbench;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EssentiaWorkbench.MODID);


    public static final RegistryObject<Item> WORKBENCH_ITEM = ITEMS.register("cutting_table",
            () -> new BlockItem(ModBlocks.WORKBENCH.get(), new Item.Properties()));

}
