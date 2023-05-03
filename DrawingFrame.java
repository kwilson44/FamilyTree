import javax.swing.JFrame;

public class DrawingFrame extends JFrame {
    DrawingPanel panel;
    private FamilyTree familyTree;

    public DrawingFrame(FamilyTree familyTree) {
        this.familyTree = familyTree;
        this.setTitle("Family Tree");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new DrawingPanel(familyTree);
        this.add(panel);
        this.pack(); // Resize the JFrame to fit the panel
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
