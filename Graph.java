import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private ArrayList<FamilyNode> vertices;
    private LinkedList<Edge> edges;

    public Graph() {
        vertices = new ArrayList<FamilyNode>();
        edges = new LinkedList<Edge>();
    }

    public void addVertex(FamilyNode v) {
        vertices.add(v);
        System.out.println("The current vertices are: " + arraylistToString(vertices));
    }

    public void addEdge(FamilyNode tail, FamilyNode head) {
        Edge edge = new Edge(tail, head);
        edges.add(edge);
    }

    public FamilyNode getVertexById(String id) {
        for (FamilyNode vertex : vertices) {
            if (vertex.getId().equals(id)) {
                return vertex;
            }
        }
        return null;
    }

    public FamilyNode getVertexByLabel(String label) {
        for (FamilyNode vertex : vertices) {
            if (vertex.getLabel().equals(label)) {
                return vertex;
            }
        }
        return null;
    }
    public ArrayList<FamilyNode> getVertices() {
        return vertices;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }

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
