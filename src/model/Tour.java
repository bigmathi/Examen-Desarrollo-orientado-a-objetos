package model;

public class Tour implements Registrable {
    private String nombreTour;
    private String descripcion;
    private int precio;

    public Tour(String nombreTour, String descripcion, int precio) {
        this.nombreTour = nombreTour;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombreTour() { return nombreTour; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public void registrar() {
        System.out.println("Registrando Tour: " + nombreTour);
    }

    @Override
    public String mostrarDatos() {
        return "Tour: " + nombreTour + ", Precio: $" + precio + ", Descripción: " + descripcion;
    }

    @Override
    public String mostrarResumen() {
        return "Tour: " + nombreTour + " ($" + precio + ")";
    }
}
