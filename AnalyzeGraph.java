/**
 * Analyzes graph for degree of vertices
 */
public class AnalyzeGraph{
    Graph graph;
    int degree;
    boolean connected;

    AnalyzeGraph(Graph graph){
        this.graph = graph;
        this.degree = findDegree();
        this.connected = isConnected();
    }
    
    /**
     * Finds the number of degrees in a graph
     * @return degrees of vertices
     */
    public int findDegree(){
        int degree = this.graph.edges.size() * 2;
        return degree;
    }

    /**
     * Finds the degree of select vertex
     * @param Vertex to check degree
     * @return degree of individual vertex
     */
    public int findVertexDegree(Vertex v){
        int degree = 0;
        for (Edge e: this.graph.edges){
            if (e.getHead() == v) degree++;
            if (e.getTail() == v) degree++;
        }
        return degree;
    }

    /**
     * Checks if the graph can be considered connected
     * @param vertex 
     * @param visited
     */
    public boolean isConnected() {
        boolean isConnected = true;

        for(Vertex v: this.graph.vertices){
            if (!isVertexConnected(v.getId())){
                isConnected = false;
            }
        }
        return isConnected;
    }

    /**
     * Checks if vertex is connected: used as a head or tail of any edge.
     * @param id identification number for the vertex getting checked
     * @return if vertex is used by an edge.
     */
    public boolean isVertexConnected(int id){
        boolean isVertex = false;

        for (Edge e: this.graph.edges){
            if (e.getHead().getId() == id || e.getTail().getId() == id){
                isVertex = true;
                break;
            }
        }
        return isVertex;
    }
}