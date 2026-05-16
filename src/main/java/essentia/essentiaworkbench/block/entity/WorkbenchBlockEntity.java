package essentia.essentiaworkbench.block.entity;

import essentia.essentiaworkbench.menus.WorkbenchMenu;
import essentia.essentiaworkbench.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class WorkbenchBlockEntity extends BlockEntity implements MenuProvider {
    public WorkbenchBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WORKBENCH.get(), pos, state);
    }

    public void lookAround(Level level, BlockPos pos){

    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("block.essentiaworkbench_tab.workbench");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new WorkbenchMenu(containerId, inventory, this);
    }
}
