import java.util.List;

public class FamilyNode {
    private String name; // Name of the person represented by this node
    private String birthDate; // Birth date of the person
    private List<FamilyNode> children; // List of child nodes of this node
    private FamilyNode parent; // Parent node of this node
    private Point position; // Position of this node in the graph
    private String id; // ID of this node
    private String label; // Label of this node
    public int x, y; // X and Y coordinates of this node in the graph

    public FamilyNode(String name, String birthDate, List<FamilyNode> children) {
        this.name = name;
        this.birthDate = birthDate;
        this.children = children;
        this.parent = null;
        this.position = new Point(0, 0);
        this.id = null;
        this.label = null;
        this.x = 0;
        this.y = 0;
    }
    
    public FamilyNode(String name, String birthDate, List<FamilyNode> children, int x, int y) {
        this.name = name;
        this.birthDate = birthDate;
        this.children = children;
        this.parent = null;
        this.position = new Point(x, y);
        this.id = null;
        this.label = null;
        this.x = x;
        this.y = y;
    }    

    // Getters and setters for private fields
    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void addChild(FamilyNode child) {
        children.add(child);
        child.setParent(this);
    }

    public List<FamilyNode> getChildren() {
        return children;
    }

    public FamilyNode getParent() {
        return parent;
    }

    public void setParent(FamilyNode parent) {
        this.parent = parent;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }

    public String getValue() {
        return name;
    }

    // Check if the node has any child nodes
    public boolean isEmpty() {
        return children.isEmpty();
    }    

}
