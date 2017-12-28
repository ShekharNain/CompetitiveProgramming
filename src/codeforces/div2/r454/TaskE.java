package codeforces.div2.r454;

import commons.*;
import util.FastScanner;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskE {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        Graph graph = new Graph(n, m);
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt();
            graph.addEdge(i, x, y);
        }
        List<Integer> ans = new ArrayList<>();
        while (m != n*(n-1)/2) {
            int mx = -1, id = 0;
            Optional<Pair<Integer, List<GraphEdge>>> max = IntStream.rangeClosed(1, n)
                    .boxed()
                    .map(i -> new Pair<Integer, List<GraphEdge>>(i, getMissingConnections(graph, i)))
                    .max(Comparator.comparing(p -> p.getSecond().size()));
            if(max.isPresent()) {
                max.get().getSecond().forEach(e -> graph.addEdge(e));
                m += max.get().getSecond().size()/2;
                ans.add(max.get().getFirst());
            }
        }
        out.println(ans.size());
        ans.forEach(val -> out.println(val));
    }

    private List<GraphEdge> getMissingConnections(Graph graph, Integer id) {
        GraphNode cur = graph.getNodeById(id);
        Set<GraphEdge> edges = graph.getEdges();
        return cur.getReachableNodes().stream()
                .flatMap(v -> cur.getReachableNodes().stream().map(x -> new GraphEdge(v.getId()+x.getId(), v.getId(),x.getId())))
                .filter(e -> e.getSrcNode() != e.getDestNode() && !edges.contains(e))
                .collect(Collectors.toList());
    }
}
