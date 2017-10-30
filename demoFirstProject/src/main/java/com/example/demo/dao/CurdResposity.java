package com.example.demo.dao;

import com.example.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurdResposity extends JpaRepository<Person, Integer>{
    public List<Person> findByName(String name);
}
