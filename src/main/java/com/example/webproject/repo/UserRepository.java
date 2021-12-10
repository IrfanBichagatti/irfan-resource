package com.example.webproject.repo;

import com.example.webproject.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
public Iterable<UserModel> deleteByUsername(String username);
public UserModel findByUsername(String username);
}
