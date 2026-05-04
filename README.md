# 🗄️ Ejercicio15 [ConexionOracleMaven] — Consultas con Joins (Multitabla)

Este proyecto Java gestionado con Maven se conecta a una base de datos Oracle para realizar consultas que combinan datos de múltiples tablas relacionadas. La aplicación demuestra cómo recuperar información vinculada mediante el uso de la cláusula `JOIN` de SQL.

## 📋 Descripción del Proyecto
El propósito de este programa es demostrar la recuperación de información relacionada entre las tablas `empleado` y `departamento`. El sistema realiza una unión interna (Inner Join) para asociar a cada empleado con el nombre del departamento al que pertenece, utilizando la columna común `dep_id` como vínculo.

## 🎯 Funcionalidades Principales
Al ejecutarse, el programa realiza las siguientes acciones automáticas:
*   **Conexión JDBC**: Establece el enlace con Oracle utilizando las credenciales de `db.properties`.
*   **Consulta Relacional**: Ejecuta la sentencia SQL `SELECT empleado.nombre, departamento.nombre FROM empleado JOIN departamento USING(dep_id)`.
*   **Procesamiento de Resultados**: Recorre el `ResultSet` extrayendo los nombres de ambas tablas de forma simultánea.
*   **Visualización Jerárquica**: Muestra en consola el nombre del empleado seguido del nombre de su departamento con un formato sangrado para mayor claridad.

## 🏗️ Estructura del Proyecto
El proyecto mantiene la organización modular estándar de Maven:

```text
Ejercicio15 [ConexionOracleMaven]/
│
├── 📁 src/
│   └── 📁 main/
│       ├── 📁 java/
│       │   └── 📁 org/example/
│       │       ├── ☕ DBConfig.java        # Proveedor de configuración JDBC
│       │       └── ☕ Main.java            # Lógica de consulta multitabla (JOIN)
│       └── 📁 resources/
│           └── 📄 db.properties           # Credenciales de acceso externas
│
├── 📁 target/                             # Binarios generados por Maven
├── 📄 pom.xml                             # Gestión de dependencias (OJDBC11)
└── 📄 README.md                           # Documentación del proyecto
```

## 📄 Formato del Archivo de Entrada
Asegúrate de que el archivo `src/main/resources/db.properties` esté configurado correctamente:
```properties
db.url=jdbc:oracle:thin:@localhost:1521:xe
db.user=tu_usuario
db.password=tu_contraseña
```

## 🚀 Compilación y Ejecución
### Requisitos
*   Java JDK 17 o superior.
*   Maven 3.8+ instalado.
*   Base de datos Oracle con las tablas `empleado` y `departamento` debidamente relacionadas.

### Comandos de Terminal
```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## 🔧 Características Técnicas Implementadas
*   **Cláusula JOIN con USING**: Simplifica la sintaxis de unión al utilizar una columna con el mismo nombre en ambas tablas.
*   **Consultas Multitabla**: Recuperación eficiente de datos distribuidos en el esquema relacional.
*   **Gestión de Recursos**: Uso de `try-with-resources` para garantizar el cierre de `Connection`, `Statement` y `ResultSet`.
*   **Manejo de SQL**: Captura de excepciones para identificar fallos en la estructura de las tablas o en la conectividad.

## 🎮 Ejemplo de Uso Visual

**Salida en Consola:**
```bash
Nombre: Judith
        Nombre: IT
Nombre: Sergio
        Nombre: RRHH
```

---
**Autor:** Judith Olmedo Andrés  
*Ejercicio 15 - Consultas Relacionales y Joins con JDBC y Oracle*