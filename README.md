# Proyecto Spring Security con JWT y Cifrado de Contraseñas

---

Este proyecto es una base para la creación de APIs seguras utilizando Spring Security, JSON Web Tokens (JWT) y cifrado de contraseñas. Está diseñado siguiendo los principios SOLID para asegurar un código limpio, mantenible y escalable.

---
## Tabla de Contenidos

- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Configuración Spring](#configuración-spring)
- [Instalación](#instalación)
- [Credenciales](#credenciales)
- [Funcionamiento JWT](#funcionamiento-jwt)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)
---
## Características

- Autenticación y autorización utilizando JWT.
- Cifrado de contraseñas con BCrypt.
- Estructura de código siguiendo los principios SOLID.
- Ejemplos de endpoints para registro y autenticación de usuarios.
- Manejo de excepciones y respuestas estandarizadas.
---
## Tecnologías Utilizadas

- Java 24
- Spring Boot
- JWT (JSON Web Tokens)
- Hibernate
- PostgreSQL (o cualquier base de datos compatible)
- Maven
---
## Configuración Spring

Dependencias proyecto Spring Boot:
* Spring Web
* Spring boot devtools
* Spring Data JPA
* PostgreSQL
* Spring Security
* Dependencia jwt (añadida manualmente en pom.xml)

``` xml
    <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
    <dependency>
          <groupId>io.jsonwebtoken</groupId>
          <artifactId>jjwt-api</artifactId>
          <version>0.12.5</version>
      </dependency>
      <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl -->
      <dependency>
          <groupId>io.jsonwebtoken</groupId>
          <artifactId>jjwt-impl</artifactId>
          <version>0.12.5</version>
          <scope>runtime</scope>
      </dependency>
      <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson -->
      <dependency>
          <groupId>io.jsonwebtoken</groupId>
          <artifactId>jjwt-jackson</artifactId>
          <version>0.12.5</version>
          <scope>runtime</scope>
      </dependency>
      <!-- https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api -->
      <dependency>
          <groupId>jakarta.servlet</groupId>
          <artifactId>jakarta.servlet-api</artifactId>
          <version>6.0.0</version>
          <scope>provided</scope>
      </dependency>
```
---
## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio
---

## Credenciales

Se ha incluido usuarios con Role de OWNER Y ADMINISTRATOR

   ```JSON
  {
    "username": "admin",
    "password": "45678"
  }
  ```
  ```JSON
  {
    "username": "owner",
    "password": "1234"
  }
  ```
---
## Funcionamiento JWT

1. Cliente envía una petición a un servidor (/api/login)
2. Servidor valida username y password, si no son válidos devolverá una respuesta 401 unauthorized
3. Servidor valida username y password, si son válidos entonces genera un token JWT utilizando una secret key
4. Servidor devuelve el token JWT generado al Cliente
5. Cliente envía peticiones a los endpoint REST del servidor utilizando el token JWT en las cabeceras
6. Servidor valida el token JWT en cada petición y si es correcto permite el acceso a los datos

Ventajas:
* El token se almacena en el Cliente, de manera que consume menos recursos en el Servidor, lo cual permite mejor escalabilidad.

Desventajas:
* El token está en el navegador, no podríamos invalidarlo antes de la fecha de expiración asignada condo se creó
  * Lo que se realiza es dar la opción de logout, lo cual simplemente borra el token

---
## Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue estos pasos:

Haz un fork del proyecto.
Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
Realiza tus cambios y haz un commit (git commit -m 'Añadir nueva característica').
Haz push a la rama (git push origin feature/nueva-caracteristica).
Abre un Pull Request.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.