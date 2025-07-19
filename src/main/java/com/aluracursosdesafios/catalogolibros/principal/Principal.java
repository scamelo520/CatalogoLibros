package com.aluracursosdesafios.catalogolibros.principal;

import com.aluracursosdesafios.catalogolibros.models.Datos;
import com.aluracursosdesafios.catalogolibros.models.DatosLibros;
import com.aluracursosdesafios.catalogolibros.service.ConsumoApi;
import com.aluracursosdesafios.catalogolibros.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";

    private ConsumoApi consumoApi = new ConsumoApi();

    private ConvierteDatos conversor = new ConvierteDatos();

    private Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {
        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datosLibros = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datosLibros);

        //Top 10 libros mas descargados
        System.out.println("\nTop 10 libros mas descargados");
        datosLibros.listaLibros().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
                .limit(10)
                .map(l->l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de Libros por titulo
        System.out.println("\nIngrese el nombre del titulo que desea buscar");
        var busqueda = teclado.nextLine();

        json = consumoApi.obtenerDatos(URL_BASE+"?search="+busqueda.replace(" ","+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

        Optional<DatosLibros> libroBuscado = datosLibros.listaLibros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(busqueda.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()){
            System.out.println("\nLibro encontrado");
            System.out.println("Los datos del libro son: "+libroBuscado.get());
        }else {
            System.out.println("Libro no encontrado");
        }

        //Estadisticas
        System.out.println("\nEstadisticas");
        IntSummaryStatistics est = datosLibros.listaLibros().stream()
                .filter(l->l.numeroDeDescargas()>0)
                .collect(Collectors.summarizingInt(DatosLibros::numeroDeDescargas));
        System.out.println("Numero mayor de descargas por libro: " +est.getMax());
        System.out.println("Numero menor de descargas por libro: " +est.getMin());
        System.out.println("Total de registros analizados: " +est.getCount());
    }
}
