<h1 align="center"> Catalogo De Libros </h1>

<p align="center"> <img width="561" height="433" alt="image" src="https://github.com/user-attachments/assets/270abaf5-f10d-4542-915b-d4d494ca3684" /> </p>

Aplicación de consola desarrollada en Java con Spring Boot para gestionar un catálogo de libros. Permite a los usuarios buscar libros por título en una API externa, registrar la información en una base de datos local y realizar consultas sobre los libros, autores, idiomas disponibles y top 10 de los libros más descargados.

## Índice
* [Título e Imagen](#Título-e-imagen)
* [Índice](#índice)
* [Descripción del proyecto](#descripción-del-proyecto)
* [Estado del proyecto](#Estado-del-proyecto)
* [Características de la aplicación y demostración](#Funcionalidades-de-la-aplicacion)
* [Acceso al proyecto/Abre y Ejecuta el proyecto](#Acceso-al-proyecto)
* [Tecnologías utilizadas](#Tecnologías-Utilizadas)
* [Personas-Desarrolladores del Proyecto](#Autores)

## Estado del Proyecto
:white_check_mark: Proyecto Terminado :white_check_mark:


## :hammer:Funcionalidades de la Aplicacion

Las principales funcionalidades de la aplicación son:

  <img width="405" height="210" alt="1" src="https://github.com/user-attachments/assets/6b21ff43-d77e-462d-aa7a-d4bfacf883f4" />

*   Buscar libro por título en la API Gutendex y registrarlo en la base de datos.

  <img width="545" height="378" alt="2" src="https://github.com/user-attachments/assets/ea0272ec-26f1-46b9-8e34-c8c392e0cd03" />

*   Listar todos los libros registrados en la base de datos.
  
  <img width="313" height="490" alt="3" src="https://github.com/user-attachments/assets/11709284-2c78-486d-8fff-9bc77b47a3ef" />

*   Listar todos los autores registrados en la base de datos.
  
  <img width="315" height="488" alt="4" src="https://github.com/user-attachments/assets/692fd08b-8404-4bf2-9ded-03f8fea81c39" />

*   Listar los autores vivos en un año determinado.
  
  <img width="306" height="352" alt="5" src="https://github.com/user-attachments/assets/7ce785a7-3531-4385-b55f-8312f3e390e5" />

*   Listar los libros por idioma.

  <img width="436" height="519" alt="6" src="https://github.com/user-attachments/assets/e9ad2145-edc3-4d0a-a7e4-f3908e68745f" />

*   Listar Top 10 de libros más descargados.

  <img width="286" height="496" alt="7" src="https://github.com/user-attachments/assets/bb4c747d-f4cf-416f-a43b-17467f061207" />

La aplicación también maneja los siguientes casos:

*   Búsqueda de libros que no existen en la API.

   <img width="564" height="264" alt="8" src="https://github.com/user-attachments/assets/273d0557-08e7-46e6-87c6-bd8f1310a197" />
   
*   Intento de insertar el mismo libro varias veces en la base de datos.

  <img width="538" height="68" alt="9" src="https://github.com/user-attachments/assets/3ce75efc-f66c-4e13-8042-1f8961dd9c28" />

## 📁 Acceso al proyecto
1. Requisitos previos:

Asegúrate de tener instalado en tu equipo lo siguiente:
  - Java Development Kit (JDK): Versión 17 o superior. Puedes descargarlo desde https://www.oracle.com/java/technologies/javase-jdk17-downloads.html.
  - Maven: Puedes descargarlo desde https://maven.apache.org/download.cgi.
  - Git: Puedes descargarlo desde https://git-scm.com/downloads.
  - PostgreSQL: Puedes descargarlo desde https://www.postgresql.org/download/.
   
## 🛠️ Abre y ejecuta el proyecto
1. Clona este repositorio: git clone [[URL del repositorio](https://github.com/scamelo520/CatalogoLibros.git)]
2. Abre el proyecto en tu IDE Java preferido [IntelliJ IDEA, Eclipse, etc.(las intrucciones serán con IntelliJ)]
3. Configurar Base de Datos:
   - Crea una base de datos en PostgreSQL con el nombre que hayas configurado en tu archivo application.properties
   - Asegúrate de que las credenciales de acceso a la base de datos (usuario, contraseña, URL) sean correctas en tu archivo de configuración.
4. Ejecutar la Aplicación
5. Interactuar con la apliación
    - Una vez que la aplicación se haya iniciado correctamente, verás un mensaje en la consola indicando que la aplicación está lista para recibir comandos.
    - Sigue las instrucciones que se muestran en la consola para interactuar con la aplicación y utilizar sus funcionalidades.

## :computer: Tecnologías Utilizadas
- Tecnologías principales:

    - Java: Lenguaje de programación principal utilizado para desarrollar la aplicación.
    - Spring Boot: Framework de Java que facilita la creación de aplicaciones web y de consola.
    - Spring Data JPA: Módulo de Spring que simplifica el acceso a bases de datos relacionales utilizando JPA (Java Persistence API).
    - PostgreSQL: Sistema de gestión de bases de datos relacional utilizado para almacenar la información de los libros y autores.
    - Maven: Herramienta de gestión de proyectos y dependencias utilizada para construir y gestionar el proyecto.
    - Git: Sistema de control de versiones utilizado para gestionar el código fuente del proyecto.
    - Gutendex API: API REST utilizada para obtener información sobre libros.
      
- Tecnologías adicionales:

    - IntelliJ IDEA/Eclipse/NetBeans: Entornos de desarrollo integrados (IDEs) utilizados para desarrollar la aplicación.
    - Jackson: Librería de Java utilizada para serializar y deserializar objetos JSON.

## Autores
<img src="https://avatars.githubusercontent.com/u/196546316?v=4" width=115><br><sub>Santiago Camelo</sub>
