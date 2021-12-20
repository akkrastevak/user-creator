package com.akk.aacademyfinalproject.converter;

import com.akk.aacademyfinalproject.dto.PostDto;
import com.akk.aacademyfinalproject.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public PostDto toPostDto(Post post){
        return PostDto.builder()
                .comment(post.getComment())
                .build();
    }

    public Post toPost(PostDto postDto){
        return Post.builder()
                .comment(postDto.getComment())
                .build();
    }
}
