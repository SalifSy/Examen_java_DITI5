package com.groupeisi.service;

import com.groupeisi.entity.User;
import com.groupeisi.repository.UserRpository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRpository userRpository;

    public UserServiceImpl(UserRpository userRpository){
        super();
        this.userRpository = userRpository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRpository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRpository.save(user);
    }

    public User getUserById(Long id){
        return userRpository.findById(id).get();
    }

    public User updateUser(User user){
        return userRpository.save(user);
    }


}
