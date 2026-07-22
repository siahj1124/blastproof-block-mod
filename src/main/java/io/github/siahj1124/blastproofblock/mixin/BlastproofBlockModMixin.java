package io.github.siahj1124.blastproofblock.mixin;

import java.util.List;

import io.github.siahj1124.blastproofblock.BlastproofBlockModTags;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(Explosion.class)
public class BlastproofBlockModMixin {

    @Shadow
    private World world;

    @Shadow
    private ObjectArrayList<BlockPos> affectedBlocks;


	@Inject(method = "affectWorld", at = @At("HEAD"))
    private void protectBlocks(boolean particles, CallbackInfo ci) {

        affectedBlocks.removeIf(pos ->shouldProtect(world, pos));
    }
    
    @Unique
    private static boolean shouldProtect(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);

        if (state.isIn(BlastproofBlockModTags.BLAST_PROOF_BLOCKS)) {
            return true;
        }

        BlockState above = world.getBlockState(pos.up());

        return above.isIn(BlastproofBlockModTags.BLAST_PROOF_BLOCKS);
    }
}