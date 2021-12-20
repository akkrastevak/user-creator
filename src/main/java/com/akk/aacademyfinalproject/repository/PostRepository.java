package com.akk.aacademyfinalproject.repository;

import com.akk.aacademyfinalproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
