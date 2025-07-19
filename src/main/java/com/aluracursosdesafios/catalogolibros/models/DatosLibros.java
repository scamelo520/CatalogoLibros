package com.aluracursosdesafios.catalogolibros.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<autor> autores,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") int numeroDeDescargas
) {
}
