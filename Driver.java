import java.util.Scanner;

public class Driver {
    
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Graph graph = new Graph(); 
        boolean active = true;
        String input = "Intro";
        String TheRoot = "";
        String RomanticOrFamilialRoot = "";
        String person = "";

        // Welcome message and ask user for input to set root
        System.out.println("Welcome user!\nWe're going to start by creating the head of the family (aka the root). Please give me the last name of one of your grandparents:");
        TheRoot = userInput.nextLine();
        FamilyTree tree = new FamilyTree(TheRoot, "01/01/1950");
  
      
        // Main program loop
        while (active) {
            switch (input) {
                case "Intro":
                    // Ask user for input on what to do next
                    System.out.println("Please type one of these options:\nTo add a family member, enter '1'\nTo output the tree in infix notation, enter '2'\nTo output the tree in prefix notation, enter '3'\nTo output the tree in postfix notation, enter '4'\nEnter 'Done' to exit.");
                    input = userInput.nextLine();
                    break;

                case "1":
                    // Add a family member
                    System.out.println("Adding a family member...What's the parent's name?\n");
                    RomanticOrFamilialRoot = userInput.nextLine();
                    FamilyNode parent = tree.findNode(tree.getRoot(), RomanticOrFamilialRoot);
                    if (parent == null) {
                        // If the parent doesn't exist, inform user and break
                        System.out.println("Parent not found. Please try again.");
                        break;
                    }
                    System.out.println("What's the name of the person you're adding?\n");
                    person = userInput.nextLine();
                    // System.out.println("And what's the person's birthday?\n");
                    // DoB = userInput.nextLine();
                    tree.insert(parent, person, "0");
                    
                    // Add the tree to the drawing panel and add the panel to the graph
                    DrawingPanel panel = new DrawingPanel(tree);
                    DrawingFrame frame = new DrawingFrame(tree);
                    frame.add(panel);
                    frame.setVisible(true);
                    
                    // Go back to the intro screen
                    input = "Intro";
                    break;
                
                case "2":
                    // Output the tree in infix notation
                    System.out.println("The tree in infix notation: " + tree.infixTraversal());
                    input = "Intro";
                    break;

                case "3":
                    // Output the tree in prefix notation
                    System.out.println("The tree in prefix notation: " + tree.prefixTraversal());
                    input = "Intro";
                    break;

                case "4":
                    // Output the tree in postfix notation
                    System.out.println("The tree in postfix notation: " + tree.postfixTraversal());
                    input = "Intro";
                    break;
                 
                case "Done":
                    // End the program
                    active = false;
                    break;
                    
                default:
                    // If user enters an invalid option, inform user and go back to the intro screen
                    System.out.println("Invalid input. Please try again.");
                    input = "Intro";
                    break;
            }
        }
    }
}
