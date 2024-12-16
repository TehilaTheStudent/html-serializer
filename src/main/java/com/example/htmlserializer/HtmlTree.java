package com.example.htmlserializer;

import java.util.List;

public class HtmlTree {
    private TreeNode<HtmlTag> root;

    public HtmlTree(HtmlTag root) {
        this.root = new TreeNode<HtmlTag>(root);
    }

    public HtmlTree(List<HtmlTag> tags) {
        // skip <!doctype html>
        int i = 0;
        if (tags.get(0).getName().equals("!doctype")) {
            root = new TreeNode<HtmlTag>(tags.get(1));
            i = 2;
        } else {
            root = new TreeNode<HtmlTag>(tags.get(0));
            i = 1;
        }
        TreeNode<HtmlTag> currentParent = root;
        for (; i < tags.size(); i++) {
            if (tags.get(i).getType() == HtmlTag.HtmlTagType.CLOSING && currentParent.getParent() != null) {
                currentParent = currentParent.getParent();
                continue;
                // im closing current parent, continue with uncle's children
            }
            TreeNode<HtmlTag> currentNode = new TreeNode<>(tags.get(i));
            currentParent.addChild(currentNode);

            if (tags.get(i).getType() == HtmlTag.HtmlTagType.SELF_CLOSING) {
                continue;
                // next is brother, because it's a self-closing tag

            } else if (tags.get(i).isVoid()) {
                continue;
                // next is brother, because it's a void tag
            } else {
                currentParent = currentNode;
                // next is my child
            }

        }

    }

}
