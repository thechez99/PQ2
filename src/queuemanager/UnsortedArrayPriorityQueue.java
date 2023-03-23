package queuemanager;

public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T> {

    // Class Variables

    //Data Storage
    private final Object[] storage;

    //Size of Array
    private final int capacity;

    //Index location of the last object in queue
    private int tailIndex;

    // Class Constructor
    public UnsortedArrayPriorityQueue(int size){
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }

    // Class Functions

    // Overridden functions from interface PriorityQueue
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex++;
        if (tailIndex >= capacity){
            tailIndex--;
            throw new QueueOverflowException();
        } else{
            storage[tailIndex] = new PriorityItem<>(item, priority);
        }
    }


}
