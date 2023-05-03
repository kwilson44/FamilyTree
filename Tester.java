public class Tester {
    public static void main(String[] args) {

        Graph graph = new Graph();

        // Create a new family tree with the root node
        FamilyTree tree = new FamilyTree("Katie", "01/01/1970");

        DrawingPanel panel = new DrawingPanel(tree);
        DrawingFrame frame = new DrawingFrame(tree);

        // Add some children to the root node
        tree.insert(tree.findNode(tree.getRoot(), "Katie"), "Kelly", "01/01/1990");
        tree.insert(tree.findNode(tree.getRoot(), "Katie"), "Kerry", "01/01/1995");
        tree.insert(tree.findNode(tree.getRoot(), "Katie"), "Kim", "01/01/1995");


        // Add some children to Kelly
        tree.insert(tree.findNode(tree.getRoot(), "Kelly"), "Jill", "01/01/2010");
        tree.insert(tree.findNode(tree.getRoot(), "Kelly"), "Joe", "01/09/2015");       
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


        // Add the tree to the drawing panel and add the panel to the graph
        frame.add(panel);
        frame.setVisible(true);
    }
}

