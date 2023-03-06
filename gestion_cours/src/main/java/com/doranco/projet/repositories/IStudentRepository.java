package com.doranco.projet.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.doranco.projet.model.Student;


public interface IStudentRepository extends JpaRepository<Student, Long>{

	@Query("FROM Student s WHERE s.firstName LIKE %:keyword% OR s.lastName LIKE %:keyword% OR s.grade LIKE %:keyword% OR s.city LIKE %:keyword% OR s.establishment.name LIKE %:keyword%")
	public Page<Student> StudentSearch(@Param("keyword") String kw, Pageable pageable);

}
 