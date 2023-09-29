/**
 * Represents a point in a two-dimensional coordinate system.
 */
public class Point {
    private int x;
    private int y;
    private int radius;

    /**
     * Constructs a new Point object with the specified x and y coordinates.
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.radius = 16;
    }

    /**
     * Returns the x-coordinate of this point.
     * @return the x-coordinate of this point
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of this point.
     * @param x the new x-coordinate of this point
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of this point.
     * @return the y-coordinate of this point
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of this point.
     * @param y the new y-coordinate of this point
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the radius of this point.
     * @return the radius of this point
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of this point.
     * @param radius the new radius of this point
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Returns a string representation of this point.
     * @return a string representation of this point
     */
    public String pointToString() {
        return "Point at (" + x + ", " + y + ") with radius " + radius ;
    }
}
