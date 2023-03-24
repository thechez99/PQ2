package queuemanager;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedPriorityQueueTest {

    private SortedLinkedPriorityQueue<String> slpq;

    @BeforeEach
    void setUp() {
        slpq = new SortedLinkedPriorityQueue<>();
    }


    @org.junit.jupiter.api.Test
    void addHasOneObject() throws QueueOverflowException {

        //Adds a test item to the queue
        slpq.add("Test", 1);

        assertFalse(slpq.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmpty(){
        assertTrue(slpq.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void remove() throws QueueOverflowException, QueueUnderflowException {
        slpq.add("Test", 1);
        slpq.remove();

        assertTrue(slpq.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void sortQueue() throws QueueOverflowException, QueueUnderflowException {

        //Adds a test items to the queue
        slpq.add("Test", 1);
        slpq.add("Test2", 2);
        slpq.add("Test3", 3);

        //Sort the Queue
        slpq.sort();

        //Check the head of the queue
        slpq.head();

        //Check head is Test
        assertEquals("Test", slpq.head());
    }

    @org.junit.jupiter.api.Test
    void sortQueueRando() throws QueueOverflowException, QueueUnderflowException {

        //Adds a test items to the queue
        slpq.add("Test4", 4);
        slpq.add("Test2", 2);
        slpq.add("Test", 1);
        slpq.add("Test3", 3);

        //Sort the Queue
        slpq.sort();

        //Check the head of the queue
        slpq.head();

        //Check head is Test
        assertEquals("Test", slpq.head());
    }

    @org.junit.jupiter.api.Test
    void sortQueueRandoNoSort() throws QueueOverflowException, QueueUnderflowException {

        //Adds a test items to the queue
        slpq.add("Test4", 4);
        slpq.add("Test2", 2);
        slpq.add("Test", 1);
        slpq.add("Test3", 3);

        //Check the head of the queue
        slpq.head();

        //Check head is Test
        assertEquals("Test", slpq.head());
    }

    @org.junit.jupiter.api.Test
    void sortQueueRandoNoSortMixPriority() throws QueueOverflowException, QueueUnderflowException {

        //Adds a test items to the queue
        slpq.add("Test4", 1);
        slpq.add("Test2", 2);
        slpq.add("Test", 3);
        slpq.add("Test3", 4);

        //Check the head of the queue
        slpq.head();

        //Check head is Test
        assertEquals("Test4", slpq.head());
    }

}