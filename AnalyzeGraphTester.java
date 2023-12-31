/**
 * Tests functions for AnalyzeGraph
 */
public class AnalyzeGraphTester{
    
    public static void testFindDegree(){
        System.out.println("1. Tests findDegree");
        Graph graph = new Graph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1);
        graph.addEdge(v0, v2);
        graph.addEdge(v0, v3);
        graph.addEdge(v2, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v3);

        AnalyzeGraph analyze = new AnalyzeGraph(graph);
        System.out.println("Input: " + graph.graphToString());
        System.out.println("Output: " + analyze.degree);
    }

    public static void testFindVertexDegree(){
        System.out.println("2. Tests findVertexDegree");
        Graph graph = new Graph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1);
        graph.addEdge(v0, v2);
        graph.addEdge(v0, v3);
        graph.addEdge(v2, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v3);

        AnalyzeGraph analyze = new AnalyzeGraph(graph);
        System.out.println("Input Graph: " + graph.graphToString());
        System.out.println("Input Vertex: " + v2.vertexToString());
        System.out.println("Output: " + analyze.findVertexDegree(v2));
    }

    public static void testIsConnected(){
        System.out.println("3. Tests isConnected");
        Graph graph = new Graph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1);
        // graph.addEdge(v0, v2);
        // graph.addEdge(v0, v3);
        graph.addEdge(v2, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v3);

        AnalyzeGraph analyze = new AnalyzeGraph(graph);
        System.out.println("Input: " + graph.graphToString());
        System.out.println("Output: " + analyze.connected);
    }

    public static void testIsVertexConnected(){
        System.out.println("4. Tests isVertexConnected");
        Graph graph = new Graph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1);
        // graph.addEdge(v0, v2);
        // graph.addEdge(v0, v3);
        graph.addEdge(v2, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v3);

        AnalyzeGraph analyze = new AnalyzeGraph(graph);
        System.out.println("Input: " + graph.graphToString());
        System.out.println("Output: " + analyze.isVertexConnected(v0.getId()));
    }

    public static void testIsFullyConnected(){
        System.out.println("5. Tests isFullyConnected");
        Graph graph = new Graph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1);
        // graph.addEdge(v0, v2);
        // graph.addEdge(v0, v3);
        graph.addEdge(v2, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v3);

        AnalyzeGraph analyze = new AnalyzeGraph(graph);
        System.out.println("Input: " + graph.graphToString());
        System.out.println("Output: " + analyze.isVertexConnected(v0.getId()));
    }

    public static void testCalculateConnectivity(){
        System.out.println("6. Tests: calculateConnectivity()");
        Graph graph = new Graph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1);
        // graph.addEdge(v0, v2);
        // graph.addEdge(v0, v3);
        graph.addEdge(v2, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v3);

        AnalyzeGraph analyze = new AnalyzeGraph(graph);
        System.out.println("Input: " + graph.graphToString());
        System.out.println("Output: " + analyze.connectivity);
    }

    public static void testIsKConnected(){
        System.out.println("7. Tests: calculate isKConnected()");
        Graph graph = new Graph();
        Vertex v0 = new Vertex();
        Vertex v1 = new Vertex();
        Vertex v2 = new Vertex();
        Vertex v3 = new Vertex();

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        graph.addEdge(v0, v1);
        // graph.addEdge(v0, v2);
        // graph.addEdge(v0, v3);
        graph.addEdge(v2, v1);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v3);

        AnalyzeGraph analyze = new AnalyzeGraph(graph);
        System.out.println("Input: " + graph.graphToString());
        System.out.println("Output: " + analyze.kConnected);
    }

    public static void main(String[] args){
        testFindDegree();
        testIsConnected();
        testIsVertexConnected();
        testFindVertexDegree();
        testIsFullyConnected();
        testCalculateConnectivity();
    }
}