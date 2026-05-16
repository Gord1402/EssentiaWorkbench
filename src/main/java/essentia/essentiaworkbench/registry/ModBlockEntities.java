package essentia.essentiaworkbench.registry;

import essentia.essentiaworkbench.EssentiaWorkbench;
import essentia.essentiaworkbench.block.entity.WorkbenchBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EssentiaWorkbench.MODID);

    public static final RegistryObject<BlockEntityType<WorkbenchBlockEntity>> WORKBENCH =
            BLOCK_ENTITIES.register("workbench_block_entity",
                    () -> BlockEntityType.Builder.of(WorkbenchBlockEntity::new,
                            ModBlocks.WORKBENCH.get()).build(null));

}
