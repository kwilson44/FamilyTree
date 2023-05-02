import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

public class GeomGraph extends Graph {
    private ArrayList<Point> points;

    public GeomGraph() {
        super();
        points = new ArrayList<Point>();
    }

    public void addVertex(FamilyNode v, Point p) {
        super.addVertex(v);
        points.add(p);
    }

    public void deleteVertex(FamilyNode v) {
        int index = super.getVertices().indexOf(v);
        if (index != -1) {
            super.getVertices().remove(index);
            if (!points.isEmpty()) {
                points.remove(index);
            }
            LinkedList<Edge> edgesToRemove = new LinkedList<>();
            for (Edge e : super.getEdges()) {
                if (e.getTail().equals(v) || e.getHead().equals(v)) {
                    edgesToRemove.add(e);
                }
            }
            super.getEdges().removeAll(edgesToRemove);
        }
    }    
    


    public Point getPoint(FamilyNode v) {
        int index = super.getVertices().indexOf(v);
        if (index == -1) {
            return null;
        }
        return points.get(index);
    }

    public void setPoint(FamilyNode v, Point p) {
        int index = super.getVertices().indexOf(v);
        if (index != -1) {
            points.set(index, p);
        }
    }
}
