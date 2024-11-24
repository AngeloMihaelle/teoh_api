# TEOH API

## Descripción
La API de TEOH es un sistema backend diseñado para gestionar el sitio web de TEOH, un portal especializado en el tratamiento de ostomías y heridas. La API permite gestionar los productos, pedidos, usuarios, artículos del blog y casos de éxito de los usuarios. La plataforma permite a los usuarios realizar compras, acceder a contenido informativo y gestionar su historial de pedidos.

## Tecnologías Utilizadas
- **Java** (versión 17 o superior)
- **Spring Boot** para crear la API RESTful
- **JPA/Hibernate** para la gestión de base de datos
- **PostgreSQL** como sistema de gestión de base de datos
- **Swagger/OpenAPI** para la documentación de la API
- **Lombok** para la generación automática de getters, setters y constructores

## Endpoints Principales

### Usuarios
- **GET** `/api/usuarios`: Obtiene todos los usuarios.
- **GET** `/api/usuarios/{id}`: Obtiene un usuario por ID.
- **POST** `/api/usuarios`: Crea un nuevo usuario.
- **PUT** `/api/usuarios/{id}`: Actualiza un usuario existente.
- **DELETE** `/api/usuarios/{id}`: Elimina un usuario.

### Productos
- **GET** `/api/productos`: Obtiene todos los productos.
- **GET** `/api/productos/{id}`: Obtiene un producto por ID.
- **POST** `/api/productos`: Crea un nuevo producto.
- **PUT** `/api/productos/{id}`: Actualiza un producto existente.
- **DELETE** `/api/productos/{id}`: Elimina un producto.

### Pedidos
- **GET** `/api/pedidos`: Obtiene todos los pedidos.
- **GET** `/api/pedidos/{id}`: Obtiene un pedido por ID.
- **POST** `/api/pedidos`: Crea un nuevo pedido.
- **PUT** `/api/pedidos/{id}`: Actualiza un pedido existente.
- **DELETE** `/api/pedidos/{id}`: Elimina un pedido.

### Casos
- **GET** `/api/casos`: Obtiene todos los casos.
- **GET** `/api/casos/{id}`: Obtiene un caso por ID.
- **POST** `/api/casos`: Crea un nuevo caso.
- **PUT** `/api/casos/{id}`: Actualiza un caso existente.
- **DELETE** `/api/casos/{id}`: Elimina un caso.

### Artículos del Blog
- **GET** `/api/articulos`: Obtiene todos los artículos del blog.
- **GET** `/api/articulos/{id}`: Obtiene un artículo del blog por ID.
- **POST** `/api/articulos`: Crea un nuevo artículo del blog.
- **PUT** `/api/articulos/{id}`: Actualiza un artículo del blog existente.
- **DELETE** `/api/articulos/{id}`: Elimina un artículo del blog.

## Instalación

### Requisitos
- **Java 17 o superior**
- **Maven** o **Gradle** (dependiendo de la herramienta de construcción preferida)
- **PostgreSQL** para la base de datos
- **IDE** como IntelliJ IDEA, Eclipse, o similar

### Pasos para la instalación
1. Clona este repositorio:

   ```bash
   git clone https://github.com/tu_usuario/teoh-api.git
   cd teoh-api
   ```

2. Configura la base de datos PostgreSQL en tu entorno local:
   - Crea una base de datos llamada `teoh` (o la que prefieras).
   - Configura los parámetros de conexión en el archivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/teoh
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   ```

3. Compila el proyecto con Maven o Gradle:
   - Con Maven:
     ```bash
     mvn clean install
     ```
   - Con Gradle:
     ```bash
     gradle build
     ```

4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```
   O si usas Gradle:
   ```bash
   gradle bootRun
   ```

5. La API debería estar disponible en `http://localhost:8080/swagger-ui/swagger-ui/index.html`.

## Documentación de la API

La API está documentada utilizando **Swagger** y se puede acceder en la siguiente URL:

```
http://localhost:8080/swagger-ui.html
```
