package com.moboustt;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph {
    private static class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }
    }
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    // addNode(label)
    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }
    // addEdge(from, to)
    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalStateException();
        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalStateException();

        adjacencyList.get(fromNode).add(toNode);
    }
    // removeNode(label)
    // removeEdge(from, to)
    // print
    public void print(){
        var index = 0;
        for (var kv : adjacencyList.entrySet()) {
            for (var value : kv.getValue())
            System.out.println(kv.getKey().label + " is connected to " + value.label);
        }
    }
}
