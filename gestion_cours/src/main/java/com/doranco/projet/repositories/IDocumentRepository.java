package com.doranco.projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.projet.model.Document;

public interface IDocumentRepository extends JpaRepository<Document, Long>{ 

}
