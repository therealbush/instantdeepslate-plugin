package me.bush.instantdeepslate;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class TweakRegistry {
    private final List<BlockTweak> blockTweaks = new ArrayList<>();

    public TweakRegistry() {
        this.addTweak(Blocks.DEEPSLATE, Blocks.STONE);
        this.addTweak(Blocks.INFESTED_DEEPSLATE, Blocks.INFESTED_STONE);
        this.addTweak(Blocks.CHISELED_DEEPSLATE, Blocks.STONE_BRICKS);

        this.addTweak(Blocks.COBBLED_DEEPSLATE, Blocks.COBBLESTONE);
        this.addTweak(Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.COBBLESTONE_SLAB);
        this.addTweak(Blocks.COBBLED_DEEPSLATE_STAIRS, Blocks.COBBLESTONE_STAIRS);
        this.addTweak(Blocks.COBBLED_DEEPSLATE_WALL, Blocks.COBBLESTONE_WALL);

        this.addTweak(Blocks.DEEPSLATE_BRICKS, Blocks.STONE_BRICKS);
        this.addTweak(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.CRACKED_STONE_BRICKS);
        this.addTweak(Blocks.DEEPSLATE_BRICK_SLAB, Blocks.STONE_BRICK_SLAB);
        this.addTweak(Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.STONE_BRICK_STAIRS);
        this.addTweak(Blocks.DEEPSLATE_BRICK_WALL, Blocks.STONE_BRICK_WALL);

        this.addTweak(Blocks.DEEPSLATE_TILES, Blocks.STONE_BRICKS);
        this.addTweak(Blocks.CRACKED_DEEPSLATE_TILES, Blocks.CRACKED_STONE_BRICKS);
        this.addTweak(Blocks.DEEPSLATE_TILE_SLAB, Blocks.STONE_BRICK_SLAB);
        this.addTweak(Blocks.DEEPSLATE_TILE_STAIRS, Blocks.STONE_BRICK_STAIRS);
        this.addTweak(Blocks.DEEPSLATE_TILE_WALL, Blocks.STONE_BRICK_WALL);

        this.addTweak(Blocks.POLISHED_DEEPSLATE, Blocks.STONE_BRICKS);
        this.addTweak(Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.STONE_BRICK_SLAB);
        this.addTweak(Blocks.POLISHED_DEEPSLATE_STAIRS, Blocks.STONE_BRICK_STAIRS);
        this.addTweak(Blocks.POLISHED_DEEPSLATE_WALL, Blocks.STONE_BRICK_WALL);

        this.addTweak(Blocks.DEEPSLATE_COAL_ORE, Blocks.COAL_ORE);
        this.addTweak(Blocks.DEEPSLATE_IRON_ORE, Blocks.IRON_ORE);
        this.addTweak(Blocks.DEEPSLATE_COPPER_ORE, Blocks.COPPER_ORE);
        this.addTweak(Blocks.DEEPSLATE_GOLD_ORE, Blocks.GOLD_ORE);
        this.addTweak(Blocks.DEEPSLATE_LAPIS_ORE, Blocks.LAPIS_ORE);
        this.addTweak(Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.REDSTONE_ORE);
        this.addTweak(Blocks.DEEPSLATE_EMERALD_ORE, Blocks.EMERALD_ORE);
        this.addTweak(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_ORE);
    }

    private void addTweak(Block block, Block target) {
        this.blockTweaks.add(new BlockTweak(block, target));
    }

    public void enableTweaks() {
        this.blockTweaks.forEach(BlockTweak::enable);
    }

    public void disableTweaks() {
        this.blockTweaks.forEach(BlockTweak::disable);
    }
}
