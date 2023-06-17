package org.example.model;

import org.example.exceptions.BlockNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock {
    private final List<Block> blocks;

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public void deleteBlock(Block block) throws BlockNotFoundException {
        blocks.remove(blocks
                .stream()
                .filter(block1 -> block1.equals(block))
                .findFirst()
                .orElseThrow(() ->
                        new BlockNotFoundException(block)
                ));
    }

    @Override
    public List<Block> getBlocks() {
        return new ArrayList<>(blocks);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks
                .stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks
                .stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
