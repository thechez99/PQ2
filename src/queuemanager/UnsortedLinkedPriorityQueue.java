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

    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty())
            throw new QueueUnderflowException();
        else{
            SortedLinkedPriorityQueue<T>.Node previous = null;
            SortedLinkedPriorityQueue<T>.Node current = headNode.getNextNode();
            SortedLinkedPriorityQueue<T>.Node temp = current;

            while(current.getNextNode() != null){
                previous = current;
                current = current.getNextNode();
            }

            previous.setNextNode(null);

            headNode.setNextNode(headNode.getNextNode());
        }
    }

    @Override
    public boolean isEmpty() {
        return headNode.getNextNode() == null;
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

/* CODE REFERENCES
 * Dixit, R. (2017) Introduction to Data Structures & Algorithms in Java [online]. LinkedIn Learning. Available at <https://www.linkedin.com/learning/introduction-to-data-structures-algorithms-in-java/what-is-a-linked-list?autoplay=true&resume=false&u=2102796> [24 March 2022]
 * Stackoverflow (2015) Bubble Sort Manually a Linked List in Java [online] Stackoverflow. Available at <https://stackoverflow.com/questions/29869094/bubble-sort-manually-a-linked-list-in-java> [25 March 2022]
 */
