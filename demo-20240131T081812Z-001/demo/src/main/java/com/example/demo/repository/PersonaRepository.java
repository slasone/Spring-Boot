package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    public List<Persona> findByNome(String nome);
    
    
}