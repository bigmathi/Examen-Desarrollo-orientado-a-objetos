package model;

public class Cliente extends Persona {
    private String nacionalidad;

    public Cliente(String nombre, Rut rut, Direccion direccion, String nacionalidad) {
        super(nombre, rut, direccion);
        this.nacionalidad = nacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public void registrar() {
        System.out.println("Registrando Cliente en la base de datos...");
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + ", Nacionalidad: " + nacionalidad;
    }
}
