# Taller de Aplicacion segura
Este programa tiene como proposito el acceso seguro de un servicio web desde un navegador, manejando llaves y certificados donde se garantiza la autenticidad, integridad y cofidencialidad.

## Prerequisitos del sistema
* Maven
* Git
* Java
* Docker

## Descarga,instalacion y ejecución
Primero debemos clonar el repositorio, como veremos en el siguiente comando:

**git clone https://github.com/johanrueda/DockerSeguridad**

Ahora ejecutamos una consola de comandos en el directorio donde fue clonado el repositorio y compilar el proyecto con el siguiente comando:

**mvn package**



**mvn test**

## Como funciona

La aplicacion utiliza certificado y un par de llaves para el acceso seguro desde el navegador, pero ademas se utiliza encriptacion de la contraseña del usuario.

## Documentación

Para generar la documentación de Java Doc ejecute el siguiente comando:

**mvn javadoc:javadoc**

## Desarrollo

Este proyecto se desarrollo con:
* Maven
* Java 8
* Intellij IDEA
* Docker

Se manejo la siguiente Arquitectura, se utiliza un login que tiene acceso encriptado de la contraseña, donde obtiene el acceso al servicio web desplegado.

![](imagenes/arq.PNG)


Al crear nuestro servicio web, creamos nuestras llaves y certificado para hacer nuestro servicio web seguro HTTPS

![](imagenes/llave.png)

ahora creamos nuestro certificado

![](imagenes/certificado.png)

y ahora creamos nuestro MyTrueStore

![](imagenes/store.png)

ahora subimos nuestra imagen a docker 

![](imagenes/docker1.PNG)

y corremos la imagen en el puerto 4000

![](imagenes/docker2.PNG)

ahora consultamos en nuestro navegador, preferiblemente FIREFOX y vemos que nuestros certificados y llaves ya estan funcionando

![](imagenes/pagina1.PNG)

accedemos a nuestra pagina inicial

![](imagenes/pagina2.PNG)

Ahora subimos nuestra imagen docker al repositorio de docker hub

![](imagenes/subirDocker.PNG)

creamos nuestra instancia de AWS EC2, instalamos docker y corremos la imagen que subimos a nuestro repositorio

![](imagenes/correrAWS.PNG)

y por ultimo ingresamos al navegador para verificar que nuestro servicio este funcionando en la instancia

![](imagenes/paginaAWS.PNG)

El video se muestra su funcionamiento totalmente


## Autor

**Johan David Rueda Rodriguez**

## Licencia
Este proyecto lo contiene la licencia GNU GENERAL PUBLIC LICENSE.
