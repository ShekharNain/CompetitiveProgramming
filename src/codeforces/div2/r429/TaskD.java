package codeforces.div2.r429;

import commons.Graph;
import commons.GraphEdge;
import commons.GraphNode;
import util.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        Graph graph = new Graph(n, m);
        for (int i = 1; i <= n; i++) {
            graph.getNodeById(i).setValue(in.nextInt());
        }
        List<Integer> ans = new ArrayList<>();
        List<GraphEdge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt();
            graph.addEdge(i,x,y);
        }
        int sum1 = (int) Arrays.stream(graph.getVertices()).map(GraphNode::getValue).filter(i -> i == 1).count();
        if((sum1&1) == 1) {
            
        } else {
            for (GraphNode graphNode : graph.getVertices()) {

            }
        }
    }
}
