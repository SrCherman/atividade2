package com.example.bibliotecaabc.repository;

import com.example.bibliotecaabc.entity.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
