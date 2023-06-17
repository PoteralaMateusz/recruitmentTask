package org.example.view;

import org.example.exceptions.BlockNotFoundException;
import org.example.model.Block;
import org.example.model.Wall;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Wall wall;

    public Menu() {
        wall = new Wall();
        selectOption();
    }

    private void selectOption() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            menu();
            System.out.println("Select option number:");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                    List<Block> blocks = wall.getBlocks();
                    if (blocks.size() == 0) {
                        System.out.println("Blocks list is empty");
                    } else {
                        System.out.println("Blocks list:");
                        blocks.forEach(System.out::println);
                    }
                }
                case 2 -> {
                    System.out.println("Enter the color:");
                    String color = scanner.nextLine();
                    System.out.println("Enter the material:");
                    String material = scanner.nextLine();
                    wall.addBlock(new Block(color, material));
                    System.out.println("Block is added.");
                }
                case 3 -> {
                    System.out.println("Enter the color:");
                    String color = scanner.nextLine();
                    System.out.println("Enter the material:");
                    String material = scanner.nextLine();
                    try {
                        wall.deleteBlock(new Block(color, material));
                        System.out.println("Block is deleted.");
                    } catch (BlockNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Enter the color to find block:");
                    String color = scanner.nextLine();
                    wall.findBlockByColor(color)
                            .map(block -> {
                                System.out.println(block);
                                return block;
                            }).orElseGet(() -> {
                                System.out.println("Block with color:" + color + " does not exist.");
                                return null;
                            });
                }
                case 5 -> {
                    System.out.println("Enter the material to find blocks:");
                    String material = scanner.nextLine();
                    List<Block> blocksByMaterial = wall.findBlocksByMaterial(material);
                    if (blocksByMaterial.size() == 0) {
                        System.out.println("Blocks with material:" + material + " does not exist");
                    } else {
                        System.out.println("Blocks list with material:" + material);
                        blocksByMaterial.forEach(System.out::println);
                    }
                }

                case 6 -> {
                    System.out.println("Blocks list size is:" + wall.count());
                }
            }
        } while (option != 7);

    }

    private void menu() {
        System.out.println("====================");
        System.out.println("1. Show blocks list.");
        System.out.println("2. Add block.");
        System.out.println("3. Delete block.");
        System.out.println("4. Find block by color.");
        System.out.println("5. Find blocks by Material.");
        System.out.println("6. Show block list count.");
        System.out.println("7. Exit.");
        System.out.println("====================");
    }
}
