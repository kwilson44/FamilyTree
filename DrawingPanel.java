import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        drawFamilyTree(g, startX, startY, familyTree.getRoot(), nodeWidth, levelHeight, scanner);

    }
    private void drawFamilyTree(Graphics g, int x, int y, FamilyNode node, int nodeWidth, int levelHeight, Scanner sc) {
        if (node == null) {
            return;
        }
        int numChildren = node.getChildren().size();
        int levelWidth = nodeWidth * numChildren;
        int levelStartX = x - levelWidth/2;
        int levelY = y + levelHeight;
    
        // Draw vertical line
        g.setColor(new Color(139, 69, 19)); // brown color
        g.drawLine(x, y + nodeWidth/2, x, levelY);
    
        g.setColor(Color.GREEN);
        g.fillOval(x - nodeWidth/2, y - nodeWidth/2, nodeWidth, nodeWidth);
        g.setColor(Color.BLACK);
        g.drawOval(x - nodeWidth/2, y - nodeWidth/2, nodeWidth, nodeWidth);
        g.drawString(node.getValue(), x, y);
    
        int childX = levelStartX + nodeWidth/2;
        int childY = levelY + nodeWidth/2;
        int lastChildX = childX;
        boolean insertedText = false;
        for (FamilyNode child : node.getChildren()) {
            int childLevelY = childY + levelHeight;
            // Draw vertical line for child node
            g.setColor(new Color(139, 69, 19)); // brown color
            g.drawLine(childX, levelY, childX, childLevelY - nodeWidth/2);
            // Draw horizontal line
            g.drawLine(lastChildX, childLevelY - nodeWidth/2, childX, childLevelY - nodeWidth/2);
            // Insert text above horizontal line, only once
            if (!insertedText && child.getParent() != null && child.getParent().getChildren().get(0) == child) {
                System.out.println("Siblings or Dating(Enter S or D)");
                String text = sc.nextLine();
            if (text =="S"){
                g.drawString("Siblings", (lastChildX + childX)/2, childLevelY - nodeWidth/2 - 5);
                insertedText = true;
            } else if (text =="D"){
                g.drawString("Dating", (lastChildX + childX)/2, childLevelY - nodeWidth/2 - 5);
                insertedText = true;
            }
            
            }
    
            lastChildX = childX;
            drawFamilyTree(g, childX, childY, child, nodeWidth, levelHeight, sc);
            childX += nodeWidth;
        }
    }
    
    // private void drawFamilyTree(Graphics g, int x, int y, FamilyNode node, int nodeWidth, int levelHeight, Scanner sc) {
    //     if (node == null) {
    //         return;
    //     }
    //     int numChildren = node.getChildren().size();
    //     int levelWidth = nodeWidth * numChildren;
    //     int levelStartX = x - levelWidth/2;
    //     int levelY = y + levelHeight;
    
    //     // Draw vertical line
    //     g.setColor(new Color(139, 69, 19)); // brown color
    //     g.drawLine(x, y + nodeWidth/2, x, levelY);
    
    //     g.setColor(Color.GREEN);
    //     g.fillOval(x - nodeWidth/2, y - nodeWidth/2, nodeWidth, nodeWidth);
    //     g.setColor(Color.BLACK);
    //     g.drawOval(x - nodeWidth/2, y - nodeWidth/2, nodeWidth, nodeWidth);
    //     g.drawString(node.getValue(), x, y);
    
    //     int childX = levelStartX + nodeWidth/2;
    //     int childY = levelY + nodeWidth/2;
    //     int lastChildX = childX;
    //     for (FamilyNode child : node.getChildren()) {
    //         int childLevelY = childY + levelHeight;
    //         // Draw vertical line for child node
    //         g.setColor(new Color(139, 69, 19)); // brown color
    //         g.drawLine(childX, levelY, childX, childLevelY - nodeWidth/2);
    //         // Draw horizontal line
    //         g.drawLine(lastChildX, childLevelY - nodeWidth/2, childX, childLevelY - nodeWidth/2);
    //         // Input text above horizontal line, only once
    //     if (child == node.getChildren().get(0)) { // Only add text for first child
    //         System.out.println("Siblings or Dating");
    //         String text = sc.nextLine();
    //         g.drawString(text, (lastChildX + childX)/2, childLevelY - nodeWidth/2 - 5);
    //     }

    //         lastChildX = childX;
    //         drawFamilyTree(g, childX, childY, child, nodeWidth, levelHeight,sc);
    //         childX += nodeWidth;
    //     }
    // }    
    
}
