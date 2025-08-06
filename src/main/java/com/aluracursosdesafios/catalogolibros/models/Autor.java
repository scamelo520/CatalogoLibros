package com.aluracursosdesafios.catalogolibros.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    private String fechaDeNacimiento;

    private String fechaDeFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libros> libros;

    public Autor() {
    }

    public String getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(String fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    public Autor(String nombre, String fechaDeNacimiento) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        String nombreLibro = libros.get(0).getTitulo();

        return "-----AUTOR-----\n" +
                "Autor: " + nombre + "\n" +
                "Fecha de nacimiento: " + fechaDeNacimiento + "\n" +
                "Fecha de fallecimiento: " + fechaDeFallecimiento + "\n" +
                "Libros: " + nombreLibro + "\n"+
                "---------------\n";
    }
}
