class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        // Build a graph
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> t : tickets) {
            String s = t.get(0);
            String e = t.get(1);
            graph.computeIfAbsent(s, k -> new ArrayList<>()).add(e);
        }
        
        for (List<String> v : graph.values()) {
            Collections.sort(v);
        }
        
        dfs("JFK", graph, res);
        Collections.reverse(res);
        return res;
    }
    
    private void dfs(String airport, Map<String, List<String>> graph, List<String> res) {
        // Post-order DFS
        List<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.remove(0);
            dfs(nextAirport, graph, res);
        }
        res.add(airport);
    }

}