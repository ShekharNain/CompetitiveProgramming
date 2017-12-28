package csacademy.r62;



import commons.Graph;
import commons.GraphEdge;
import commons.GraphNode;
import util.FastScanner;

import java.io.PrintWriter;
import java.util.*;
import java.util.function.Consumer;

public class TaskGraph {

    private int timer = 0;
    Consumer<GraphNode> dfsFun = (src) -> {
        if(src.isNotVisited()) {
            src.setVisited(true);
            for (GraphNode child:
                 src.getReachableNodes()) {
                this.dfsFun.accept(child);
            }
        }
    };

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
        //GraphNode[] nodes = new GraphNode[m];
        Graph graph = new Graph(n, m);
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt();
            graph.addEdge(i,x,y);
        }
        List<GraphEdge> bridges = getBridges(graph);
        Graph newGraph = new Graph(n, bridges.size()/2);
        for (GraphEdge e :
                bridges) {
            newGraph.addEdge(e);
        }
        for (int i = 0; i < q; i++) {
            int x = in.nextInt(), y = in.nextInt();
            GraphNode src = newGraph.getNodeById(x);
            GraphNode dest = newGraph.getNodeById(y);
            dfsFun.accept(src);
            if(dest.isVisited())
                out.println("1");
            else out.println("0");
            newGraph.resetVertices();
        }
    }

    private List<GraphEdge> getBridges(Graph graph) {
        List<GraphEdge> result = new ArrayList<>();
        Arrays.stream(graph.getVertices()).forEach(
                (v) -> {
                    if(v.isNotVisited()) {
                        dfs(result, v, null);
                    }
                }
        );
        return result;
    }

    private void dfs(List<GraphEdge> result, GraphNode cur, GraphNode par) {
        if(cur.isNotVisited()) {
            cur.setVisited(true);
            cur.setTimeIn(++timer);
            cur.cmpNSetMinTimeIn(timer);
            cur.getReachableNodes().stream().filter(v -> !v.equals(par))
                .forEach( child -> {
                    if(child.isNotVisited()) {
                        dfs(result, child, cur);
                        //Bridge edge only if subtree min time is greater than parent node entry time
                        if (child.getMinTimeIn() > cur.getTimeIn()) {
                            result.add(new GraphEdge(result.size(), cur.getId(), child.getId()));
                            result.add(new GraphEdge(result.size(), child.getId(), cur.getId()));
                        }
                    }
                    cur.cmpNSetMinTimeIn(child.getMinTimeIn());
                });
        }
    }
}


