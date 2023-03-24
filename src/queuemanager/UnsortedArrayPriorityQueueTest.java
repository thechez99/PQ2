package queuemanager;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class UnsortedArrayPriorityQueueTest {

    private UnsortedArrayPriorityQueue<String> uapq;

    @BeforeEach
    void setUp() {
        uapq = new UnsortedArrayPriorityQueue<>(10);
    }

    @org.junit.jupiter.api.Test
    void addHasOneObject() throws QueueOverflowException {
        uapq.add("Test", 1);

        assertFalse(uapq.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void isEmpty(){
        assertTrue(uapq.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void remove() throws QueueOverflowException, QueueUnderflowException {
        uapq.add("Test", 1);
        uapq.remove();

        assertTrue(uapq.isEmpty());

    }

}
