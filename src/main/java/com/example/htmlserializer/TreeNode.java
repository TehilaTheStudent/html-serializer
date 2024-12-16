package com.example.htmlserializer;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    // Relationships
    private T val;
    private TreeNode<T> parent; // Reference to the parent element
    private List<TreeNode<T>> children; // List of child elements

    // Constructor
    public TreeNode(T val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    // Method to add a child
    public void addChild(TreeNode<T> child) {
        child.parent = this;
        this.children.add(child);
    }

 

    // Getter for val
    public T getVal() {
        return val;
    }

    // Getter for parent
    public TreeNode<T> getParent() {
        return parent;
    }

    // Getter for children
    public List<TreeNode<T>> getChildren() {
        return children;
    }

}
