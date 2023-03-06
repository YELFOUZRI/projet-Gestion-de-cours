package com.doranco.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.projet.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
