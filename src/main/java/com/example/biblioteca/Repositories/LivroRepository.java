package com.example.biblioteca.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.Entities.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

}
