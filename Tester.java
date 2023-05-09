import java.util.List;

/**
 * This class tests the functionality of the FamilyTree, DrawingPanel, DrawingFrame, and Graph classes.
 * It creates a new family tree and adds some nodes to it. It then creates a DrawingPanel and a DrawingFrame
 * to display the tree. It also prints out the level order traversal, height, and width of the tree.
 */
public class Tester {
    public static void main(String[] args) {
        // Create a new family tree with the root node
        FamilyTree tree = new FamilyTree("Katie", "01/01/1970");

        // Add some children to the root node
        tree.insert(tree.findNode(tree.getRoot(), "Katie"), "Kelly", "01/01/1990");
        tree.insert(tree.findNode(tree.getRoot(), "Katie"), "Kerry", "01/01/1995");
        tree.insert(tree.findNode(tree.getRoot(), "Katie"), "Kim", "01/01/1995");

        // Add some children to Kelly
        tree.insert(tree.findNode(tree.getRoot(), "Kelly"), "Jill", "01/01/2010");
        tree.insert(tree.findNode(tree.getRoot(), "Kelly"), "Jerry", "01/01/2017");
        tree.insert(tree.findNode(tree.getRoot(), "Kelly"), "John", "01/01/2017");

        // Add some children to Kerry
        tree.insert(tree.findNode(tree.getRoot(), "Kerry"), "Jen", "01/01/2012");

        // Print out the level order traversal of the tree
        tree.levelOrderTraversal();

        // Print out the tree
        System.out.println(tree);

        // Print out the height of the tree
        System.out.println("Height of tree: " + tree.getHeight());

        // Print out the width of the tree
        System.out.println("Width of tree: " + tree.getWidth());

        // Prefix traversal example:
        System.out.println("\n=== Testing Prefix ===\n");
        List<FamilyNode> prefixList = tree.prefixTraversal();
        for (FamilyNode node : prefixList) {
            System.out.print(node.getName() + " ");
        }

        System.out.println("\n=== Testing Infix ===\n");
        // Infix traversal example:
        List<FamilyNode> infixList = tree.infixTraversal();
        for (FamilyNode node : infixList) {
            System.out.print(node.getName() + " ");
        }

        System.out.println("\n=== Testing Postfix ===\n");
        // Postfix traversal example:
        List<FamilyNode> postfixList = tree.postfixTraversal();
        for (FamilyNode node : postfixList) {
            System.out.print(node.getName() + " ");
        }

        // Create a new DrawingPanel and DrawingFrame to display the tree
        DrawingPanel panel = new DrawingPanel(tree);
        DrawingFrame frame = new DrawingFrame(tree);

        // Add the tree to the drawing panel and add the panel to the graph
        frame.add(panel);
        frame.setVisible(true);
    }
}
