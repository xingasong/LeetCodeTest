import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if(n == 0) return false;
        if(edges.length != n-1) return false;
        Map<Integer, Set<Integer>> graph = initialGraph(n, edges);
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for(int neighbor : graph.get(vertex)) {
                if(!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return (set.size() == n);

    }

    private Map<Integer, Set<Integer>> initialGraph(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return graph;
    }
}
