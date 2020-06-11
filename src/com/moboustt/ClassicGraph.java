package com.moboustt;

import java.util.*;
import java.util.LinkedList;

public class ClassicGraph {
    private static class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }
    }
    private LinkedList<Node>[] nodes;
    private Map<String, Node> map = new HashMap<>();
    private Map<String, Integer> indexes = new HashMap<>();
    private int count;

    public ClassicGraph(int capacity){
        nodes = new LinkedList[capacity];
    }

    // addNode(String label) -> void
    public void addNode(String label){
        if (label == null) throw new IllegalStateException();
        var node = new Node(label);
        map.putIfAbsent(label, node);
        indexes.putIfAbsent(label, count);
        nodes[count++] = new LinkedList<>();
    }

    // removeNode()
    public void removeNode(String label){
        if (map.get(label) == null) return;
        int index = 0;
        while (index < count){
            var slot = nodes[index];
            if (!slot.isEmpty()) slot.remove(map.get(label));
            index++;
        }
        map.remove(label);
        indexes.remove(label);
    }

    // addEdge(Str from, Str to)
    public void addEdge(String from, String to){
        Node toNode = getAndValidateNode(from, to);
        var nodeIndex = indexes.get(from);
        nodes[nodeIndex].addLast(toNode);
    }

    private Node getAndValidateNode(String from, String to) {
        var fromNode = map.get(from);
        var toNode = map.get(to);
        if (fromNode == null || toNode == null) throw new IllegalStateException();
        return toNode;
    }

    // removeEdge(Str from, Str to)
    public void removeEdge(String from, String to){
        var toNode = getAndValidateNode(from, to);
        var nodeIndex = indexes.get(from);
        nodes[nodeIndex].remove(toNode);
    }

    // print()
    public void print() {
        List<String> list = new ArrayList<>();
        for (var key : indexes.keySet()){
            for (var item :nodes[indexes.get(key)])
                list.add(item.label);
            System.out.println(key + " is connected to " + list.toString());
            list.clear();
        }
    }
}
