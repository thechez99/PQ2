package queuemanager;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class UnsortedLinkedPriorityQueueTest {

    private UnsortedLinkedPriorityQueue<String> ulpq;

    @BeforeEach
    void setUp() {
        ulpq = new UnsortedLinkedPriorityQueue<>();
    }

    @org.junit.jupiter.api.Test
    void addHasOneObject() throws QueueOverflowException {
        ulpq.add("Test", 1);

        assertFalse(ulpq.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmpty(){
        assertTrue(ulpq.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void remove() throws QueueOverflowException, QueueUnderflowException {
        ulpq.add("Test", 1);
        ulpq.remove();

        assertTrue(ulpq.isEmpty());

    }

    @org.junit.jupiter.api.Test
    void sortQueue() throws QueueOverflowException, QueueUnderflowException {

        //Adds a test items to the queue
        ulpq.add("Test", 1);
        ulpq.add("Test2", 2);
        ulpq.add("Test3", 3);

        //Check the head of the queue
        ulpq.head();

        //Check head is Test
        assertEquals("Test", ulpq.head());
    }
}
