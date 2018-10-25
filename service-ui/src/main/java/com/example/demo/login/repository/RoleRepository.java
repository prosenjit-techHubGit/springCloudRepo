package com.example.demo.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.login.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);

}
