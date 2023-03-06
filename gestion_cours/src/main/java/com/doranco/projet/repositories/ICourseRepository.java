package com.doranco.projet.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.doranco.projet.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Long>{

	@Query("FROM Course s WHERE s.title LIKE %:keyword% OR s.duration LIKE %:keyword% OR s.description LIKE %:keyword% OR s.classRoom.number LIKE %:keyword% OR s.instructor.firstName LIKE %:keyword%")
	public Page<Course> CourseSearch(@Param("keyword") String kw, Pageable pageable);
	
}
