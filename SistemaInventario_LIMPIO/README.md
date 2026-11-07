# Sistema de Inventario

**Estudiante:** Yessica Amparo Rodríguez Guerrero
**Curso:** Programación Orientada a Objetos 1 (54448) – Segundo bloque – 26V04
**Programa:** Técnico Profesional en Soporte de Sistemas e Informática – Ing. de Sistemas – CUN

## Descripción

Aplicación de consola en Java que simula el inventario de una pequeña tienda. Toda la información se guarda en memoria (no usa base de datos ni interfaz gráfica) y se maneja desde un menú por consola.

## Funcionalidades

1. **Registrar producto**: pide código, nombre, precio, cantidad, categoría y si es perecedero (en ese caso, fecha de vencimiento).
2. **Mostrar productos**: lista todos los productos y calcula el **valor total del inventario**.
3. **Buscar producto por código**: muestra el producto o informa que no existe.
4. **Salir**.

## Clases utilizadas

| Clase | Paquete | Rol |
|---|---|---|
| `Producto` | `modelo` | Clase de objeto: código, nombre, precio, cantidad y categoría (atributos privados, constructor, getters/setters) |
| `ProductoPerecedero` | `modelo` | Subclase de `Producto`: agrega la fecha de vencimiento |
| `Inventario` | `modelo` | Clase contenedora: guarda un `ArrayList<Producto>` y un arreglo de categorías |
| `ProductoNoEncontradoException` | `excepciones` | Excepción personalizada |
| `Main` | (sin paquete) | Menú por consola |

## Conceptos de POO aplicados

**Núcleo**
- Clases y objetos, atributos y métodos.
- Encapsulamiento: atributos `private` con getters y setters.
- Relación entre clases: `Inventario` contiene objetos `Producto`.
- Arreglo (`String[] CATEGORIAS`) recorrido con `for`.
- Lista (`ArrayList<Producto>`) y su recorrido con `for-each` (muestra y suma el valor total).
- Biblioteca estándar de Java (`ArrayList`, `Scanner`).
- `try-catch` con `NumberFormatException` para entradas inválidas en el menú.
- Excepción personalizada `ProductoNoEncontradoException`.
- Menú por consola con `do-while` y `switch`.

**Extra**
- Herencia: `ProductoPerecedero extends Producto`.
- Polimorfismo: `mostrarInformacion()` se sobrescribe con `@Override` en `ProductoPerecedero`.
- Segundo `try-catch`: captura `IllegalArgumentException` cuando el precio o la cantidad son negativos, o cuando el código ya existe.
- Organización en paquetes: `modelo/` y `excepciones/`; `Main.java` queda sin paquete.

## Estructura

```
src
├── Main.java
├── modelo
│   ├── Producto.java
│   ├── ProductoPerecedero.java
│   └── Inventario.java
└── excepciones
    └── ProductoNoEncontradoException.java
```

## Cómo ejecutar

Requisitos: JDK 11 o superior.

Desde la carpeta del proyecto:

```bash
javac -encoding UTF-8 -d out src/Main.java src/modelo/*.java src/excepciones/*.java
java -Dfile.encoding=UTF-8 -cp out Main
```

En Windows, si las tildes se ven mal, ejecute antes `chcp 65001`.

## Ejemplo de ejecución

```
=================================
      SISTEMA DE INVENTARIO
=================================
1. Registrar producto
2. Mostrar productos
3. Buscar producto
4. Salir
Seleccione una opción: 3
Ingrese el código: 999
Error: El producto no fue encontrado.
```
