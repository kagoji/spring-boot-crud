package com.kagoji.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kagoji.crud.model.Biodata;

@Repository
public interface BiodataRepo extends JpaRepository<Biodata, Integer>{
}
