package com.server.impala.repository;

import org.springframework.data.repository.CrudRepository;
import com.server.impala.entity.User;


public interface UserRepository extends CrudRepository<User, Integer> {

}