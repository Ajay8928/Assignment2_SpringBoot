package com.operations.productapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.operations.productapp.entities.User;

public interface UserRepository extends CrudRepository<User,Integer> 
{

}