package essentia.essentiaworkbench.registry;

import essentia.essentiaworkbench.EssentiaWorkbench;
import essentia.essentiaworkbench.block.WorkbenchBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EssentiaWorkbench.MODID);

    public static final RegistryObject<Block> WORKBENCH = BLOCKS.register("workbench", WorkbenchBlock::new);
}
