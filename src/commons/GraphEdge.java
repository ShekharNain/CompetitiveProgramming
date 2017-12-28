package commons;

public class GraphEdge {
    private int id;
    private int weight;
    private int srcNode;
    private int destNode;

    public GraphEdge(int id, int weight, int srcNode, int destNode) {
        this.id = id;
        this.weight = weight;
        this.srcNode = srcNode;
        this.destNode = destNode;
    }

    public GraphEdge(int id, int srcNode, int destNode) {
        this.id = id;
        this.srcNode = srcNode;
        this.destNode = destNode;
        this.weight = 1;
    }

    public int getId() { return id; }

    public int getWeight() {
        return weight;
    }

    public int getSrcNode() {
        return srcNode;
    }

    public int getDestNode() {
        return destNode;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphEdge graphEdge = (GraphEdge) o;

        //if (id != graphEdge.id) return false;
        if (weight != graphEdge.weight) return false;
        if (srcNode != graphEdge.srcNode) return false;
        return destNode == graphEdge.destNode;
    }

    @Override
    public int hashCode() {
        int result = weight;
        //result = 31 * result + weight;
        result = 31 * result + srcNode;
        result = 31 * result + destNode;
        return result;
    }
}
