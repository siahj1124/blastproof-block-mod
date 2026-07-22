package io.github.siahj1124.blastproofblock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BlastproofBlockModTags {
    public static final TagKey<Block> BLAST_PROOF_BLOCKS = TagKey.of(
        RegistryKeys.BLOCK,
        Identifier.of("blastproof", "blast_proof")
    );

    public static final TagKey<Item> BLAST_PROOF_ITEMS = TagKey.of(
        RegistryKeys.ITEM,
        Identifier.of("blastproof", "blast_proof")
    );
}
