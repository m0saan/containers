package com.moboustt;

public class Main {
    public static void main(String[] args) {
        var graph = new ClassicGraph(10);

        graph.addNode("Alice");
        graph.addNode("Bob");
        graph.addNode("Jho");
        graph.addNode("Erin");

        //----------------------------//

        graph.addEdge("Alice", "Bob");
        graph.addEdge("Jho", "Bob");
        graph.addEdge("Jho", "Erin");

        graph.removeEdge("Alice", "Bob");
        graph.print();
        System.out.println("Done");
    }
}