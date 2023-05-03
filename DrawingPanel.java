import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    private List<FamilyNode> nodes;
    private List<Edge> edges;
    private FamilyTree familyTree;
    private int levelHeight = 100;
    private int nodeWidth = 50;


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
        drawFamilyTree(g, startX, startY, familyTree.getRoot());

    }

    private void drawFamilyTree(Graphics g, int x, int y, FamilyNode node) {
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
        
        FontMetrics fm = g.getFontMetrics();
        int textX = x - fm.stringWidth(node.getValue()) / 2;
        int textY = y + fm.getHeight() / 4;
        g.drawString(node.getValue(), textX, textY);
    
        int childX = levelStartX + nodeWidth/2;
        int childY = levelY + nodeWidth/2;
        int lastChildX = childX;
    
        for (int i = 0; i < numChildren; i++) {
            FamilyNode child = node.getChildren().get(i);
            int childLevelY = childY + levelHeight;
    
            g.setColor(new Color(139, 69, 19)); // brown color
            g.drawLine(x, y + nodeWidth/2, childX, levelY);
    
            g.setColor(new Color(139, 69, 19)); // brown color
            g.drawLine(childX, levelY, childX, childLevelY - nodeWidth/2);
    
            g.setColor(Color.BLACK);
            g.drawLine(lastChildX, childLevelY - nodeWidth/2, childX, childLevelY - nodeWidth/2);
    
            drawFamilyTree(g, childX, childLevelY, child);
            childX += 3.5*nodeWidth;
            lastChildX = childX - nodeWidth;

        }
    }
    
    
    }        
