package com.doranco.projet.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.doranco.projet.model.Establishment;

public interface IEstablishmentRepository extends JpaRepository<Establishment, Long>{

	@Query("FROM Establishment s WHERE s.name LIKE :keyword")
	public Page<Establishment> EstablishmentSearch(@Param("keyword") String kw, Pageable pageable);

}
