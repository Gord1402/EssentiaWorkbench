package essentia.essentiaworkbench.block.entity;

import essentia.essentiaworkbench.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class WorkbenchBlockEntity extends BlockEntity {
    public WorkbenchBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WORKBENCH.get(), pos, state);
    }
}
