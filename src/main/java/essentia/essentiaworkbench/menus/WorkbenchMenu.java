package essentia.essentiaworkbench.menus;

import essentia.essentiaworkbench.block.entity.WorkbenchBlockEntity;
import essentia.essentiaworkbench.registry.ModBlocks;
import essentia.essentiaworkbench.registry.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class WorkbenchMenu extends AbstractContainerMenu {

    private final WorkbenchBlockEntity blockEntity;

    public WorkbenchMenu(int containerId, Inventory playerInventory, BlockEntity entity) {
        super(ModMenuTypes.WORKBENCH_MENU.get(), containerId);
        this.blockEntity = (WorkbenchBlockEntity) entity;

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public WorkbenchMenu(int containerId, Inventory playerInventory, FriendlyByteBuf buf) {
        this(containerId, playerInventory,
                playerInventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.blockEntity.getLevel() != null &&
                AbstractContainerMenu.stillValid(
                        ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()),
                        player,
                        ModBlocks.WORKBENCH.get()
                );
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 9; col++)
                addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int col = 0; col < 9; col++)
            addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
    }
}