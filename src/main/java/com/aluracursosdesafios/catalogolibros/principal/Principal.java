package com.aluracursosdesafios.catalogolibros.principal;

import com.aluracursosdesafios.catalogolibros.models.*;
import com.aluracursosdesafios.catalogolibros.repository.IAutorRepository;
import com.aluracursosdesafios.catalogolibros.repository.ILibroRepository;
import com.aluracursosdesafios.catalogolibros.service.ConsumoApi;
import com.aluracursosdesafios.catalogolibros.service.ConvierteDatos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";

    private ConsumoApi consumoApi = new ConsumoApi();

    private ConvierteDatos conversor = new ConvierteDatos();

    private Scanner teclado = new Scanner(System.in);

    private List<Libros> libros;

    @Autowired
    private ILibroRepository libroRepository;

    @Autowired
    private IAutorRepository autorRepository;

    public void mostrarMenu() {
        var json = consumoApi.obtenerDatos(URL_BASE);
        var datosLibros = conversor.obtenerDatos(json, Datos.class);

        var opcion = -1;
        while (opcion != 0){
            var menu = """
                    ---------------
                    Elija una opción del menú:
                    1 - Buscar libro por titulo
                    2 - Lista de libros registrados
                    3 - Lista de autores registrados
                    4 - Lista de autores vivos en un determinado año
                    5 - Lista de libros por idioma
                    6 - Top 10 de libros más descargados
                    0 - Salir
                    
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    libroPorTitulo();
                    break;
                case 2:
                    librosRegistrados();
                    break;
                case 3:
                    autoresRegistrados();
                    break;
                case 4:
                    autoresVivosPorRangoFecha();
                    break;
            }

        }



//        //Top 10 libros mas descargados
//        System.out.println("\nTop 10 libros mas descargados");
//        datosLibros.listaLibros().stream()
//                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
//                .limit(10)
//                .map(l->l.titulo().toUpperCase())
//                .forEach(System.out::println);
//
//        //Estadisticas
//        System.out.println("\nEstadisticas");
//        IntSummaryStatistics est = datosLibros.listaLibros().stream()
//                .filter(l->l.numeroDeDescargas()>0)
//                .collect(Collectors.summarizingInt(DatosLibros::numeroDeDescargas));
//        System.out.println("Numero mayor de descargas por libro: " +est.getMax());
//        System.out.println("Numero menor de descargas por libro: " +est.getMin());
//        System.out.println("Total de registros analizados: " +est.getCount());
    }

    private void autoresVivosPorRangoFecha() {
        System.out.println("Por favor ingrese un año de inicio");
        var fechaInicio = teclado.nextInt();
        System.out.println("Por favor ingrese un año de finalización");
        var fechaFinalizacion = teclado.nextInt();

        //Se encarga de traer la busqueda con Native Query de IAutorRepository y se guarda en una lista
        List<Autor> autorVivo = autorRepository.autoresVivosPorRangoFecha(fechaInicio, fechaFinalizacion);

        System.out.println("-----AUTORES VIVOS-----");
        System.out.println("-------"+fechaInicio+"-"+fechaFinalizacion+"-------\n");
        autorVivo.forEach(System.out::println);
    }

    private Autor autoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();

        if(!autores.isEmpty()){
            System.out.println("-----LISTA AUTORES-----\n");
            autores.forEach(System.out::println);
        }else {
            System.out.println("No hay autores registrados");
        }
        return null;
    }

    private void librosRegistrados() {
        List<Libros> libros = libroRepository.findAll();

        System.out.println("-----LISTA LIBROS-----\n");
        libros.forEach(System.out::println);
    }

    @Transactional
    private Datos libroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var busqueda = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + busqueda.replace(" ", "+"));
        var datosLibros = conversor.obtenerDatos(json, Datos.class);

        Optional<DatosLibros> libroBuscado = datosLibros.listaLibros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(busqueda.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()){
            DatosLibros datoslibro = libroBuscado.get();
            Autor autor = obtenerAutor(datoslibro);
            String idioma = obtenerPrimerIdioma(datoslibro.idioma());

            Libros libros = new Libros(datoslibro.titulo(), autor, idioma, datoslibro.numeroDeDescargas());

            System.out.println(libros);

            libroRepository.save(libros);

//            // Establecer la relación entre el libro y los autores
//            for (Autor autor : autores) {
//                autor.setLibros(libros); // Establecer la relación
//            }

        }else {
            System.out.println("Libro no encontrado");
        }
        return null;
    }

    private Autor obtenerAutor(DatosLibros datoslibro) {
        List<DatosAutor> datosAutor = datoslibro.autor();
        for (DatosAutor datoAutor : datosAutor) {
            Autor autor = new Autor();
            autor.setNombre(datoAutor.nombre());
            autor.setFechaDeNacimiento(datoAutor.fechaDeNacimiento());
            autor.setFechaDeFallecimiento(datoAutor.fechaDeFallecimiento());
            return autor;
        }
        return null;
    }

    private String obtenerPrimerIdioma(List<String> idiomas){
        String primerIdioma = idiomas.get(0);

        return primerIdioma;
    }
}
