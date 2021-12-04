package test;

import logic.BinaryTree;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest{
    private BinaryTree<Integer> bts;
    void setup(){
        bts = new BinaryTree<>((numOne, numTwo) -> Integer.compare(numOne,numTwo));
        bts.addNode(50);
        bts.addNode(10);
        bts.addNode(69);
        bts.addNode(5);
        bts.addNode(34);
        bts.addNode(67);
        bts.addNode(18);
        bts.addNode(40);
        bts.addNode(63);

    }

    //trabajo para casa
    //metodo posOrden
        /*
        isLeaf -> hoja no tiene hijos
        gradeNode -> retorna num hijos

        * */

    @org.junit.jupiter.api.Test
    public void listPresort() {
        setup();
        assertEquals(9,bts.listPresort().size());
        assertEquals(5,bts.listPresort().get(2));
        assertEquals(63,bts.listPresort().get(8));
        assertEquals(50,bts.listPresort().get(0));
    }

    @org.junit.jupiter.api.Test
    @Test
    void listInsort(){
        setup();
        assertEquals(5, bts.listInsort().get(0));
        assertEquals(69, bts.listInsort().get(8));
        assertEquals(40, bts.listInsort().get(4));
        bts.listInsort().forEach(num -> System.out.println(num));
    }

    @org.junit.jupiter.api.Test
    @Test
    void testFindNode(){
        setup();
        assertNotNull(bts.findNode(50));
        assertNotNull(bts.findNode(5));
        assertNotNull(bts.findNode(63));
    }

    @org.junit.jupiter.api.Test
    @Test
    void ListPostSort(){
        setup();
        assertEquals(5, bts.listPosSort().get(0));
        assertEquals(69, bts.listPosSort().get(7));
        //assertEquals(40, bts.listInsort().get(4));
        bts.listInsort().forEach(num -> System.out.println(num));
    }

    @org.junit.jupiter.api.Test
    @Test
    void isLeaf(){
        setup();
        assertEquals(true, bts.isLeaf(bts.findNode(18)));
        assertEquals(true, bts.isLeaf(bts.findNode(40)));
        assertEquals(true, bts.isLeaf(bts.findNode(63)));
        assertEquals(false, bts.isLeaf(bts.findNode(57)));
        assertEquals(false, bts.isLeaf(bts.findNode(10)));
        assertEquals(false, bts.isLeaf(bts.findNode(50)));
    }

    @org.junit.jupiter.api.Test
    @Test
    void gradeNode(){
        setup();
        assertEquals(0, bts.gradeNode(bts.findNode(18)));
        assertEquals(0, bts.gradeNode(bts.findNode(5)));
        assertEquals(2, bts.gradeNode(bts.findNode(34)));
        assertEquals(2, bts.gradeNode(bts.findNode(50)));
        assertEquals(1, bts.gradeNode(bts.findNode(69)));
    }
}