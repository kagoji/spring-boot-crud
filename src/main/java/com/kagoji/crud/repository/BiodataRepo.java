package com.kagoji.crud.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kagoji.crud.model.Biodata;

@Repository
public interface BiodataRepo extends JpaRepository<Biodata, Integer>{

	ArrayList<Biodata> findByAge(int age);
	
	@Query("from Biodata where name like %?1%")
	ArrayList<Biodata> findName(String name);
}
