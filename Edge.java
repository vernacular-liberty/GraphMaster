/*
 * Creates an Edge object with a vertex for the head and tail
 */
public class Edge {
    private Vertex head;
    private Vertex tail;

    /**
     * Creates edge object with selected vertices
     * @param head vertex for the source
     * @param tail vertex for the destination
     */
    public Edge(Vertex head, Vertex tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Gets the head vertex
     * @return Vertex for head
     */
    public Vertex getHead() {
        return this.head;
    }

    /**
     * Gets the tail vertex
     * @return Vertex for tail
     */
    public Vertex getTail() {
        return this.tail;
    }

    /**
     * Checks if the edge is between the same vertex
     * @param head Vertex for source
     * @param tail Vertex for destination
     * @return boolean for whether or not head and tail are the same vertex
     */
    public boolean sameVertex(Vertex head, Vertex tail){
        if (head.getId() == tail.getId()){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Creates string describing the edge.
     * @return String describing edge
     */
    public String edgeToString(){
        return "Edge between " + this.head.vertexToString() + " and " + this.tail.vertexToString();
    }
}