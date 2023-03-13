<H2>Prueba acrismatic</H2>
Este proyecto implementa un endpoint que muestra las recaudaciones cuyos contadores manuales no coinciden con el contador inmediatamente anterior a la recaudación. El proyecto utiliza Java 11, Maven y Spring Boot, y utiliza la base de datos H2 para almacenar los datos iniciales.

<H2> Requisitos</H2>
Para ejecutar este proyecto es necesario tener instalado Java 11 y Maven.

<H2>Instalación</H2>
Clonar el repositorio en la máquina local.
Navegar a la carpeta del proyecto.
Ejecutar mvn clean install para compilar y generar el archivo jar.
<H2>Uso</H2>
Ejecutar el archivo jar generado en la carpeta target mediante el comando java -jar nombre-del-archivo.jar.
Navegar a la URL http://localhost:8080/recaudaciones para acceder al endpoint de las recaudaciones.
Es posible filtrar por rango de fechas agregando los parámetros fechaDesde y fechaHasta a la URL en formato yyyy-MM-dd.
<H2>Datos iniciales</H2>
Los datos iniciales se encuentran en la carpeta src/main/resources/data.sql. Se incluyen las siguientes tablas:

clientes: contiene el nombre de los clientes.
maquinas: contiene la información de las máquinas.
recaudaciones: contiene la información de las recaudaciones.
contadores_manuales: contiene los contadores manuales de las máquinas.
contadores_automaticos: contiene los contadores automáticos de las máquinas.
Formato de respuesta
El endpoint devuelve un objeto JSON con la siguiente estructura:

<img src="https://raw.githubusercontent.com/falexramos/prueba_acrismatic/main/img/formatosalidaJson.png" alt="Formato salida JSON">


Autor
Favian Ramos