package io.github.siahj1124.blastproofblock.mixin;

import io.github.siahj1124.blastproofblock.BlastproofBlockModTags;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlastproofBlockModMixinBlastResistance {
	@Inject(method = "getBlastResistance", at = @At("HEAD"), cancellable = true)
    private void explosionimmunity$getBlastResistance(CallbackInfoReturnable<Float> cir) {
        Block self = (Block) (Object) this;
        if (Registries.BLOCK.getEntry(self).isIn(BlastproofBlockModTags.BLAST_PROOF_BLOCKS)) {
            // Bedrock uses 3.6E7f — using the same value guarantees
            // no vanilla or modded explosion will ever break it.
            cir.setReturnValue(3_600_000.0F);
        }
    }
}