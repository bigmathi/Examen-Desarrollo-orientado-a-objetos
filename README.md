(https://github.com/user-attachments/files/30174331/README.md)<h1 align="center">Llanquihue Tour App 🏔️🚌</h1>

<p align="center">
  <em>Aplicación de escritorio en Java para la gestión de recursos turísticos</em>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge" alt="Swing GUI" />
  <img src="https://img.shields.io/badge/POO-Concepts-brightgreen?style=for-the-badge" alt="POO" />
</p>

---

## 📖 Descripción del Proyecto

**Llanquihue Tour App** es una aplicación orientada a objetos construida en Java. Su objetivo es proporcionar una herramienta sencilla y efectiva para una agencia de turismo, permitiendo registrar y administrar sus guías turísticos, vehículos de la flota y colaboradores externos. La interacción se realiza de manera amigable mediante ventanas emergentes utilizando la biblioteca de interfaz gráfica `JOptionPane` de Java Swing.

## ✨ Características Principales

El menú interactivo de la aplicación permite:

- 👤 **Registrar Guías Turísticos**: Almacena información clave como nombre, RUT, idiomas que manejan y años de experiencia en el rubro.
- 🚐 **Registrar Vehículos**: Gestiona la flota ingresando el tipo de vehículo (van, bus, etc.), la patente y su capacidad de pasajeros.
- 🤝 **Registrar Colaboradores Externos**: Añade colaboradores especificando su nombre, RUT, empresa de la que provienen y el servicio específico que prestan.
- 📊 **Generar Reportes**: Muestra un listado consolidado de todas las entidades y recursos registrados durante la sesión.

## 🏗️ Arquitectura y Estructura

El sistema está desarrollado aplicando fuertemente conceptos de **Programación Orientada a Objetos (POO)** como herencia, polimorfismo y encapsulamiento. Está organizado en tres paquetes principales para separar las responsabilidades:

- 📂 `Model/`: Contiene las clases de dominio que representan las entidades del negocio (Ej. clases base como `Persona` y clases específicas como `GuiaTuristico`, `ColaboradorExterno`, `Vehiculo`). También incluye interfaces como `Registrable`.
- 📂 `Data/`: Incluye la clase `GestorEntidades`, encargada del almacenamiento y la lógica para manejar las colecciones de datos en tiempo de ejecución.
- 📂 `UI/`: Aquí reside la clase `main` (MainGUI), que funciona como punto de entrada de la aplicación y maneja toda la interacción con el usuario.

## 🚀 Instalación y Ejecución

### Requisitos Previos

- [Java JDK 8 o superior](https://www.oracle.com/java/technologies/downloads/) instalado en tu equipo.

### Pasos para ejecutar

1. **Clona el repositorio** a tu máquina local:
   ```bash
   git clone https://github.com/tu-usuario/LlanquihueTourApp.git
   cd LlanquihueTourApp
   ```

2. **Compila el proyecto** ubicándote en la raíz del proyecto (creará los binarios en la carpeta `bin`):
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Ejecuta la aplicación**:
   ```bash
   java -cp bin UI.main
   ```

## 🛠️ Tecnologías Utilizadas

- **Lenguaje Base:** Java
- **Interfaz Gráfica:** Java Swing (Uso extensivo de `JOptionPane`)
- **Paradigma:** Programación Orientada a Objetos (POO)

---

<p align="center">
  <i>Desarrollado para el proyecto de Gestión de Agencia Llanquihue Tours.</i>
</p>
