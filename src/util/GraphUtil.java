package util;

import commons.Graph;
import commons.GraphNode;

import java.util.Arrays;
import java.util.Optional;


public class GraphUtil
{
    public static int getCountOfConnectedComp(Graph graph) {
        int cnt = (int) Arrays.stream(graph.getVertices())
                .filter(GraphNode::isNotVisited)
                .map(v -> dfs(graph, v))
                .count();
        graph.resetVertices();
        return cnt;
    }

    private static int dfs(Graph graph, GraphNode src) {
        if(src.isNotVisited()) {
            src.setVisited(true);
            src.getReachableNodes().stream()
                    .filter(v -> v.isNotVisited())
                    .forEach(v -> dfs(graph, v));
            return src.getId();
        }
        return src.getId();
    }
}
