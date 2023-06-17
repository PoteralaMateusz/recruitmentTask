package org.example.exceptions;

import org.example.model.Block;

public class BlockNotFoundException extends Exception {

    public BlockNotFoundException(Block block) {
        super("Block with color:" + block.getColor() + " and material:" + block.getMaterial() + " does not exist");
    }

    public BlockNotFoundException(String message) {
        super(message);
    }

}
