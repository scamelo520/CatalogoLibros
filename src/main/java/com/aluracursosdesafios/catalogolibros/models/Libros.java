package com.aluracursosdesafios.catalogolibros.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    private String idioma;

    private int numeroDeDescargas;

    public Libros(String titulo, Autor autor, String idioma, int numeroDeDescargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Libros(){
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(int numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    @Override
    public String toString() {
//        String nombreAutor = "Sin Autor";
//        if (autor != null && !autor.isEmpty()) {
            String nombreAutor = autor.getNombre();
//        }

        return  "-----LIBRO-----\n" +
                "Título: " + titulo +"\n"+
                "Autor: " + nombreAutor +"\n"+
                "Idioma: " + idioma +"\n"+
                "Numero de descargas: " + numeroDeDescargas +"\n"+
                "---------------\n";
    }
}
