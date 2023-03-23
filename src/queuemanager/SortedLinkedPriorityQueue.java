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

        public Node getNextNode(){
            return nextNode;
        }

        public void setNextNode(Node nextNode){
            this.nextNode = nextNode;
        }
    }

}
