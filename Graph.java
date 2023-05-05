import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    // List of all the vertices/nodes in the graph
    private ArrayList<FamilyNode> vertices;

    // List of all the edges in the graph
    private LinkedList<Edge> edges;

    public Graph() {
        // Initialize the lists
        vertices = new ArrayList<FamilyNode>();
        edges = new LinkedList<Edge>();
    }

    // Add a new vertex/node to the graph
    public void addVertex(FamilyNode v) {
        vertices.add(v);
        // Print the updated list of vertices for debugging purposes
        System.out.println("The current vertices are: " + arraylistToString(vertices));
    }

    // Add a new edge to the graph
    public void addEdge(FamilyNode tail, FamilyNode head) {
        Edge edge = new Edge(tail, head);
        edges.add(edge);
    }

    // Find a vertex by its ID
    public FamilyNode getVertexById(String id) {
        for (FamilyNode vertex : vertices) {
            if (vertex.getId().equals(id)) {
                return vertex;
            }
        }
        return null;
    }

    // Find a vertex by its label
    public FamilyNode getVertexByLabel(String label) {
        for (FamilyNode vertex : vertices) {
            if (vertex.getLabel().equals(label)) {
                return vertex;
            }
        }
        return null;
    }

    // Get the list of all vertices in the graph
    public ArrayList<FamilyNode> getVertices() {
        return vertices;
    }

    // Get the list of all edges in the graph
    public LinkedList<Edge> getEdges() {
        return edges;
    }

    // Helper method to convert the list of vertices to a string
    public static String arraylistToString(ArrayList<FamilyNode> vertices) {
        StringBuilder sb = new StringBuilder();
        for (FamilyNode v : vertices) {
            sb.append(v.getLabel()).append(", ");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 2, sb.length()); // remove last ", "
        }
        return sb.toString();
    }

}
