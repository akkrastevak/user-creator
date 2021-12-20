package com.akk.aacademyfinalproject.service;

import com.akk.aacademyfinalproject.entity.Post;
import com.akk.aacademyfinalproject.entity.User;

public interface PostService {

    Post findPostById (Long id);

    Post save(Post post);

    Post update(Post post, Long id);

    void delete (Post post);
}
