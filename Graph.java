/**
 * The Graph class represents a graph data structure.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    List<Vertex> vertices;
    List<Edge> edges;
    int nextId;

    /**
     * Constructs a new, empty graph.
     */
    public Graph() {
        vertices = new ArrayList<>();
        edges = new LinkedList<>();
        nextId = 0;
    }
    
    /**
     * Returns the vertex with the specified ID, or null if no such vertex exists.
     * @param id the ID of the vertex to retrieve
     * @return the vertex with the specified ID, or null if no such vertex exists
     */
    public Vertex getVertex(int id) {
        for (Vertex v : vertices) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    /**
     * Adds a new vertex to the graph.
     * @param v the vertex to add
     */
    public void addVertex(Vertex v) {
        v.setId(nextId++);
        vertices.add(v);
        shift();
    }

    /**
     * Adds a new edge to the graph.
     * @param start the source of the edge
     * @param end the destination for the edge
     */
    public void addEdge(Vertex start, Vertex end) {
        Edge e = new Edge(start, end);
        if (searchEdges(e) == false){
            edges.add(e);
    
        } else{
            System.out.println("This edge is already an edge.");
        }
    }

    /**
     * Searches for edge in graph
     * @param edge edge to look for
     * @return boolean for whether or not edge is in graph
     */
    public boolean searchEdges(Edge edge){
        boolean inEdges = false;
        for (Edge e : edges) {
            if (e.getHead() == edge.getHead() && e.getTail() == edge.getTail() || e.getHead() == edge.getTail() && e.getTail() == edge.getHead()) {
                inEdges = true;
                break;
            } 
        }
        return inEdges;
    }

    /**
     * Shift vertices over in array and assign to proper index 
     */
    public void shift(){
        int count = 0;
        for (Vertex v: vertices){
            if (v.getId() != count){
                v.setId(count);
            }
            count++;
        }
    }

    /**
     * Creates string describing the graph.
     * @return String describing graph
     */
    public String graphToString(){
        String output = "Vertices---";
        for (Vertex v: vertices){
            output += v.vertexToString() + ", ";
        }
        output += "\nEdges---";
        for (Edge e: edges){
            output += e.edgeToString() + ", ";
        }
        return output;
    }

}