package com.example.register.service;

import com.example.register.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User>  findAll(Pageable pageable);
    void add(User user);
}
