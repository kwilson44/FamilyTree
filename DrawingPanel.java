import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    private List<FamilyNode> nodes;
    private List<Edge> edges;
    private FamilyTree familyTree;
    private int levelHeight = 100;
    private int nodeWidth = 50;
    private Map<FamilyNode, Color> parentColors;

    public DrawingPanel(FamilyTree familyTree) {
        this.familyTree = familyTree;
        this.nodes = familyTree.getNodes();
        this.edges = familyTree.getEdges();
        this.parentColors = new HashMap<>();
        setPreferredSize(new Dimension(1000, 1000));
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
    
        g.setColor(getParentColor(node));
        g.fillOval(x - nodeWidth/2, y - nodeWidth/2, nodeWidth, nodeWidth);
        g.setColor(Color.BLACK);
        g.drawOval(x - nodeWidth/2, y - nodeWidth/2, nodeWidth, nodeWidth);
        
        FontMetrics fm = g.getFontMetrics();
        int textX = x - fm.stringWidth(node.getValue()) / 2;
        int textY = y + fm.getHeight() / 4;
        g.drawString(node.getValue(), textX, textY);
    
        int childX = levelStartX + nodeWidth/2;
        int childY = levelY + nodeWidth/2;
    
        for (int i = 0; i < numChildren; i++) {
            FamilyNode child = node.getChildren().get(i);
            int childLevelY = childY + levelHeight;
    
            g.setColor(getParentColor(node)); // set edge color to parent color
            
            // draw line from parent node to child node
            g.drawLine(x, y + nodeWidth/2, childX, levelY);
    
            // draw line from child node to level below
            g.setColor(getParentColor(child)); // set edge color to child's parent color
            g.drawLine(childX, levelY, childX, childLevelY - nodeWidth/2);
    
            drawFamilyTree(g, childX, childLevelY, child);
            childX += 3.5*nodeWidth;
        }
    }
    
    private Color getParentColor(FamilyNode node) {
        if (parentColors.containsKey(node)) {
            return parentColors.get(node);
        } else {
            Color color = generateRandomColor();
            parentColors.put(node, color);
            return color;
        }
    }
    
    private Color generateRandomColor() {
        float hue = (float) Math.random();
        float saturation = 0.9f;
        float brightness = 1.0f;
        return Color.getHSBColor(hue, saturation, brightness);
    }
}
