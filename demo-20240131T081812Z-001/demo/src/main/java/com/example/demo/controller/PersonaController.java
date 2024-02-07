package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    PersonaRepository personaRepository;

    
    @PostMapping()
    public Persona insert(@RequestBody Persona p){
        return personaRepository.save(p);
    }


    @GetMapping("/list")
    public List<Persona> list(@RequestParam(name = "nome", required = false) String name){
        if(name != null && name.trim().length() > 0){
            return personaRepository.findByNome(name);
        }else{
            return personaRepository.findAll();
        }
    }


    @GetMapping("/{id}")
    public Persona readOne(@PathVariable("id") long id){
        return personaRepository.findById(id).get();
    }


    @GetMapping("/nome")
    public String name(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello", name);
    }


    @PutMapping("/{id}")
    public Persona update(@PathVariable("id") Long id, @RequestBody Persona p){
        p.setId(id);
        return personaRepository.save(p);
    }


    @DeleteMapping
    public void delete(@RequestBody Persona p){
        personaRepository.delete(p);
    }


    @DeleteMapping("/delete/{id}")
    public Long deleteById(@PathVariable("id") long id){
        personaRepository.deleteById(id);
        return id;
    }


    @DeleteMapping("/delete")
    public void deleteAll(){
        personaRepository.deleteAll();
    }
}
