package io.github.dmkng.VoidGen;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

@SuppressWarnings("unused")
public class Main extends JavaPlugin {
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new ChunkGenerator() {
			@Override
			public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
				ChunkData chunk = createChunkData(world);
				for(int i = 0; i < 16; ++i) {
					for(int j = 0; j < 16; ++j) {
						biome.setBiome(i, j, Biome.FOREST);
					}
				}
				return chunk;
			}

			@Override
			public Location getFixedSpawnLocation(World world, Random random) {
				world.getBlockAt(0, 0, 0).setType(Material.STONE);
				return new Location(world, 0, 1, 0);
			}
		};
	}
}
