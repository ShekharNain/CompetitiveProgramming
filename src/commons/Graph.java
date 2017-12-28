package commons;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Graph {
    private GraphType type = GraphType.UNDIRECTED;

    private Set<GraphEdge> edges;
    private GraphNode[] vertices;

    public void resetVertices() {
        Arrays.stream(vertices).forEach((v) -> v.resetNode());
    }

    public GraphNode getNodeById(int id) {
        return vertices[id];
    }

    public void addEdge(int id, int srcId, int destId) {
        addEdge(new GraphEdge(id, srcId, destId));
        if(type == GraphType.UNDIRECTED)
            addEdge(new GraphEdge(id, destId, srcId));
    }

    public  void addEdge(GraphEdge e) {
        edges.add(e);
        if(vertices[e.getSrcNode()] == null)
            vertices[e.getSrcNode()] = new GraphNode(e.getSrcNode());
        vertices[e.getSrcNode()].addReachableNode(new GraphNode(e.getDestNode()));
    }

    public int getNoOfVertices() { return vertices.length; }

    public int getNoOfEdges() { return edges.size(); }

    // Constructors
    /*public Graph() {
        this(new HashSet<>(), new GraphNode[], GraphType.UNDIRECTED);
    }*/
    public Graph(GraphNode[] vertices, Set<GraphEdge> edges) {
        this(vertices, edges, GraphType.UNDIRECTED);
    }

    public Graph(int noOfVertices, int noOfEdges) {this(noOfVertices, noOfEdges, GraphType.UNDIRECTED);}

    public Graph(int noOfVertices, int noOfEdges, GraphType type) {
        this(IntStream.rangeClosed(0,noOfVertices).boxed()
                .map(i -> new GraphNode(i)).toArray(size -> new GraphNode[size]), new HashSet<>(noOfEdges), type);
    }

    public Graph(GraphNode[] vertices, Set<GraphEdge> edges, GraphType type) {
        this.edges = edges;
        this.vertices = vertices;
        this.type = type;
    }

    public Set<GraphEdge> getEdges() {
        return edges;
    }

    public void setEdges(Set<GraphEdge> edges) {
        this.edges = edges;
    }

    public GraphNode[] getVertices() {
        return vertices;
    }

    public void setVertices(GraphNode[] vertices) {
        this.vertices = vertices;
    }


    public enum GraphType {
        DIRECTED, UNDIRECTED;
    }
}
