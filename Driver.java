import java.util.Scanner;

public class Driver {
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Graph graph = new Graph(); 
        boolean active = true;
        String input = "Intro";
        String TheRoot = "";
        String RomanticOrFamilialRoot = "";
        // boolean romantic;
        // boolean familial; 
        String person = "";
        String DoB = "";


        System.out.println("Welcome user!\nWe're going to start by creating the head of the family (aka the root). Please give me the last name of one of your grandparents:");
        TheRoot = userInput.nextLine();
        //Add something here to set the user input to be the root.
        FamilyTree tree = new FamilyTree(TheRoot, "01/01/1950");

      

        while (active) {
            switch (input) {
                case "Intro":
                    System.out.println("Please type one of these options:\nTo add a family member, enter '1'\n  To add a marriage or sibling connection, enter '2'\nEnter 'Done' to exit.");
                    input = userInput.nextLine();
                    break;

                    case "1":
                    System.out.println("Adding a family member...What's the parents name?\n");
                    RomanticOrFamilialRoot = userInput.nextLine();
                    FamilyNode parent = tree.findNode(tree.getRoot(), RomanticOrFamilialRoot);
                    if (parent == null) {
                        System.out.println("Parent not found. Please try again.");
                        break;
                    }
                    System.out.println("What's the name of the person you're adding?\n");
                    person = userInput.nextLine();
                    System.out.println("And what's the person's birthday?\n");
                    DoB = userInput.nextLine();
                    tree.insert(parent, person, DoB);
                
                    input = "Intro";
                    break;
                 
                case "Done":
                DrawingPanel panel = new DrawingPanel(tree);
                DrawingFrame frame = new DrawingFrame(tree);
                // Add the tree to the drawing panel and add the panel to the graph
                frame.add(panel);
                frame.setVisible(true);
                    active = false;
                    break;
                    
                default:
                    System.out.println("Invalid input. Please try again.");
                    input = "Intro";
                    break;
            }
        }
    }
}    
