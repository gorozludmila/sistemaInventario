Este proyecto consiste en el desarrollo de una aplicación web de inventario utilizando Spring Boot, orientada a la gestión de productos y su relación con otras entidades del sistema.
La aplicación implementa un CRUD completo (Crear, Leer, Actualizar y Eliminar) sobre productos, permitiendo administrar información como nombre, precio y categoría, manteniendo la integridad de los datos mediante relaciones entre tablas definidas con JPA/Hibernate.
El sistema utiliza una arquitectura en capas, separando claramente:
Entidades del dominio
Repositorios
Controladores
Vistas
Las vistas están desarrolladas con Thymeleaf, integradas a Spring Boot, y se utiliza Bootstrap para lograr una interfaz sencilla y funcional.
La persistencia de datos se maneja a través de una base de datos relacional, con claves foráneas que aseguran la consistencia entre productos, categorías, marcas y otras entidades relacionadas.
El objetivo principal del proyecto es comprender y aplicar correctamente las relaciones entre entidades, el manejo de formularios para altas y modificaciones, y el comportamiento del sistema ante operaciones de eliminación cuando existen dependencias en la base de datos.
