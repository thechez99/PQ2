package queuemanager;

public class UnsortedLinkedPriorityQueue<T> implements PriorityQueue<T>{



    class Node{
        private PriorityItem<T> nodeData;
        private SortedLinkedPriorityQueue.Node nextNode;

        //Constructor for head node
        public Node(PriorityItem<T> nodeData){
            this.nodeData = nodeData;
            this.nextNode = null;
        }

        //Constructor for all other nodes
        public Node(PriorityItem<T> nodeData, SortedLinkedPriorityQueue.Node nextNode){
            this.nodeData = nodeData;
            this.nextNode = nextNode;
        }

        public PriorityItem<T> getNodeData(){
            return nodeData;
        }

        public void setNodeData(PriorityItem<T> nodeData){
            this.nodeData = nodeData;
        }

        public SortedLinkedPriorityQueue.Node getNextNode(){
            return nextNode;
        }

        public void setNextNode(SortedLinkedPriorityQueue.Node nextNode){
            this.nextNode = nextNode;
        }
    }

}
