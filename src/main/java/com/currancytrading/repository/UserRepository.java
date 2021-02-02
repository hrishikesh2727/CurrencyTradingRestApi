package com.currancytrading.repository;

import com.currancytrading.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}