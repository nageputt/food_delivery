package com.delivery.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.demo.entity.UserAccount;

public interface UserRespository extends JpaRepository<UserAccount, String>{

}
