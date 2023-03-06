package com.doranco.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.projet.model.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long>{

}
