package org.example.model;

import junit.framework.TestCase;
import org.example.exceptions.BlockNotFoundException;
import org.junit.Test;

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
        assertEquals(true,testWall.getBlocks().contains(blockToAdd));
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
}