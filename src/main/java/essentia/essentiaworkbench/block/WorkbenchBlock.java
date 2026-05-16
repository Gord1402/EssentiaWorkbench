package essentia.essentiaworkbench.block;

import essentia.essentiaworkbench.block.entity.WorkbenchBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class WorkbenchBlock extends BaseEntityBlock {
    private static final BlockPos[] NEIGHBOR_OFFSETS = {
            new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0),
            new BlockPos(0, 1, 0), new BlockPos(0, -1, 0),
            new BlockPos(0, 0, 1), new BlockPos(0, 0, -1),
    };

    public WorkbenchBlock() {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_PURPLE)
                .strength(50.0F, 1200.0F)
                .sound(SoundType.GLASS));
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level,
                                 BlockPos pos, BlockPos neighbor) {
        if (level instanceof Level worldLevel && !worldLevel.isClientSide()) {
            if (worldLevel.getBlockEntity(pos) instanceof WorkbenchBlockEntity be) {
                be.lookAround(worldLevel, pos);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof MenuProvider menuProvider) {
                NetworkHooks.openScreen((ServerPlayer) player, menuProvider, pos);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new WorkbenchBlockEntity(blockPos, blockState);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL; // BaseEntityBlock defaults to INVISIBLE — this is your bug
    }
}
