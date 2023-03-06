package com.doranco.projet.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.doranco.projet.model.ClassRoom;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Long>{

	@Query("FROM ClassRoom s WHERE s.number LIKE %:keyword%")
	public Page<ClassRoom> ClassRoomSearch(@Param("keyword") String kw, Pageable pageable);
	
	public ClassRoom findByNumber(String number);
}
