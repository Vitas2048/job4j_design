package ru.job4j.gc.leak;

import java.util.*;

public class PostStore {

    private static Map<Integer, Post> posts = new HashMap<>();

    private int i = 1;

    public Post add(Post post) {
        int id = i++;
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    public void removeAll() {
        posts.clear();
    }

    public static Collection<Post> getPosts() {
        return posts.values();
    }
}