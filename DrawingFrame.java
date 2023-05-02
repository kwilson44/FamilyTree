import javax.swing.JFrame;

public class DrawingFrame extends JFrame {
    DrawingPanel panel;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private FamilyTree familyTree;

    public DrawingFrame(FamilyTree familyTree) {
        this.familyTree = familyTree;
        this.setTitle("Family Tree");
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new DrawingPanel(familyTree);
        this.add(panel);
        this.setVisible(true);
    }
}
