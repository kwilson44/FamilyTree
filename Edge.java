/**
 * An Edge class representing a relationship between two FamilyNodes in a graph
 */
public class Edge {
    // The tail node of the edge
    private FamilyNode tail;
    // The head node of the edge
    private FamilyNode head;

    /**
     * Constructor for creating an Edge object between two nodes
     * @param tail the tail node of the edge
     * @param head the head node of the edge
     */
    public Edge(FamilyNode tail, FamilyNode head) {
        this.tail = tail;
        this.head = head;
    }

    /**
     * Getter method for the tail node of the edge
     * @return the tail node of the edge
     */
    public FamilyNode getTail() {
        return tail;
    }

    /**
     * Getter method for the head node of the edge
     * @return the head node of the edge
     */
    public FamilyNode getHead() {
        return head;
    }
}
