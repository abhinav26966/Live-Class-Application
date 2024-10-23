package com.abhinav.liveclassapp.liveclass.service;

import com.abhinav.liveclassapp.liveclass.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class UserService {
    private Map<Long, User> users = new HashMap<>();
    public User createUser(Long id, String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        users.put(id, user);
        return user;
    }
    public User getUser(Long id){
        return users.get(id);
    }
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
