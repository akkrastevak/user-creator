package com.akk.aacademyfinalproject.service.impl;

import com.akk.aacademyfinalproject.entity.Post;
import com.akk.aacademyfinalproject.exeption.DublicateUserCreationExeption;
import com.akk.aacademyfinalproject.exeption.PostWithBadIdExeption;
import com.akk.aacademyfinalproject.repository.PostRepository;
import com.akk.aacademyfinalproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostWithBadIdExeption(String.format("Comment with that %d can't be found", id)));
    }

    @Override
    public Post save(Post post) {
        try {
            postRepository.save(post);
        }catch (DataIntegrityViolationException exception) {
            throw new PostWithBadIdExeption(String.format("That post already exist", post));
        }
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post, Long id) {
        Post foundPost = this.findPostById(id);
        Post updatedPost = Post.builder()
                .id(foundPost.getId())
                .comment(foundPost.getComment()).build();
        return postRepository.save(updatedPost);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
