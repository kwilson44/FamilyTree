/**
 * Represents a point in 2D space with integer x and y coordinates.
 */
public class Point {
    private int x;
    private int y;

    /**
     * Constructs a new point with the given x and y coordinates.
     * 
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of this point.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of this point.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the x coordinate of this point.
     * 
     * @param x the new x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate of this point.
     * 
     * @param y the new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
}
