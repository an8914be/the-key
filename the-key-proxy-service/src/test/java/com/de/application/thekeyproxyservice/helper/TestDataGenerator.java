package com.de.application.thekeyproxyservice.helper;

import com.de.application.thekeyproxyservice.common.util.datatypes.Blogpost;
import com.de.application.thekeyproxyservice.common.util.datatypes.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Test-Data-Generator for the Tests
 */
public class TestDataGenerator {
    private TestDataGenerator() {
    }

    public static Blogpost createBlogPost() {
        return new Blogpost();
    }

    public static Blogpost createBlogPostWithoutRenderer() {
        Blogpost blogPost = new Blogpost();
        blogPost.setContent(new Content());
        return blogPost;
    }

    public static Blogpost createBlogPostWithContent() {
        Blogpost blogPost = new Blogpost();
        blogPost.setContent(new Content());

        blogPost.getContent().setRendered("This is content");
        return blogPost;
    }

    public static Blogpost createBlogPostWithHTMLTags() {
        Blogpost blogPost = new Blogpost();
        blogPost.setContent(new Content());

        blogPost.getContent().setRendered("<div>This is content<//div>");
        return blogPost;
    }

    public static ArrayList<Blogpost> createListOfBlogPosts() {
        ArrayList<Blogpost> blogPosts = new ArrayList<>();
        blogPosts.add(createBlogPost());
        blogPosts.add(createBlogPost());
        blogPosts.add(createBlogPost());
        return blogPosts;
    }

    public static ArrayList<Blogpost> createListOfBlogPostsWithoutRenderer() {
        ArrayList<Blogpost> blogPosts = new ArrayList<>();
        blogPosts.add(createBlogPostWithoutRenderer());
        blogPosts.add(createBlogPostWithoutRenderer());
        blogPosts.add(createBlogPostWithoutRenderer());
        return blogPosts;
    }

    public static ArrayList<Blogpost> createListOfBlogPostsWithContent() {
        ArrayList<Blogpost> blogPosts = new ArrayList<>();
        blogPosts.add(createBlogPostWithContent());
        blogPosts.add(createBlogPostWithContent());
        blogPosts.add(createBlogPostWithContent());
        return blogPosts;
    }

    public static ArrayList<Blogpost> createListOfBlogPostsWithHTMLTags() {
        ArrayList<Blogpost> blogPosts = new ArrayList<>();
        blogPosts.add(createBlogPostWithHTMLTags());
        blogPosts.add(createBlogPostWithHTMLTags());
        blogPosts.add(createBlogPostWithHTMLTags());
        return blogPosts;
    }

    public static String createReadyStringToCompare() {
        return "This is content This is content This is content ";
    }

    public static String createReadyStringToCompareWithWhitespaces() {
        return " This is content   This is content   This is content  ";
    }

    public static String createEmptyString() {
        return "";
    }

    public static Map<String, Integer> createWordCountMap() {
        Map<String, Integer> wordMap = new HashMap<>();
        wordMap.put("Hello", 2);
        wordMap.put("World", 3);
        return wordMap;
    }
}