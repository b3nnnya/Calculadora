# Calculadora vCientifica

Proyecto universitario para simular una calculadora con operaciones matemáticas avanzadas, gestión de excepciones y validación de tipos de entrada.

## Coordinación de Trabajo (Requerimiento GitHub)

Este proyecto fue desarrollado en conjunto simulando las distintas fases (A, B y C) de la rúbrica.

**División de tareas**:
- **Alumno 1**: Implementación de lógica aritmética básica, excepciones particulares (como división por cero o potencia `0^0`), sistema de ecuaciones lineales, ecuación de recta, y tests unitarios. (Rama de desarrollo: `feature/aritmetica-ecuaciones`)
- **Alumno 2**: Implementación de ecuación cuadrática, figura geométricas (P, A, V), manejo de excepciones con argumento ilegal en raíces y tests unitarios de áreas/volúmenes. (Rama de desarrollo: `feature/geometria-cuadratica`)
- **Alumno 3 (o en conjunto)**: Integración final de componentes, desarrollo del controlador y `MenuCalculadora` validando entradas con `try-catch (Exception e) {}`, evitando cuelgues del programa. Coordinación de la mezcla del código (Merge) a la rama `main` (Versión 3 integrada).

## Cómo Ejecutar

Desde una consola posicionada en este directorio raíz, correr los siguientes comandos de Maven:

```bash
# Compilar y ejecutar pruebas unitarias (JUnit 5)
mvn clean test

# Ejecutar el menú interactivo para usar la calculadora
mvn exec:java -Dexec.mainClass="com.calculadora.MenuCalculadora"
```
