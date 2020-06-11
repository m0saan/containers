package com.moboustt;

import java.util.ArrayList;
import java.util.HashMap;

public class Tries {
    public static int ALPHABET_SIZE = 26;
    private Node root = new Node(' ');
    private int count = 0;
    private String str = "";

    // insert(word String)
    // O(L) where L => the length of the word we're searching for.
    public void insert(String word) {
        if (word == null) throw new IllegalArgumentException();
        var current = root;
        for (char ch : word.toCharArray()) {
            var index = ch - 'a';
            if (!current.hasChild(ch)) current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    // remove(String word)
    public void remove(String word) {
        if (word == null) return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) return;

        remove(child, word, index + 1);

        if (child.getChildren().length == 0 && !child.isEndOfWord)
            root.removeChild(ch);
    }

    // searching for a word in a Trie data structure.
    // O(L)
    public boolean contains(String word) {
        if (word == null) return false;

        var current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public boolean containsRecursive(String word){
        if (word == null) return false;
        return containsRecursive(root, word, 0);
    }

    public void autoCompletion(String word) {
        if (word == null) return;
        ArrayList<String> list = new ArrayList<>();
        autoCompletion(getLastNodeOf(word), word, list);
        System.out.println(list);
    }

    public int countWords(){
        return countWords(root);
    }

    public String longestCommonPrefix(String[] items){
        if (items.length == 0)
            return "";
        for (var item : items)
            insert(item);
        var shortestItem = getShortestWord(items);
        System.out.println(shortestItem);
        return longestCommonPrefix(root, shortestItem, 0);
    }

    private String longestCommonPrefix(Node root, String word, int index){
        if (root.getChildren().length > 1 || word.length() == index)
            return str;

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null)
            return null;

        str += ch;

        return longestCommonPrefix(child, word, index +1);
    }

    private String getShortestWord(String[] items){
        var shortestItemIndex = items[0];
        for (String item : items)
            if (item.length() < shortestItemIndex.length())
                shortestItemIndex = item;
        return shortestItemIndex;
    }

    private int countWords(Node root){
        for (var child : root.getChildren()){
            countWords(child);
            if (child.isEndOfWord)
                count += 1;
        }
        return count;
    }

    private boolean containsRecursive(Node root, String word, int index){
        if (root == null) return false;

        if (index == word.length())
            return root.isEndOfWord;

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) return false;

        return containsRecursive(child, word, index + 1);
    }

    private void autoCompletion(Node root, String word, ArrayList<String> list) {
        if (root == null)
            return;

        if (root.isEndOfWord)
            list.add(word);

        for (var child : root.getChildren())
            autoCompletion(child, word + child.value, list);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public Node getLastNodeOf(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null) return null;
            current = child;
        }
        return current;
    }


    private void traversePostOrder(Node root) {
        for (var child : root.getChildren())
            traversePostOrder(child);

        System.out.println(root.value);
    }

    private void traversePreOrder(Node root) {
        System.out.println(root.value);

        for (var child : root.getChildren())
            traversePreOrder(child);
    }

    private static class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }
}
