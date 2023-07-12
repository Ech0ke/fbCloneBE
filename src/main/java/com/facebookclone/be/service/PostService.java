package com.facebookclone.be.service;

import com.facebookclone.be.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getAllPosts();
}
