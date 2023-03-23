package com.groupeisi.service;

import com.groupeisi.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

   User updateUser(User user);



}
