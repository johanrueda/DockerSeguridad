# Taller de de modularización con virtualización e Introducción a Docker y a AWS
Este programa tiene como proposito la enseñanza de la utilizacion de dockers con una infraestructura de balanceador de carga

## Prerequisitos del sistema
* Maven
* Git
* Java
* Docker
* Mongo

## Descarga,instalacion y ejecución
Primero debemos clonar el repositorio, como veremos en el siguiente comando:

**git clone https://github.com/johanrueda/Arep_Docker**

Ahora ejecutamos una consola de comandos en el directorio donde fue clonado el repositorio y compilar el proyecto con el siguiente comando:

**mvn package**



**mvn test**

## Como funciona

La aplicacion que utiliza una base de datos mongo, donde se le inserta una palabra y ella la guardara con su fecha de ingreso, donde tambien tenemos la opcion de imprimir todas las palabras insertadas

## Documentación

Para generar la documentación de Java Doc ejecute el siguiente comando:

**mvn javadoc:javadoc**

## Desarrollo

Este proyecto se desarrollo con:
* Maven
* Java 8
* Intellij IDEA
* Mongo
* Docker

Primero creamos el docker compose para hacer la configuracion automatica de nuestro docker

![](imagenes/1.PNG)

luego creamos y ejecutamos las imagenes de docker para el balanceador de carga y el servicio en sus respectivos puertos

![](imagenes/2.PNG)


![](imagenes/3.PNG)

![](imagenes/4.PNG)

Asi es como queda nuestro docker

![](imagenes/5.PNG)

Luego vamos a ejecutarlo localemnte para verificar su funcionamiento

![](imagenes/6.PNG)

Ahora vamos a crear un repositorio en docker hub y subir nuestras imagenes

![](imagenes/7.PNG)

Para poder crear nuestra instancia de EC2 de AWS vamos a aws Educate y la lanzamos, para conectarnos utilizamos el siguiente comando

![](imagenes/8.PNG)

Configuramos los respectivos puertos en el grupo de seguirdad de nuestra instancia

![](imagenes/9.PNG)

instalamos docker en nuestra instancia

![](imagenes/10.PNG)

le cambiamos el usuario a la instancia

![](imagenes/11.PNG)

ahora lanzamos la imagen de nuestro docker a la instancia EC2

![](imagenes/12.PNG)

y ahora verificamos su funcionamiento

![](imagenes/13.PNG)


## Autor

**Johan David Rueda Rodriguez**

## Licencia
Este proyecto lo contiene la licencia GNU GENERAL PUBLIC LICENSE.
