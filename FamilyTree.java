import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FamilyTree {
    
    // This class represents a family tree data structure. 
    
    private FamilyNode root;

    // The root of the family tree.
    
    public FamilyTree(FamilyNode root) {
        this.root = root;
    }

    // Constructor that takes a root node as a parameter.

    public FamilyTree() {
        root = null;
    }

    // Default constructor that sets the root to null.

    public FamilyTree(String name, String birthDate) {
        root = new FamilyNode(name, birthDate, new ArrayList<FamilyNode>());
    }

    // Constructor that takes a name and birth date for the root node as parameters, 
    // and creates a new tree with the root node initialized with these values.

    public FamilyNode getRoot() {
        return root;
    }
    
    // Returns the root of the family tree.

    public void insert(FamilyNode parent, String name, String birthDate) {
        FamilyNode node = new FamilyNode(name, birthDate, new ArrayList<FamilyNode>());
        parent.getChildren().add(node);
    }

    // Inserts a new node into the family tree with the given parent, name, and birth date.

    public FamilyNode findNode(FamilyNode node, String name) {
        if (node == null) {
            return null;
        }
        if (node.getName().equals(name)) {
            return node;
        }
        for (FamilyNode child : node.getChildren()) {
            FamilyNode result = findNode(child, name);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    // Searches for a node with the given name in the family tree, starting from the given node.

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<FamilyNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            FamilyNode node = queue.poll();
            System.out.print(node.getName() + " ");
            for (FamilyNode child : node.getChildren()) {
                queue.offer(child);
            }
        }
    }

    // Performs a level order traversal of the family tree, printing the names of each node as it visits them.

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<FamilyNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                FamilyNode node = queue.poll();
                sb.append(node.getName()).append(" ");
                for (FamilyNode child : node.getChildren()) {
                    queue.offer(child);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Returns a string representation of the family tree, in level order traversal.

    public int getHeight() {
        return getHeight(root);
    }

    // Returns the height of the family tree (i.e., the maximum depth of any node).

    private int getHeight(FamilyNode node) {
        if (node == null) {
            return 0;
        } else {
            int maxHeight = 0;
            for (FamilyNode child : node.getChildren()) {
                int childHeight = getHeight(child);
                if (childHeight > maxHeight) {
                    maxHeight = childHeight;
                }
            }
            return 1 + maxHeight;
        }
    }


    public int getWidth() {
        int maxWidth = 0;
        for (int i = 1; i <= getHeight(); i++) {
            int width = getWidth(root, i);
            if (width > maxWidth) {
                maxWidth = width;
            }
        }
        return maxWidth;
    }

    private int getWidth(FamilyNode node, int level) {
        if (node == null)
        {
            return 0;
            }
            if (level == 1) {
            return 1;
            } else if (level > 1) {
            int leftWidth = getWidth(node.getChildren().get(0), level - 1);
            int rightWidth = 0;
            if (node.getChildren().size() > 1) {
            rightWidth = getWidth(node.getChildren().get(1), level - 1);
            }
            return leftWidth + rightWidth;
            }
            return 0;
            }

            public List<FamilyNode> getNodes() {
                List<FamilyNode> nodes = new ArrayList<>();
                collectNodes(root, nodes);
                return nodes;
            }
            
            public List<Edge> getEdges() {
                List<Edge> edges = new ArrayList<>();
                collectEdges(root, edges);
                return edges;
            }
            
            private void collectNodes(FamilyNode node, List<FamilyNode> nodes) {
                if (node == null) {
                    return;
                }
                nodes.add(node);
                for (FamilyNode child : node.getChildren()) {
                    collectNodes(child, nodes);
                }
            }
            
            private void collectEdges(FamilyNode node, List<Edge> edges) {
                if (node == null) {
                    return;
                }
                for (FamilyNode child : node.getChildren()) {
                    edges.add(new Edge(node, child));
                    collectEdges(child, edges);
                }
            }
            
            public List<FamilyNode> prefixTraversal() {
                List<FamilyNode> result = new ArrayList<>();
                prefixTraversalHelper(root, result);
                return result;
            }
            
            private void prefixTraversalHelper(FamilyNode node, List<FamilyNode> result) {
                if (node == null) {
                    return;
                }
                result.add(node);
                for (FamilyNode child : node.getChildren()) {
                    prefixTraversalHelper(child, result);
                }
            }
            
            public List<FamilyNode> infixTraversal() {
                List<FamilyNode> result = new ArrayList<>();
                infixTraversalHelper(root, result);
                return result;
            }
            
            private void infixTraversalHelper(FamilyNode node, List<FamilyNode> result) {
                if (node == null) {
                    return;
                }
                int numChildren = node.getChildren().size();
                if (numChildren == 0) {
                    result.add(node);
                } else if (numChildren == 1) {
                    infixTraversalHelper(node.getChildren().get(0), result);
                    result.add(node);
                } else {
                    infixTraversalHelper(node.getChildren().get(0), result);
                    result.add(node);
                    for (int i = 1; i < numChildren; i++) {
                        infixTraversalHelper(node.getChildren().get(i), result);
                        result.add(node);
                    }
                }
            }
            
            public List<FamilyNode> postfixTraversal() {
                List<FamilyNode> result = new ArrayList<>();
                postfixTraversalHelper(root, result);
                return result;
            }
            
            private void postfixTraversalHelper(FamilyNode node, List<FamilyNode> result) {
                if (node == null) {
                    return;
                }
                for (FamilyNode child : node.getChildren()) {
                    postfixTraversalHelper(child, result);
                }
                result.add(node);
            }
            
            
    }