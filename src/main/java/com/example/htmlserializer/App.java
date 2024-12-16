package com.example.htmlserializer;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        HtmlLoader loader = new HtmlLoader();
        String html = loader.load("https://github.com").exceptionally(e -> {
            System.err.println("Error: " + e.getMessage());
            return null;
        }).join(); // Block until the HTML content is fetched

        // System.out.println("HTML Content: " + html);
        HtmlParser parser = new HtmlParser();
        List<HtmlTag> tags = parser.parseTags(html);
        for (HtmlTag tag : tags) {
            System.out.println(tag);
        }
        HtmlTree tree = new HtmlTree(tags);
    }
}
