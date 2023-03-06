package com.doranco.projet.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.doranco.projet.model.Instructor;


public interface IInstructorRepository extends JpaRepository<Instructor, Long>{

	@Query("FROM Instructor s WHERE s.lastName LIKE :keyword")
	public Page<Instructor> InstructorSearch(@Param("keyword") String kw, Pageable pageable);
	
}
