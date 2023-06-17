package org.example.model;

import junit.framework.TestCase;
import org.example.exceptions.BlockNotFoundException;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class WallTest extends TestCase {

    @Test
    public void testAddBlockWhenBlockIsNull() {
        //given
        Wall testWall = new Wall();
        //when
        testWall.addBlock(null);
        //then
        assertEquals(0,testWall.getBlocks().size());
    }

    @Test
    public void testAddBlockWhenBlockIsCorrect() {
        //given
        Wall testWall = new Wall();
        Block blockToAdd = new Block("red","brick");
        //when
        testWall.addBlock(blockToAdd);
        //then
        assertEquals(1,testWall.getBlocks().size());
        assertTrue(testWall.getBlocks().contains(blockToAdd));
    }

    @Test
    public void testDeleteBlockWhenBlockIsNull() throws BlockNotFoundException {
        //given
        Wall testWall = new Wall();
        Block blockToAdd = new Block("red","brick");
        testWall.addBlock(blockToAdd);
        //when
        testWall.deleteBlock(null);
        //then
        assertEquals(1,testWall.getBlocks().size());
    }
    @Test
    public void testDeleteBlockWhenBlockIsExistInList() throws BlockNotFoundException {
        //given
        Wall testWall = new Wall();
        Block blockToAdd = new Block("red","brick");
        testWall.addBlock(blockToAdd);
        Block blockToDelete = new Block("red","brick");
        //when
        testWall.deleteBlock(blockToDelete);
        //then
        assertEquals(0,testWall.getBlocks().size());
    }
    @Test
    public void testDeleteBlockWhenBlockDontExistInList()  {
        //given
        Wall testWall = new Wall();
        Block blockToAdd = new Block("red","brick");
        testWall.addBlock(blockToAdd);
        Block blockToDelete = new Block("white","brick");
        //when
        try {
            testWall.deleteBlock(blockToDelete);
        } catch (Exception e) {
            assertEquals(BlockNotFoundException.class,e.getClass());
        }
        assertEquals(1,testWall.getBlocks().size());

    }

    @Test
    public void testGetBlocks(){
        //given
        Wall testWall = new Wall();
        testWall.addBlock(new Block("red","brick"));
        testWall.addBlock(new Block("white","brick"));
        //when
        List<Block> result = testWall.getBlocks();
        //then
        assertEquals(testWall.getBlocks(), result);
        assertEquals(testWall.getBlocks().get(0),new Block("red","brick"));
        assertEquals(testWall.getBlocks().get(1),new Block("white","brick"));
    }

    @Test
    public void testFindBlockByColorWhenBlockExist(){
        //given
        Wall testWall = new Wall();
        testWall.addBlock(new Block("red","brick"));
        testWall.addBlock(new Block("white","brick"));
        //when
        Optional<Block> result = testWall.findBlockByColor("red");
        //then
        assertTrue(result.isPresent());
        assertEquals(testWall.getBlocks().get(0), result.get());
        assertEquals(testWall.getBlocks().get(0).getColor(), "red");
    }

    @Test
    public void testFindBlockByColorWhenBlockDontExist(){
        //given
        Wall testWall = new Wall();
        testWall.addBlock(new Block("red","brick"));
        testWall.addBlock(new Block("white","brick"));
        //when
        Optional<Block> result = testWall.findBlockByColor("black");
        //then
        assertFalse(result.isPresent());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindBlocksByMaterialWhenBlockExist(){
        //given
        Wall testWall = new Wall();
        testWall.addBlock(new Block("red","brick"));
        testWall.addBlock(new Block("blue","glass"));
        testWall.addBlock(new Block("white","brick"));
        //when
        List<Block> result = testWall.findBlocksByMaterial("brick");
        //then
        assertEquals(2,result.size());
        assertEquals(new Block("white","brick"),result.get(1));
    }

    @Test
    public void testFindBlocksByMaterialWhenBlockDontExist(){
        //given
        Wall testWall = new Wall();
        testWall.addBlock(new Block("red","brick"));
        testWall.addBlock(new Block("blue","glass"));
        testWall.addBlock(new Block("white","brick"));
        //when
        List<Block> result = testWall.findBlocksByMaterial("plastic");
        //then
        assertEquals(0,result.size());
    }

    @Test
    public void testCount(){
        //given
        Wall testWall = new Wall();
        testWall.addBlock(new Block("red","brick"));
        testWall.addBlock(new Block("blue","glass"));
        testWall.addBlock(new Block("white","brick"));
        //when + when
        assertEquals(3,testWall.count());
    }
}