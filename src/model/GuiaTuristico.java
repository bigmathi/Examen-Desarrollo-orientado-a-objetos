package model;

public class GuiaTuristico extends Persona {
    private String idiomas;
    private int aniosExperiencia;

    public GuiaTuristico(String nombre, Rut rut, Direccion direccion, String idiomas, int aniosExperiencia) {
        super(nombre, rut, direccion);
        this.idiomas = idiomas;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public void registrar() {
        System.out.println("Registrando Guía Turístico: " + nombre);
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + ", Idiomas: " + idiomas + ", Experiencia: " + aniosExperiencia + " años";
    }

    @Override
    public String mostrarResumen() {
        return "Guía Turístico: " + nombre + " | RUT: " + rut.getValor() + " | Idiomas: " + idiomas + " | Experiencia: " + aniosExperiencia + " años";
    }
}
