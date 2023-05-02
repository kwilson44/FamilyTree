import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FamilyTree {

    private FamilyNode root;

    public FamilyTree(FamilyNode root) {
        this.root = root;
    }
    

    public FamilyTree() {
        root = null;
    }

    public FamilyTree(String name, String birthDate) {
        root = new FamilyNode(name, birthDate, new ArrayList<FamilyNode>());
    }
    public FamilyNode getRoot() {
        return root;
    }
    
    public void insert(FamilyNode parent, String name, String birthDate) {
        if (parent.getChildren().size() < 2) {
            FamilyNode node = new FamilyNode(name, birthDate, new ArrayList<FamilyNode>());
            parent.getChildren().add(node);
        } else {
            System.out.println("Parent already has two children.");
        }
    }

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

    // public FamilyNode findNode(FamilyNode node, String label) {
    //     if (node.getLabel().equals(label)) {
    //         return node;
    //     }
    
    //     System.out.println("Checking node: " + node.getLabel());
    
    //     for (FamilyNode child : node.getChildren()) {
    //         FamilyNode found = findNode(child, label);
    //         if (found != null) {
    //             return found;
    //         }
    //     }
    
    //     return null;
    // }
    

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

    public int getHeight() {
        return getHeight(root);
    }

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
            
            
    }