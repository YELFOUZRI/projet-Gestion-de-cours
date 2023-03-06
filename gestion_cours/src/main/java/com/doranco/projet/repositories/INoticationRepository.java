package com.doranco.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.projet.model.Notification;

public interface INoticationRepository extends JpaRepository<Notification, Long>{

}
