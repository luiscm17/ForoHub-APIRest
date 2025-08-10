# ForoHub API REST

[![Java](https://img.shields.io/badge/Java-24-orange)](https://www.oracle.com/java/technologies/javase/jdk24-archive-downloads.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> **Nota**: Este proyecto forma parte del desafío técnico del programa de formación Backend con Java y Spring Boot de [Alura Latam](https://www.aluracursos.com/) en colaboración con [ONE (Oracle Next Education)](https://www.oracle.com/ar/education/oracle-next-education/).

## 📋 Descripción

ForoHub es una API REST desarrollada con Spring Boot que permite la gestión de un foro educativo. Los usuarios pueden crear cursos, publicar tópicos de discusión y responder a los mismos, fomentando la colaboración y el aprendizaje en comunidad.

## 🚀 Características

- **Gestión de Usuarios**: Registro y administración de perfiles de usuario
- **Cursos**: Creación y gestión de cursos educativos
- **Tópicos**: Publicación y seguimiento de discusiones
- **Respuestas**: Sistema de respuestas con marcado de soluciones
- **API RESTful**: Diseño siguiendo las mejores prácticas REST
- **Base de datos**: MySQL con migraciones mediante Flyway

## 🛠️ Tecnologías

- **Lenguaje**: Java 24
- **Framework**: Spring Boot 3.5.4
- **Base de datos**: MySQL 8.0+
- **ORM**: Hibernate/JPA
- **Migraciones**: Flyway
- **Utilidades**: Lombok, Spring Boot DevTools

## 🏗️ Estructura del Proyecto

```bash
src/main/java/com/luiscm/forohub/
├── config/           # Configuraciones de la aplicación
├── controller/       # Controladores REST
├── model/            # Entidades y DTOs
│   ├── dto/          # Objetos de Transferencia de Datos
│   └── enums/        # Enumeraciones
├── repository/       # Repositorios de datos
├── service/          # Lógica de negocio
└── ForohubApplication.java
```

## 🚀 Primeros Pasos

### Requisitos Previos

- Java 24 (JDK 24)
- Maven 3.6.3 o superior
- MySQL 8.0+

### Configuración Inicial

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/luiscm17/ForoHub-APIRest.git
   cd ForoHub-APIRest
   ```

2. **Configurar la base de datos**:
   - Crea una base de datos MySQL llamada `forohub_db`
   - Configura las credenciales en `src/main/resources/application.properties`:

     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/forohub_db
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     ```

3. **Ejecutar migraciones**:
   - Las migraciones de Flyway se ejecutarán automáticamente al iniciar la aplicación

4. **Iniciar la aplicación**:

   ```bash
   ./mvnw spring-boot:run
   ```

5. **Acceder a la API**:
   - La aplicación estará disponible en `http://localhost:8080`

## 📚 Documentación de la API

Puedes encontrar ejemplos detallados de solicitudes y respuestas para cada endpoint en la carpeta [docs/](docs/):

- [Usuarios](docs/user-examples.json)
- [Cursos](docs/course-examples.json)
- [Tópicos](docs/topic-examples.json)
- [Respuestas](docs/reply-examples.json)

## 🔧 Variables de Entorno

Para configuraciones sensibles, se recomienda usar variables de entorno:

```bash
export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/forohub_db
export SPRING_DATASOURCE_USERNAME=tu_usuario
export SPRING_DATASOURCE_PASSWORD=tu_contraseña
```

## 🧪 Ejecutando las Pruebas

```bash
./mvnw test
```

## 📦 Despliegue

Para crear un archivo JAR ejecutable:

```bash
./mvnw clean package
java -jar target/forohub-0.0.1-SNAPSHOT.jar
```

## 🤝 Contribución

¡Las contribuciones son bienvenidas! Por favor, sigue estos pasos:

1. Haz un Fork del proyecto
2. Crea una rama para tu característica (`git checkout -b feature/AmazingFeature`)
3. Haz commit de tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Haz push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 📧 Contacto

Luis CM - [@luiscm17](https://github.com/luiscm17)

---
