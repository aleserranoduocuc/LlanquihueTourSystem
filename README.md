# 🏔️ Llanquihue Tour - Sistema de Gestión Turística

## 📋 Descripción
Sistema de gestión para la agencia de turismo Llanquihue Tour, ubicada en la Región de Los Lagos, Chile. La aplicación permite administrar de manera eficiente los registros de:

- Empleados de la agencia
- Guías Turísticos
- Operadores Turísticos
- Proveedores de servicios
- Servicios Turísticos
- Vehículos
- Colaboradores Externos

## 📦 Estructura del Proyecto
LlanquihueTourSystem/
└── src/main/java/
└── com.mycompany.llanquihuetoursystem/
├── LlanquihueTourSystem.java # Clase principal con menú
├── data/
│ ├── CargadorDatos.java # Carga desde archivos CSV
│ ├── GestorServicios.java # Gestión de servicios turísticos
│ └── GestorEntidades.java # Gestión de entidades con instanceof
├── model/
│ ├── Registrable.java # INTERFAZ - Comportamiento común
│ ├── Persona.java # Clase abstracta base
│ ├── Direccion.java # Composición
│ ├── Empleado.java # Herencia
│ ├── Guia.java # Herencia + Registrable
│ ├── Operador.java # Herencia + Registrable
│ ├── Proveedor.java # Herencia + Registrable
│ ├── Vehiculo.java # Registrable
│ ├── ColaboradorExterno.java # Registrable
│ ├── ServicioTuristico.java # Superclase abstracta
│ ├── RutaGastronomica.java # Subclase
│ ├── PaseoLacustre.java # Subclase
│ └── ExcursionCultural.java # Subclase
├── service/
│ └── GestionTuristica.java # Lógica de negocio
├── ui/
│ ├── Main.java # Punto de entrada alternativo
│ └── VentanaPrincipal.java # GUI con JFrame
└── util/
└── Validador.java # Validaciones

text

## 🎯 Principios de POO Aplicados

| Principio | Implementación |
|-----------|----------------|
| **Interfaz** | `Registrable` con método `mostrarResumen()` |
| **Herencia** | `Guia`, `Operador`, `Proveedor` extienden `Persona` |
| **Polimorfismo** | `Registrable` referencias a objetos de distintas clases |
| **instanceof** | Validación de tipo en tiempo de ejecución |
| **Colecciones Genéricas** | `List<Registrable>` para almacenar objetos |
| **Composición** | `Persona` tiene una `Direccion` |
| **Abstracción** | `Persona` y `ServicioTuristico` son abstractas |
| **Encapsulamiento** | Atributos `private` con getters/setters |
| **GUI** | Interfaz gráfica con `JFrame` y `JOptionPane` |

## 🔌 Interfaz Registrable

java
public interface Registrable {
    void mostrarResumen();
}
Clases que implementan Registrable:
Clase	Descripción
Guia	Guía turístico de la agencia
Operador	Operador turístico
Proveedor	Proveedor de servicios
Vehiculo	Vehículo para transporte de turistas
ColaboradorExterno	Colaborador externo
🌿 Jerarquía de Servicios Turísticos
Diagrama de Clases
text
ServicioTuristico (Superclase abstracta)
├── nombre: String
├── duracionHoras: int
├── getters/setters
├── + mostrarInformacion(): void (abstracto)
└── + toString(): String

  ├── RutaGastronomica (Subclase)
    │   └── numeroDeParadas: int
    │   └── + mostrarInformacion(): void (sobrescrito)
    │   └── + toString(): String (sobrescrito)
    │
    ├── PaseoLacustre (Subclase)
    │   └── tipoEmbarcacion: String
    │   └── + mostrarInformacion(): void (sobrescrito)
    │   └── + toString(): String (sobrescrito)
    │
    └── ExcursionCultural (Subclase)
        └── lugarHistorico: String
        └── + mostrarInformacion(): void (sobrescrito)
        └── + toString(): String (sobrescrito)
Ejemplo de Polimorfismo con instanceof
java
for (Registrable entidad : entidades) {
    entidad.mostrarResumen();
    
  if (entidad instanceof Guia) {
        Guia guia = (Guia) entidad;
        System.out.println("   ✅ Guía disponible: " + guia.isDisponible());
    } else if (entidad instanceof Vehiculo) {
        Vehiculo vehiculo = (Vehiculo) entidad;
        System.out.println("   🚗 Capacidad: " + vehiculo.getCapacidadPasajeros());
    }
}
🖥️ Interfaz Gráfica (GUI)
La aplicación cuenta con una interfaz gráfica que permite:

Agregar Guías Turísticos

Agregar Vehículos

Agregar Colaboradores Externos

Mostrar todas las entidades registradas

Ventana Principal
La GUI contiene:

Combo box para seleccionar el tipo de entidad a agregar

Botón Agregar para abrir formularios de ingreso

Botón Mostrar Entidades para listar todos los registros

Área de texto para visualizar la información

Cómo abrir la GUI:
Ejecutar el sistema

Seleccionar la opción 11. Abrir interfaz gráfica

La ventana se abrirá automáticamente

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
9	Ver servicios turísticos
10	Mostrar entidades
11	Abrir interfaz gráfica
12	Salir
Ejemplo de Salida - Opción 10 (Mostrar entidades)
text
╔══════════════════════════════════════════════╗
║        📋 LISTA DE ENTIDADES                ║
║         Llanquihue Tour - Los Lagos         ║
╚══════════════════════════════════════════════╝

📋 Total de entidades: 8

[1]
🧭 GUÍA TURÍSTICO
   Nombre: Pedro Silva
   RUT: 14.141.414-1
   Especialidad: Gastronomía
   Experiencia: 6 años
   Idiomas: Español/Inglés
   Disponible: Sí

   🔍 Especialidad destacada: Gastronomía
   ✅ Guía disponible para asignación inmediata

[2]
🚗 VEHÍCULO
   Patente: AB-12-CD
   Marca: Toyota
   Modelo: Hiace
   Año: 2022
   Capacidad: 15 pasajeros
   Disponible: Sí

   🚗 Vehículo disponible para rutas

✅ Total de entidades procesadas: 8
🚀 Instrucciones de Ejecución
Requisitos
Java JDK 8 o superior

Maven

NetBeans (recomendado)

Desde NetBeans
Abrir el proyecto

Ejecutar LlanquihueTourSystem.java

Seleccionar una opción del menú

Línea de comandos (Maven)
bash
# Limpiar y compilar
mvn clean compile

# Ejecutar
mvn exec:java -Dexec.mainClass="com.mycompany.llanquihuetoursystem.LlanquihueTourSystem"
Desde la GUI directamente
bash
mvn exec:java -Dexec.mainClass="com.mycompany.llanquihuetoursystem.ui.VentanaPrincipal"
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
👤 Autor
Alejandro Serrano

📅 Fecha
Julio 2026

🏫 Asignatura
Desarrollo Orientado a Objetos I

📚 Tecnologías Utilizadas
Java 8+

Maven

POO (Interfaces, Herencia, Polimorfismo, Encapsulamiento, Abstracción)

Colecciones Genéricas (ArrayList, List)

instanceof para validación de tipos

JFrame y JOptionPane para interfaz gráfica

Programación por capas (Modelo - Datos - Servicio - UI)
