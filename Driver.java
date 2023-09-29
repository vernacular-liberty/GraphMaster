/**
 * The Driver class is responsible for creating the Graph and the user interface.
 * It handles the mouse events and updates the panel accordingly.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Driver {
    Graph graph = new Graph();
    JFrame frame = createFrame();
    JPanel panel = createPanel();
    JLabel label = createLabel();
    JLabel degreesForVertices = new JLabel();
    JToolBar toolbar = createToolBar();
    Boolean end;
    Vertex current;

    /**
     * Constructor for Driver class. Initializes the end variable to false and adds mouse listener to the panel.
     * Also, adds the panel to the frame and sets it visible.
     */
    public Driver(){
        end = false;
        panel.addMouseListener(createMouseListener(panel));
        panel.add(label, BorderLayout.SOUTH);
        degreesForVertices.setBounds(20, 20, 150, 60); 
        panel.add(degreesForVertices, BorderLayout.WEST);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(toolbar, "North");
        frame.setVisible(true);
    }

    /**
     * Creates and returns a new JFrame object with title "Graph Games" and size 600 x 500.
     * @return a new JFrame object
     */
    private JFrame createFrame() {
        JFrame frame = new JFrame("Graph Games");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        return frame;
    }

    /**
     * Creates and returns a new JPanel object.
     * This method also overrides the paintComponent method to draw the vertices and edges of the graph.
     * @return a new JPanel object
     */
    private JPanel createPanel() {
        JPanel panel = new JPanel(new BorderLayout()) {

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawEdges(g);
                drawVertices(g);
            }
        };
        panel.setBackground(new Color(175, 232, 172));
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        return panel;
    }

    /**
     * Creates label with instructions to build a graph.
     * @return label with instructions
     */
    public JLabel createLabel(){
        JLabel label = new JLabel("INSTRUCTIONS: Click to add points.  Drag to make edges.");
        return label;
    }

    /**
     * Creates tool bar and connects the buttons with actions
     * @return ToolBar
     */
    private JToolBar createToolBar() {
        JToolBar toolbar = new JToolBar();
        JButton newButton = new JButton("New Graph");
        newButton.addActionListener(e -> {
            frame.dispose();
            Driver drive = new Driver();
        });
        toolbar.add(newButton);

        JButton degreeOfVerticesButton = new JButton("Find Degree of Vertices");
        degreeOfVerticesButton.addActionListener(e -> {
            label.setText(createLabelForAnalyzeGraph());
        });
        toolbar.add(degreeOfVerticesButton);

        JButton degreeOfVertexButton = new JButton("Find Degree of Each Vertex");
        degreeOfVertexButton.addActionListener(e -> {
            degreesForVertices.setText(drawVertexDegreeLabels());
        });
        toolbar.add(degreeOfVertexButton);
        return toolbar;
    }

    /**
     * Creates label for analyzed graph to explain degree of vertices.
     * @return label for degree of vertices.
     */
    public String createLabelForAnalyzeGraph(){
        AnalyzeGraph analyzedGraph = new AnalyzeGraph(graph);
        String newLabel = "Your Graph's degree of vertices: " + analyzedGraph.degree;
        return newLabel;
    }

    /**
     * Creates JLabel text for each vertices degree
     * @param 
     */
    public String drawVertexDegreeLabels() {
        AnalyzeGraph analyzedGraph = new AnalyzeGraph(graph);
        StringBuilder newDegreeLabel = new StringBuilder("<html>VERTEX DEGREES<br>");
        for (Vertex v : graph.vertices) {
            int degree = analyzedGraph.findVertexDegree(v);
            newDegreeLabel.append("v").append(v.getId()).append(": ").append(degree).append("<br>");
        }
        newDegreeLabel.append("</html>");
        return newDegreeLabel.toString();
    }

    /**
     * Creates and returns a new MouseAdapter object.
     * This method overrides the mousePressed and mouseReleased methods to handle the mouse events.
     * @param panel the panel to which the MouseAdapter will be added
     * @return a new MouseAdapter object
     */
    private MouseAdapter createMouseListener(JPanel panel) {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePress(e, panel);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                handleMouseRelease(e, panel);
            }
        };
    }

    /**
     * Draws the vertices of the graph on the panel.
     * @param g the Graphics object used to draw
     */
    private void drawVertices(Graphics g) {
        for (Vertex v : graph.vertices) {
            g.setColor(new Color(239, 131, 242));
            g.fillOval(v.vertexPoint.getX() - 10, v.vertexPoint.getY() - 10, 20, 20);
            g.setColor(Color.BLACK);
            String id = "" + v.getId();
            g.drawString(id, v.vertexPoint.getX() - 5, v.vertexPoint.getY() + 5);
        }
    }

    /**
     * Draws the edges of the graph on the panel.
     * @param g the Graphics object used to draw
     */
    private void drawEdges(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        for (Edge e : graph.edges) {
            g.drawLine(e.getHead().vertexPoint.getX(), e.getHead().vertexPoint.getY(), e.getTail().vertexPoint.getX(), e.getTail().vertexPoint.getY());
        }
    }

    /**
     * Handles the mouse press event by selecting a vertex at the mouse click point or creating a new vertex if there is none.
     * @param e the MouseEvent object representing the mouse press event
     * @param panel the JPanel object representing the panel where the mouse press event occurred
     */
    private void handleMousePress(MouseEvent e, JPanel panel) {
        for (Vertex v : graph.vertices) {
            if (Math.sqrt(Math.pow(e.getX() - v.vertexPoint.getX(), 2) + Math.pow(e.getY() - v.vertexPoint.getY(), 2)) <= 10) {
                current = v;
                break;
            }
        }
        if (current == null) {
            Vertex v = new Vertex(e.getX(), e.getY());
            graph.addVertex(v);
            current = v;
        }
    }

    /**
     Adds an edge to the graph if a vertex is released over another vertex.
     @param e the MouseEvent object representing the mouse release event
     @param panel the JPanel object where the mouse release event occurred
     */
    private void handleMouseRelease(MouseEvent e, JPanel panel) {
        if (!end) {
            Vertex releasedVertex = null;
            for (Vertex v : graph.vertices) {
                if (Math.sqrt(Math.pow(e.getX() - v.vertexPoint.getX(), 2) + Math.pow(e.getY() - v.vertexPoint.getY(), 2)) <= 10) {
                    releasedVertex = v;
                    break;
                }
            }
            if (releasedVertex != null && releasedVertex != current) {
                graph.addEdge(current, releasedVertex);
            }
            current = null;
            panel.repaint();
        }
    }

    public static void main(String[] args) {
        Driver drive = new Driver();
    }
}
