import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

public class GeomGraph extends Graph {
    // This class extends the Graph class and represents a geometric graph, which is a graph with vertices
    // that are associated with points in 2D space.

    private ArrayList<Point> points; // An ArrayList of points associated with the vertices of the graph.

    public GeomGraph() {
        // Constructor that initializes the GeomGraph object with an empty list of vertices and an empty list of points.
        super();
        points = new ArrayList<Point>();
    }

    public void addVertex(FamilyNode v, Point p) {
        // Method that adds a vertex to the graph and associates it with a point in 2D space.
        super.addVertex(v); // Add the vertex to the list of vertices in the superclass.
        points.add(p); // Add the point to the list of points associated with the vertices in this class.
    }

    public void deleteVertex(FamilyNode v) {
        // Method that removes a vertex from the graph and all edges connected to it.
        int index = super.getVertices().indexOf(v); // Find the index of the vertex in the list of vertices in the superclass.
        if (index != -1) { // If the vertex exists in the list of vertices...
            super.getVertices().remove(index); // Remove it from the list of vertices in the superclass.
            if (!points.isEmpty()) { // If the list of points is not empty...
                points.remove(index); // Remove the point associated with the vertex from the list of points in this class.
            }
            LinkedList<Edge> edgesToRemove = new LinkedList<>(); // Create a linked list to hold the edges to be removed.
            for (Edge e : super.getEdges()) { // For each edge in the list of edges in the superclass...
                if (e.getTail().equals(v) || e.getHead().equals(v)) { // If the edge is connected to the vertex being removed...
                    edgesToRemove.add(e); // Add it to the list of edges to be removed.
                }
            }
            super.getEdges().removeAll(edgesToRemove); // Remove all the edges in the list of edges to be removed from the superclass.
        }
    }

    public Point getPoint(FamilyNode v) {
        // Method that returns the point associated with a vertex in the graph.
        int index = super.getVertices().indexOf(v); // Find the index of the vertex in the list of vertices in the superclass.
        if (index == -1) { // If the vertex does not exist in the list of vertices...
            return null; // Return null.
        }
        return points.get(index); // Return the point associated with the vertex.
    }

    public void setPoint(FamilyNode v, Point p) {
        // Method that sets the point associated with a vertex in the graph.
        int index = super.getVertices().indexOf(v); // Find the index of the vertex in the list of vertices in the superclass.
        if (index != -1) { // If the vertex exists in the list of vertices...
            points.set(index, p); // Set the point associated with the vertex to the given point.
        }
    }
}
