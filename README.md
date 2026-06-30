# 🏔️ Llanquihue Tour - Sistema de Gestión Turística

## 📋 Descripción
Sistema de gestión para la agencia de turismo Llanquihue Tour, ubicada en la Región de Los Lagos, Chile. La aplicación permite administrar de manera eficiente los registros de:

- Empleados de la agencia
- Guías Turísticos
- Operadores Turísticos
- Proveedores de servicios
- **Servicios Turísticos (Nuevo)**

## 📦 Estructura del Proyecto
LlanquihueTourSystem/
└── src/main/java/
└── com.mycompany.llanquihuetoursystem/
├── LlanquihueTourSystem.java # Clase principal (Main)
├── data/
│ ├── CargadorDatos.java # Carga desde archivos CSV
│ └── GestorServicios.java # Gestión de servicios turísticos (Nuevo)
├── model/
│ ├── Persona.java # Clase abstracta base
│ ├── Direccion.java # Composición
│ ├── Empleado.java # Herencia
│ ├── Guia.java # Herencia
│ ├── Operador.java # Herencia
│ ├── Proveedor.java # Herencia
│ ├── ServicioTuristico.java # Superclase (Nuevo)
│ ├── RutaGastronomica.java # Subclase (Nuevo)
│ ├── PaseoLacustre.java # Subclase (Nuevo)
│ └── ExcursionCultural.java # Subclase (Nuevo)
├── service/
│ └── GestionTuristica.java # Lógica de negocio y filtros
├── ui/
│ └── Main.java # Punto de entrada alternativo (Nuevo)
└── util/
└── Validador.java # Validaciones de datos

text

## 🎯 Principios de POO Aplicados

| Principio | Implementación |
|-----------|----------------|
| **Encapsulamiento** | Atributos `private` con getters/setters |
| **Herencia** | `Guia`, `Operador`, `Proveedor`, `Empleado` extienden `Persona` |
| **Herencia Simple** | `RutaGastronomica`, `PaseoLacustre`, `ExcursionCultural` extienden `ServicioTuristico` |
| **Composición** | `Persona` tiene una `Direccion` |
| **Polimorfismo** | Método abstracto `getRol()` en `Persona` y sobrescritura de `toString()` |
| **Abstracción** | `Persona` y `ServicioTuristico` son clases abstractas |
| **Sobrescritura** | Uso de `@Override` en `toString()` de todas las subclases |
| **super()** | Uso de `super()` en constructores de subclases |

## 🌿 Nueva Jerarquía de Servicios Turísticos (Semana 6)

### Diagrama de Clases
ServicioTuristico (Superclase)
├── nombre: String
├── duracionHoras: int
├── getters/setters
└── toString()

├── RutaGastronomica (Subclase)
│ └── numeroDeParadas: int
│ └── toString() sobrescrito
│
├── PaseoLacustre (Subclase)
│ └── tipoEmbarcacion: String
│ └── toString() sobrescrito
│
└── ExcursionCultural (Subclase)
└── lugarHistorico: String
└── toString() sobrescrito

text

### Clases Creadas

| Clase | Tipo | Atributos | Método toString() |
|-------|------|-----------|-------------------|
| **ServicioTuristico** | Superclase | `nombre`, `duracionHoras` | Muestra nombre y duración |
| **RutaGastronomica** | Subclase | `numeroDeParadas` | Muestra nombre, duración y paradas |
| **PaseoLacustre** | Subclase | `tipoEmbarcacion` | Muestra nombre, duración y embarcación |
| **ExcursionCultural** | Subclase | `lugarHistorico` | Muestra nombre, duración y lugar |

### Ejemplo de Instancias Creadas

java
// Rutas Gastronómicas
RutaGastronomica ruta1 = new RutaGastronomica("Sabor a Lago", 4, 6);
RutaGastronomica ruta2 = new RutaGastronomica("Ruta de la Cerveza Artesanal", 3, 5);

// Paseos Lacustres
PaseoLacustre paseo1 = new PaseoLacustre("Navegación al Atardecer", 2, "Velero");
PaseoLacustre paseo2 = new PaseoLacustre("Ruta de los Volcanes", 4, "Lancha Motora");

// Excursiones Culturales
ExcursionCultural cultural1 = new ExcursionCultural("Museo Colonial", 3, "Museo Colonial Alemán");
ExcursionCultural cultural2 = new ExcursionCultural("Fuerte Nahuelbuta", 5, "Fuerte Nahuelbuta");
🚀 Instrucciones de Ejecución
Opción 1: Desde el Main principal
Abrir el proyecto en NetBeans o IntelliJ IDEA

Ejecutar la clase LlanquihueTourSystem.java

Interactuar con el menú principal

Opción 2: Desde ui/Main (Requisito Semana 6)
Abrir el proyecto en NetBeans o IntelliJ IDEA

Navegar a ui/Main.java

Ejecutar la clase

El sistema cargará todos los datos y mostrará el menú

Opción 3: Línea de comandos (Maven)
bash
# Limpiar y compilar
mvn clean compile

# Ejecutar
mvn exec:java -Dexec.mainClass="com.mycompany.llanquihuetoursystem.ui.Main"
📊 Funcionalidades del Menú
Opción	Descripción
1	Mostrar todos los registros
2	Buscar guías por especialidad
3	Ver guías disponibles
4	Buscar operadores por servicio
5	Buscar proveedores por rubro
6	Buscar proveedores por calificación
7	Buscar persona por nombre
8	Ver estadísticas del sistema
9	Ver servicios turísticos (Nuevo Semana 6)
10	Salir
Salida de la Opción 9 (Servicios Turísticos)
text
╔══════════════════════════════════════════════╗
║        🌿 SERVICIOS TURÍSTICOS              ║
║         Llanquihue Tour - Los Lagos         ║
╚══════════════════════════════════════════════╝

--- RUTAS GASTRONÓMICAS ---
🍽️ Ruta Gastronómica: Sabor a Lago | Duración: 4 horas | Paradas: 6
🍽️ Ruta Gastronómica: Ruta de la Cerveza Artesanal | Duración: 3 horas | Paradas: 5

--- PASEOS LACUSTRES ---
⛵ Paseo Lacustre: Navegación al Atardecer | Duración: 2 horas | Embarcación: Velero
⛵ Paseo Lacustre: Ruta de los Volcanes | Duración: 4 horas | Embarcación: Lancha Motora

--- EXCURSIONES CULTURALES ---
🏛️ Excursión Cultural: Museo Colonial | Duración: 3 horas | Lugar: Museo Colonial Alemán
🏛️ Excursión Cultural: Fuerte Nahuelbuta | Duración: 5 horas | Lugar: Fuerte Nahuelbuta

✅ Servicios turísticos cargados exitosamente
📝 Archivos de Datos
El sistema carga datos desde archivos CSV en src/main/resources/datos/:

guias.csv
text
Rut,Nombre,Apellido,Telefono,Email,Calle,Numero,Comuna,Ciudad,Region,Especialidad,AñosExperiencia,Idiomas,Disponible
operadores.csv
text
Rut,Nombre,Apellido,Telefono,Email,Calle,Numero,Comuna,Ciudad,Region,Empresa,TipoServicio,CapacidadMaxima,Activo
proveedores.csv
text
Rut,Nombre,Apellido,Telefono,Email,Calle,Numero,Comuna,Ciudad,Region,Rubro,HorarioAtencion,Calificacion
📹 Video de Demostración
Ver video de demostración

👤 Autor
Alejandro Serrano

📅 Fecha
Junio 2026

🏫 Asignatura
Desarrollo Orientado a Objetos I - Semana 6

📚 Tecnologías Utilizadas
Java 8+

Maven

POO (Herencia, Polimorfismo, Encapsulamiento, Abstracción)

Archivos CSV para persistencia de datos

Programación por capas (Modelo - Datos - Servicio - UI)

🔧 Próximas Mejoras
Persistencia en base de datos

Interfaz gráfica (JavaFX/Swing)

Sistema de reservas

Generación de reportes

Autenticación de usuarios

text

---

## ✅ Después de tener el README en la raíz:

### Vuelve a subir todo a GitHub:

```cmd
git add README.md
git commit -m "Agregado README.md actualizado con Semana 6"
git push -u origin main --force
