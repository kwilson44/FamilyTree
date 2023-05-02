public class Edge {
    private FamilyNode tail;
    private FamilyNode head;

    public Edge(FamilyNode tail, FamilyNode head) {
        this.tail = tail;
        this.head = head;
    }

    public FamilyNode getTail() {
        return tail;
    }

    public FamilyNode getHead() {
        return head;
    }
}
