package com.moboustt;

public class Main {
    public static void main(String[] args) {
        var graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        //----------------------------//

        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");

        graph.breadthFirstTraverse("A");
    }
}