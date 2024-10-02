package com.example.biblioteca.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.Entities.BibliotecaEntity;

public interface BibliotecaRepository extends JpaRepository<BibliotecaEntity, Long> {

}
