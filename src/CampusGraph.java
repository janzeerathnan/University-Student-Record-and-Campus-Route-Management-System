/** Undirected campus graph implemented as an adjacency list, with BFS traversal. */
public class CampusGraph {
    private Location locations;
    private static class Location { String name; Edge edges; Location next; Location(String name) { this.name = name; } }
    private static class Edge { Location destination; Edge next; Edge(Location destination) { this.destination = destination; } }

    public boolean addLocation(String name) {
        if (find(name) != null) return false;
        Location location = new Location(name); location.next = locations; locations = location; return true;
    }
    public boolean removeLocation(String name) {
        Location previous = null, current = locations;
        while (current != null && !current.name.equalsIgnoreCase(name)) { previous = current; current = current.next; }
        if (current == null) return false;
        for (Location location = locations; location != null; location = location.next) removeEdge(location, current);
        if (previous == null) locations = current.next; else previous.next = current.next;
        return true;
    }
    public boolean addConnection(String firstName, String secondName) {
        Location first = find(firstName), second = find(secondName);
        if (first == null || second == null || first == second || hasEdge(first, second)) return false;
        addEdge(first, second); addEdge(second, first); return true;
    }
    public boolean removeConnection(String firstName, String secondName) {
        Location first = find(firstName), second = find(secondName);
        if (first == null || second == null || !hasEdge(first, second)) return false;
        removeEdge(first, second); removeEdge(second, first); return true;
    }
    public void display() {
        if (locations == null) { System.out.println("No campus locations available."); return; }
        System.out.println("\n--- Campus Network (Adjacency List) ---");
        for (Location location = locations; location != null; location = location.next) {
            System.out.print(location.name + " -> ");
            if (location.edges == null) System.out.print("No direct connections");
            for (Edge edge = location.edges; edge != null; edge = edge.next) { System.out.print(edge.destination.name); if (edge.next != null) System.out.print(", "); }
            System.out.println();
        }
    }
    public String bfs(String startName) {
        Location start = find(startName);
        if (start == null) return null;
        Location[] queue = new Location[count()], visited = new Location[count()];
        int front = 0, rear = 0, visitedCount = 0;
        queue[rear++] = start; visited[visitedCount++] = start;
        StringBuilder output = new StringBuilder();
        while (front < rear) {
            Location current = queue[front++];
            if (output.length() > 0) output.append(" -> ");
            output.append(current.name);
            for (Edge edge = current.edges; edge != null; edge = edge.next) if (!contains(visited, visitedCount, edge.destination)) { visited[visitedCount++] = edge.destination; queue[rear++] = edge.destination; }
        }
        return output.toString();
    }
    private Location find(String name) { for (Location location = locations; location != null; location = location.next) if (location.name.equalsIgnoreCase(name)) return location; return null; }
    private int count() { int count = 0; for (Location location = locations; location != null; location = location.next) count++; return count; }
    private boolean contains(Location[] list, int size, Location target) { for (int i = 0; i < size; i++) if (list[i] == target) return true; return false; }
    private boolean hasEdge(Location from, Location to) { for (Edge edge = from.edges; edge != null; edge = edge.next) if (edge.destination == to) return true; return false; }
    private void addEdge(Location from, Location to) { Edge edge = new Edge(to); edge.next = from.edges; from.edges = edge; }
    private void removeEdge(Location from, Location to) { Edge previous = null, current = from.edges; while (current != null) { if (current.destination == to) { if (previous == null) from.edges = current.next; else previous.next = current.next; return; } previous = current; current = current.next; } }
}
