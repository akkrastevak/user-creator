package com.akk.aacademyfinalproject.service;

import com.akk.aacademyfinalproject.entity.User;

import java.util.Set;

public interface UserService {

    User findById (Long id);

    Set<User> findAll();

    User save(User user);

    User update(User user, Long id);

    void delete (Long id);

    void delete (String userName);

}
