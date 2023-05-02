import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    private List<FamilyNode> nodes;
    private List<Edge> edges;
    private FamilyTree familyTree;

    public DrawingPanel(FamilyTree familyTree) {
        this.familyTree = familyTree;
        this.nodes = familyTree.getNodes();
        this.edges = familyTree.getEdges();
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }

    public DrawingPanel(Graph graph) {
        // Create nodes and edges based on graph here
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int startX = getWidth() / 2;
        int startY = 50;
        int levelHeight = 70;
        int nodeWidth = 60;
        drawFamilyTree(g, startX, startY, familyTree.getRoot(), nodeWidth, levelHeight);
    }
    
    private void drawFamilyTree(Graphics g, int x, int y, FamilyNode node, int nodeWidth, int levelHeight) {
        if (node == null) {
            return;
        }
        int numChildren = node.getChildren().size();
        int levelWidth = nodeWidth * numChildren;
        int levelStartX = x - levelWidth/2;
        int levelY = y + levelHeight;
        
        g.setColor(Color.GREEN);
        g.fillOval(x - nodeWidth/2, y - nodeWidth/2, nodeWidth, nodeWidth);
        g.setColor(Color.BLACK);
        g.drawOval(x - nodeWidth/2, y - nodeWidth/2, nodeWidth, nodeWidth);
        g.drawString(node.getValue(), x, y);
        
        int childX = levelStartX + nodeWidth/2;
        int childY = levelY + nodeWidth/2;
        for (FamilyNode child : node.getChildren()) {
            g.setColor(new Color(139, 69, 19)); // brown color
            g.drawLine(x, y, childX, childY);
            drawFamilyTree(g, childX, childY, child, nodeWidth, levelHeight);
            childX += nodeWidth;
        }
    }
}
