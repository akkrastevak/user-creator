package com.akk.aacademyfinalproject.repository;

import com.akk.aacademyfinalproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    void deleteByUserName(String userName);
}
