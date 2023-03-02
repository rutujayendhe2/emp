package com.webapp.dao;

import com.webapp.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users, Long> {

}
