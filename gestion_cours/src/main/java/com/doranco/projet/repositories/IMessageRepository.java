package com.doranco.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.projet.model.Message;

public interface IMessageRepository extends JpaRepository<Message, Long>{

}
