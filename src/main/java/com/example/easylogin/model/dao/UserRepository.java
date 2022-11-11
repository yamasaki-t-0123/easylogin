package com.example.easylogin.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easylogin.model.entity.user;


@Repository
public interface UserRepository extends JpaRepository<user, Long> {

  List<user> findByUserNameAndPassword(String userName, String password);
}
