package me.pepperbell.continuity.client.util.biome;

import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import me.jellysquid.mods.sodium.client.world.WorldSlice;
import me.pepperbell.continuity.client.mixinterface.ChunkRendererRegionExtension;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.chunk.ChunkRendererRegion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;

public final class BiomeRetriever {
	private static final Provider PROVIDER = createProvider();

	private static Provider createProvider() {
		/*
		ClassLoader classLoader = BiomeRetriever.class.getClassLoader();

		if (FabricLoader.getInstance().isModLoaded("sodium")) {
			try {
				Class<?> worldSliceClass = Class.forName("me.jellysquid.mods.sodium.client.world.WorldSlice", false, classLoader);
				worldSliceClass.getMethod("getBiomeAccess");
				return BiomeRetriever::getBiomeByWorldSlice;
			} catch (ClassNotFoundException | NoSuchMethodException e) {
				//
			}
			return BiomeRetriever::getBiomeByWorldView;
		}

		if (FabricLoader.getInstance().isModLoaded("canvas")) {
			try {
				Class<?> inputRegionClass = Class.forName("grondag.canvas.terrain.region.input.InputRegion", false, classLoader);
				inputRegionClass.getMethod("getBiome", BlockPos.class);
				return BiomeRetriever::getBiomeByInputRegion;
			} catch (ClassNotFoundException | NoSuchMethodException e) {
				//
			}
			return BiomeRetriever::getBiomeByWorldView;
		}

		if (ArrayUtils.contains(ChunkRendererRegion.class.getInterfaces(), ChunkRendererRegionExtension.class)) {
			return BiomeRetriever::getBiomeByExtension;
		}

 		*/
		return BiomeRetriever::getBiomeByWorldView;
	}

	@Nullable
	public static Biome getBiome(BlockRenderView blockView, BlockPos pos) {
		return PROVIDER.getBiome(blockView, pos);
	}

	@ApiStatus.Internal
	public static void init() {
	}

	@Nullable
	private static Biome getBiomeByWorldView(BlockRenderView blockView, BlockPos pos) {
		if (blockView instanceof WorldView) {
			WorldView worldView = (WorldView) blockView;
			return worldView.getBiome(pos);
		}
		return null;
	}

	@Nullable
	private static Biome getBiomeByExtension(BlockRenderView blockView, BlockPos pos) {
		if (blockView instanceof ChunkRendererRegionExtension) {
			ChunkRendererRegionExtension extension = (ChunkRendererRegionExtension) blockView;
			return extension.continuity$getBiome(pos);
		}
		return getBiomeByWorldView(blockView, pos);
	}

	// Sodium
	/*
	@Nullable
	private static Biome getBiomeByWorldSlice(BlockRenderView blockView, BlockPos pos) {
		if (blockView instanceof WorldSlice) {
			WorldSlice worldSlice = (WorldSlice) blockView;
			return worldSlice.getBiome(pos);
		}
		return getBiomeByWorldView(blockView, pos);
	}
	 */

	// Canvas
	/*
	@Nullable
	private static Biome getBiomeByInputRegion(BlockRenderView blockView, BlockPos pos) {
		if (blockView instanceof InputRegion) {
			InputRegion inputRegion = (InputRegion) blockView;
			return inputRegion.getBiome(pos);
		}
		return getBiomeByWorldView(blockView, pos);
	}
	 */

	private interface Provider {
		@Nullable
		Biome getBiome(BlockRenderView blockView, BlockPos pos);
	}
}
