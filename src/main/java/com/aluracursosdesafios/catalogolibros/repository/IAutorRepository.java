package com.aluracursosdesafios.catalogolibros.repository;

import com.aluracursosdesafios.catalogolibros.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento >= :fechaInicio AND a.fechaDeFallecimiento <= :fechaFinalizacion")
    List<Autor> autoresVivosPorRangoFecha(int fechaInicio, int fechaFinalizacion);
}
