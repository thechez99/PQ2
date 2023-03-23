package queuemanager;

public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T>{

    //Class Variables
    private Node headNode;

    //Class Constructor(s)
    public UnsortedLinkedPriorityQueue(){
        this.headNode = new Node(null, null);
    }

    //Class Override Function(s)
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        PriorityItem<T> priorityItem = new PriorityItem<T>(item, priority);
        Node newNode = new Node(priorityItem, headNode.getNextNode());
        headNode.setNextNode(newNode.getNextNode());
    }

    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty())
            throw new QueueUnderflowException();
        else
            return headNode.getNextNode().getNodeData().getItem();
    }



    class Node{
        private PriorityItem<T> nodeData;
        private SortedLinkedPriorityQueue<T>.Node nextNode;

        //Constructor for head node
        public Node(PriorityItem<T> nodeData){
            this.nodeData = nodeData;
            this.nextNode = null;
        }

        //Constructor for all other nodes
        public Node(PriorityItem<T> nodeData, SortedLinkedPriorityQueue<T>.Node nextNode){
            this.nodeData = nodeData;
            this.nextNode = nextNode;
        }

        public PriorityItem<T> getNodeData(){
            return nodeData;
        }

        public void setNodeData(PriorityItem<T> nodeData){
            this.nodeData = nodeData;
        }

        public SortedLinkedPriorityQueue<T>.Node getNextNode(){
            return nextNode;
        }

        public void setNextNode(SortedLinkedPriorityQueue<T>.Node nextNode){
            this.nextNode = nextNode;
        }
    }

}
