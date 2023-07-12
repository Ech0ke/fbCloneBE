package com.facebookclone.be.service;

import com.facebookclone.be.entity.PostEntity;
import com.facebookclone.be.model.Post;
import com.facebookclone.be.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post addPost(Post post) throws Exception {
        try {
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post, postEntity);

            if(post.getFile() != null || post.getFile().equalsIgnoreCase("null")) {
                postEntity.setImage(null);

            } else {
                postEntity.setImage(post.getFile());
            }

            PostEntity savedPost = postRepository.save(postEntity);

            post.setId(savedPost.getId());
            post.setFile(null);
            post.setFile(postEntity.getImage());
        } catch (Exception e) {
            throw new Exception("Could not save Post: " + e);
        }
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        List<PostEntity> postEntities = postRepository.findAll();

        List<Post> posts = new ArrayList<>();
        posts = postEntities
                .stream()
                .map(postEntity -> Post.builder()
                        .id(postEntity.getId())
                        .timeStamp(postEntity.getTimeStamp())
                        .email(postEntity.getEmail())
                        .name(postEntity.getName())
                        .post(postEntity.getPost())
                        .image(postEntity.getImage())
                        .profilePic(postEntity.getProfilePic())
                        .build())
                .collect(Collectors.toList());
        return posts;
    }
}
