import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArithExprTree extends FamilyTree {

    public ArithExprTree(FamilyNode root) {
        super(root);
    }

    public ArithExprTree() {
        super();
    }

    public ArithExprTree(String value) {
        this(new FamilyNode(value));
    }

    public int evaluate() {
        return evaluate(getRoot());
    }

    private int evaluate(FamilyNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null.");
        }

        String value = node.getValue();
        if (isOperator(value)) {
            int leftOperand = evaluate(node.getChildren().get(0));
            int rightOperand = evaluate(node.getChildren().get(1));

            switch (value) {
                case "+":
                    return leftOperand + +rightOperand;
                case "-":
                    return leftOperand - rightOperand;
                case "*":
                    return leftOperand * rightOperand;
                case "/":
                    return leftOperand / rightOperand;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + value);
            }
        } else {
            return Integer.parseInt(value);
        }
    }

    private boolean isOperator(String value) {
        return value.length() == 1 && "+-*/".contains(value);
    }

}
