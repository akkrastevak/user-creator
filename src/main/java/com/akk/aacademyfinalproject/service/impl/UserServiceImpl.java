package com.akk.aacademyfinalproject.service.impl;

import com.akk.aacademyfinalproject.entity.User;
import com.akk.aacademyfinalproject.exeption.DublicateUserCreationExeption;
import com.akk.aacademyfinalproject.exeption.UserNotFoundExeption;
import com.akk.aacademyfinalproject.repository.UserRepository;
import com.akk.aacademyfinalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundExeption(String.format("User with %d can't be found", id)));
    }

    @Override
    public Set<User> findAll() {
        return new TreeSet<>(Comparator.comparing(User::getId));
    }

    @Override
    public User save(User user) {
        try {
            userRepository.save(user);
        }catch (DataIntegrityViolationException exception) {
            throw new DublicateUserCreationExeption(String.format("User with that name already exists", user));
        }
        return userRepository.save(user);
    }

    @Override
    public User update(User user, Long id) {
        User foundUser = this.findById(id);
        User updatedUser = User.builder().id(foundUser.getId()).
                firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        return userRepository.save(updatedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(String userName) {
        userRepository.findByUserName(userName).
                orElseThrow(() -> new UserNotFoundExeption(String.format("Wrong %s, try with different %s", userName)));
    }

}
