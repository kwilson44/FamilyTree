// Importing the JFrame class from the javax.swing package.
import javax.swing.JFrame;

// Defining a new class called DrawingFrame that extends the JFrame class.
public class DrawingFrame extends JFrame {

    // Declaring an instance variable called panel of type DrawingPanel.
    DrawingPanel panel;
    
    // Declaring an instance variable called familyTree of type FamilyTree.
    private FamilyTree familyTree;

    // Defining a constructor for DrawingFrame that takes a FamilyTree object as an argument.
    public DrawingFrame(FamilyTree familyTree) {

        // Initializing the instance variable familyTree with the argument passed to the constructor.
        this.familyTree = familyTree;

        // Setting the title of the JFrame to "Family Tree".
        this.setTitle("Family Tree");

        // Setting the default close operation for the JFrame to exit the program when closed.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initializing the instance variable panel with a new instance of the DrawingPanel class and passing the familyTree object as an argument.
        this.panel = new DrawingPanel(familyTree);

        // Adding the panel to the JFrame.
        this.add(panel);

        // Resizing the JFrame to fit the panel.
        this.pack();

        // Setting the location of the JFrame to the center of the screen.
        this.setLocationRelativeTo(null);

        // Setting the JFrame to be visible.
        this.setVisible(true);
    }
}
