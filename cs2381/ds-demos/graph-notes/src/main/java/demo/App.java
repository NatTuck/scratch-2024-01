package demo;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

class MathGraph {
    Set<String> vertices;
    Set<Pair<String, String>> edges;

    Set<String> directPrereqs(String vertex) {
        // O(n)
    }
}

class Vertex {
    String name;
    Set<Vertex> neighbors;

    Set<String> directPrereqs(String vertex) {
        // O(1)

        // Problem: How do we find the right vertex?
        return neighbors;
    }
}

class DirectGraph {
    Map<String, Vertex> vertices;

    // Finding a vertex is O(log n) for TreeSet or 
    // O(1) for a HashSet
    
    Set<String> directPrereqs(String classCode) {
        return vertices.get(classCode).neighbors;
    }
}




