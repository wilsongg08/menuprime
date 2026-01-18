**Manual de instalación proyecto MenuPrime**

Prerrequisitos:
SQL Developer
https://www.oracle.com/database/sqldeveloper/technologies/download/

Oracle Database 21c Express Edition con acceso al usuario sys con sysdba
https://www.oracle.com/database/technologies/xe-downloads.html

Node.js LTS
https://nodejs.org/en/

Java SE 11 Archive
https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html

Angular CLI
https://angular.io/cli

Gradle Build Tool
https://gradle.org/install/


**Instalación Base de Datos APP_GEST_DOMICILIOS**

Descargar la carpeta “DB” y descomprimirla.
Abrir SQL developer y conectarse a la base de datos Oracle, si es primera conexión, asegurarse de estarse conectando a la PDB inicial llamada XEPDB1 (pluggable databases / bases de datos conectables), esto es con el fin de evitar generar el error ORA-65096: nombre de usuario o rol común no válido (https://apunteslti.com/2022/09/07/solucion-al-error-ora-65096-nombre-de-usuario-o-rol-comun-no-valido/)
En SQL Developer, darle click en Archivo y luego en Abrir, en la ventana que se abre se debe escoger la ubicación donde se descomprimió la carpeta DB, para luego abrir el archivo con el nombre “Orquestador_APP_GEST_DOMICILIOS.sql”.

Seleccionar todo el contenido del archivo y darle en ejecutar
Esperar que se termine de ejecutar todo el archivo y listo, el schema está creado y listo para ser usado.
En caso de querer eliminar todo el schema, es sino abrir el archivo “Rollback_APP_GEST_DOMICILIOS.sql” y ejecutar todos los scripts que allí se hayan. Este archivo se encuentra dentro de la carpeta “rollback”


**Instalación API**

Descargar la carpeta “API” y descomprimirla.
Desde cualquier IDE abrir la carpeta descomprimida y correr el proyecto.
Una vez termine de descargar y configurar las dependencias, se levantará el servidor local en el puerto 8080 por defecto.
En caso de querer cambiar el puerto del servidor local, esto se podrá hacer en el “application.properties” ubicado en src/main/resources. En este archivo también se define la url de conexión con la base de datos, el usuario/nombre del esquema y la contraseña, estos dos últimos por defecto son respectivamente APP_GEST_DOMICILIOS y oracle.
En cuanto a la url de conexión con la base de datos, es pertinente verificar en cual puerto local se encuentra expuesta la base de datos y también el PDB (xepdb1 u otra) donde se instaló el schema, para así hacer las pertinentes correcciones.

Para eliminar el proyecto, basta con eliminar la carpeta “API”.

**Instalación Front**

Descargar la carpeta “Front” y descomprimirla.
Abrir el CMD y entrar en la carpeta descomprimida
Ejecutar el comando npm install
Una vez termine de descargar y configurar, se debe ejecutar cualquiera de los siguientes comandos para levantar el servidor local: npm run ng serve o ng serve -o
Por defecto, el proyecto correrá en el localhost puerto 4200
El front está conectado con la API anteriormente instalada, por defecto el proyecto apuntará a API en la ruta 'http://localhost:8080', pero en caso de que se requiera definir una ruta/puerto diferente, esto se podrá hacer en el archivo environment ubicado en: src/environments/environment.ts

Para eliminar el proyecto, basta con eliminar la carpeta “Front”.

