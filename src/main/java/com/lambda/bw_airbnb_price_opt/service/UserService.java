package com.lambda.bw_airbnb_price_opt.service;

import com.lambda.bw_airbnb_price_opt.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserByName(String name);

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);
}