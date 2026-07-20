package model;

public abstract class Persona implements Registrable {
    protected String nombre;
    protected Rut rut;
    protected Direccion direccion;

    public Persona(String nombre, Rut rut, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public Rut getRut() {
        return rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public void registrar() {
        System.out.println("Registrando persona: " + nombre);
    }

    @Override
    public String mostrarDatos() {
        String dirString = "N/A";
        if (direccion != null) {
            dirString = direccion.toString();
        }
        return "Nombre: " + nombre + ", RUT: " + rut.getValor() + ", Dirección: [" + dirString + "]";
    }

    @Override
    public String mostrarResumen() {
        return nombre + " (" + rut.getValor() + ")";
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}
