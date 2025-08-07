package com.aluracursosdesafios.catalogolibros.repository;

import com.aluracursosdesafios.catalogolibros.models.Autor;
import com.aluracursosdesafios.catalogolibros.models.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILibroRepository extends JpaRepository<Libros, Long> {

    @Query("SELECT l FROM Libros l WHERE l.idioma = :idiomaEscogido")
    List<Libros> librosPorIdioma(String idiomaEscogido);

    List<Libros> findTop10ByOrderByNumeroDeDescargasDesc();
}
