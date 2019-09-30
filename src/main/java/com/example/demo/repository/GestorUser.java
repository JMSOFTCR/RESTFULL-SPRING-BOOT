package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository("gestorUser")
public interface GestorUser extends JpaRepository<User, Serializable> {

	public abstract User findByUser(String user);
	
	
}
