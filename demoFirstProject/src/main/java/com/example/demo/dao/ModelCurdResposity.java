package com.example.demo.dao;

import com.example.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelCurdResposity extends JpaRepository<Person, Integer>{
    // 根据name字段查
    public List<Person> findByName(String name);
    // 根据address字段查
    public List<Person> findByAddress(String address);
}
