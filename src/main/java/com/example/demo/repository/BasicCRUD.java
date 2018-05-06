package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Name;

@Repository
public interface BasicCRUD extends JpaRepository<Name, Integer>{

}
