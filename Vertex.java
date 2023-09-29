/**
 * Represents a vertex in a graph.
*/
public class Vertex {
    static int nextId = 0;
    private int id;
    Point vertexPoint;

    /**
     * Creates a new Vertex object with an automatically generated ID and no point.
     */
    public Vertex() {
        this.id = nextId++;
        this.vertexPoint = null;
    }

    /**
     * Creates a new Vertex object with an automatically generated ID and a point at the given coordinates.
     * @param x The x-coordinate of the vertex point.
     * @param y The y-coordinate of the vertex point.
     */
    public Vertex(int x, int y) {
        this.id = nextId++;
        this.vertexPoint = new Point(x, y);
    }

    /**
     * Gets the ID of the vertex.
     * @return The ID of the vertex.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the ID of the vertex.
     * @param inputId The new ID of the vertex.
     */
    public void setId(int inputId){
        this.id = inputId;
    }

    /**
     * Returns a string representation of the vertex.
     * @return A string representation of the vertex.
     */
    public String vertexToString() {
        return "Vertex " + this.getId();
    }
}