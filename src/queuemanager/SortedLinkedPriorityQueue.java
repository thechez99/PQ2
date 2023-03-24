package queuemanager;

public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {

    // Class Variables
    private Node headNode;
    private int size;

    // Class Constructor(s)
    public SortedLinkedPriorityQueue(){
        this.headNode = null;
        this.size = 0;
    }

    //Add a new node to the end of the list
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
            PriorityItem<T> priorityItem = new PriorityItem<T>(item, priority);

            Node addNode = new Node(priorityItem);
            if(isEmpty()){
                headNode = addNode;
            } else {
                Node currentNode = headNode;
                while(currentNode.nextNode != null){
                    currentNode = currentNode.nextNode;
                }
                currentNode.nextNode = addNode;
            }

            size++;
            sort();
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else{
            headNode = headNode.getNextNode();
            size--;
        }
    }

    //Sorts the list by priority
    public void sort(){
        Node currentNode = headNode;
        Node nextNode = headNode.getNextNode();
        PriorityItem<T> temp;

        while(currentNode != null){
            while(nextNode != null){
                if(currentNode.getNodeData().getPriority() > nextNode.getNodeData().getPriority()){
                    temp = currentNode.getNodeData();
                    currentNode.setNodeData(nextNode.getNodeData());
                    nextNode.setNodeData(temp);
                }
                nextNode = nextNode.getNextNode();
            }
            currentNode = currentNode.getNextNode();
        }
    }

    //Gets the highest priority item
    public T getHighestPriority() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        } else{
            return headNode.getNodeData().getItem();
        }
    }

    //Checks if the list is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //Gives back the head node's data
    @Override
    public T head() throws QueueUnderflowException {
        return headNode.getNodeData().getItem();
    }



    class Node{
        private PriorityItem<T> nodeData;
        private Node nextNode;

        //Constructor for head node
        public Node(PriorityItem<T> nodeData){
            this.nodeData = nodeData;
            this.nextNode = null;
        }

        //Constructor for all other nodes
        public Node(PriorityItem<T> nodeData, Node nextNode){
            this.nodeData = nodeData;
            this.nextNode = nextNode;
        }

        public PriorityItem<T> getNodeData(){
            return nodeData;
        }

        public void setNodeData(PriorityItem<T> nodeData){
            this.nodeData = nodeData;
        }

        public Node getNextNode(){
            return nextNode;
        }

        public void setNextNode(Node nextNode){
            this.nextNode = nextNode;
        }
    }

}

/* CODE REFERENCES
 * Dixit, R. (2017) Introduction to Data Structures & Algorithms in Java [online]. LinkedIn Learning. Available at <https://www.linkedin.com/learning/introduction-to-data-structures-algorithms-in-java/what-is-a-linked-list?autoplay=true&resume=false&u=2102796> [24 March 2022]
 * Stackoverflow (2015) Bubble Sort Manually a Linked List in Java [online] Stackoverflow. Available at <https://stackoverflow.com/questions/29869094/bubble-sort-manually-a-linked-list-in-java> [25 March 2022]
 */