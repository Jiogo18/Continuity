package me.pepperbell.continuity.client.mixinterface;

import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import org.jetbrains.annotations.Nullable;

public interface ChunkRendererRegionExtension {
	@Nullable Biome continuity$getBiome(BlockPos pos);
}
