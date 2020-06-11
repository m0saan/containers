package com.moboustt;

import java.util.*;

public class Graph {

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();
    private Set<Node> set = new HashSet<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label) {
        Node node = getNode(label);
        if (node == null) return;

        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void depthFirstTraversalIterative(String label){
        Node node = getNode(label);
        if (node == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            var current = stack.pop();

            System.out.println(current.label);
            for (var neighbor : adjacencyList.get(current))
                if (isVisited(current)) stack.push(neighbor);
        }
    }

    public void depthFirstTraversal(String label){
        Node node = getNode(label);
        if (node == null) return;
        depthFirstTraversal(node);
    }

    public void breadthFirstTraverse(String label){
        Node node = getNode(label);
        if (node == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        breadthFirstTraverse(node, queue);
    }

    private void breadthFirstTraverse(Node node, Queue<Node> queue){
        while (!queue.isEmpty())
            System.out.println(queue.poll().label);

        for (var neighbor : adjacencyList.get(node))
            if (isVisited(neighbor)){
                queue.add(neighbor);
                breadthFirstTraverse(neighbor, queue);
            }
    }

    private void depthFirstTraversal(Node node){
        System.out.println(node.label);

        for (var neighbor : adjacencyList.get(node))
            if (isVisited(neighbor)) depthFirstTraversal(neighbor);
    }

    private Node getNode(String label) {
        return nodes.get(label);
    }

    private boolean isVisited(Node node){
        if (set.contains(node))
            return false;
        set.add(node);
        return true;
    }

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}