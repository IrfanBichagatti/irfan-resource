package com.example.webproject.services;

import com.example.webproject.model.UserModel;
import com.example.webproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public UserService(){

    }
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public void saveMyUser(UserModel userModel){
        repo.save(userModel);
    }
    public Iterable<UserModel> showAllUsers(){
        return repo.findAll();
    }
    public Iterable<UserModel> deleteUserByUsername(String username){
        repo.deleteByUsername(username);
        return repo.findAll();
    }
    public UserModel findByUsername(String username){
        return repo.findByUsername(username);

    }
}
