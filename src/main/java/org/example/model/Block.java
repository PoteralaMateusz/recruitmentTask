package org.example.model;

import java.util.Objects;

public class Block {

    private String color;
    private String material;

    public Block(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Block{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(color, block.color) && Objects.equals(material, block.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material);
    }
}
