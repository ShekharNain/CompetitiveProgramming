package commons;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    private int id;
    private List<GraphNode> reachableNodes;
    private int value = 0;
    private boolean visited = false;
    private int timeIn = -1;
    private int timeOut = -1;
    private int minTimeIn = Integer.MAX_VALUE;
    private GraphNode parent = this;

    public void resetNode() {
        this.timeIn = -1;
        this.timeOut = -1;
        this.visited = false;
        this.minTimeIn = Integer.MAX_VALUE;
        this.parent = this;
    }

    public GraphNode(int id) {
        this(id, new ArrayList<>());
    }

    public GraphNode(int id, List<GraphNode> reachableNodes) {
        this.id = id;
        this.reachableNodes = reachableNodes;
    }

    public GraphNode getParent() {
        return parent;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public int getMinTimeIn() {
        return minTimeIn;
    }

    public void cmpNSetMinTimeIn(int minTimeIn) {
        this.minTimeIn = Math.min(minTimeIn, this.minTimeIn);
    }

    public int getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<GraphNode> getReachableNodes() {
        return reachableNodes;
    }

    public void setReachableNodes(List<GraphNode> reachableNodes) {
        this.reachableNodes = reachableNodes;
    }

    public void addReachableNode(GraphNode val) {
        this.reachableNodes.add(val);
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isNotVisited() { return !visited; }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode graphNode = (GraphNode) o;

        return id == graphNode.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
