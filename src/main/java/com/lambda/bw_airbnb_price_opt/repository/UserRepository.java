package com.lambda.bw_airbnb_price_opt.repository;

import com.lambda.bw_airbnb_price_opt.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
