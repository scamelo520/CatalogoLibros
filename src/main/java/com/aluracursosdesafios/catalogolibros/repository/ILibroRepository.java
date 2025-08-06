package com.aluracursosdesafios.catalogolibros.repository;

import com.aluracursosdesafios.catalogolibros.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibroRepository extends JpaRepository<Libros, Long> {
}
