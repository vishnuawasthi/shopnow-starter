package com.shopnow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopnow.entity.User;
public interface LoginJpaRepository extends    JpaRepository<User,Long>  {

}
