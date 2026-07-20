package model;

public class Vehiculo implements Registrable {
    private String patente;
    private int capacidadPasajeros;
    private String tipo;

    public Vehiculo(String patente, int capacidadPasajeros, String tipo) {
        this.patente = patente;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tipo = tipo;
    }

    public String getPatente() { return patente; }
    public int getCapacidadPasajeros() { return capacidadPasajeros; }
    public void setCapacidadPasajeros(int capacidadPasajeros) { this.capacidadPasajeros = capacidadPasajeros; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public void registrar() {
        System.out.println("Registrando Vehículo: " + patente);
    }

    @Override
    public String mostrarDatos() {
        return "Vehículo: " + tipo + ", Patente: " + patente + ", Capacidad: " + capacidadPasajeros;
    }

    @Override
    public String mostrarResumen() {
        return "Vehículo: " + tipo + " | Patente: " + patente + " | Capacidad: " + capacidadPasajeros + " pasajeros";
    }
}
