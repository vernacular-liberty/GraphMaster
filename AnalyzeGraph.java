/**
 * Analyzes graph for degree of vertices
 */
public class AnalyzeGraph{
    Graph graph;
    int degree;

    AnalyzeGraph(Graph graph){
        this.graph = graph;
        this.degree = findDegree();
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
}