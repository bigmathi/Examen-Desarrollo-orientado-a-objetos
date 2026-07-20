package model;

public class ColaboradorExterno extends Persona {
    private String tipoServicio;
    private String empresaOrigen;

    public ColaboradorExterno(String nombre, Rut rut, Direccion direccion, String tipoServicio, String empresaOrigen) {
        super(nombre, rut, direccion);
        this.tipoServicio = tipoServicio;
        this.empresaOrigen = empresaOrigen;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getEmpresaOrigen() {
        return empresaOrigen;
    }

    public void setEmpresaOrigen(String empresaOrigen) {
        this.empresaOrigen = empresaOrigen;
    }

    @Override
    public void registrar() {
        System.out.println("Registrando Colaborador Externo: " + nombre);
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + ", Servicio: " + tipoServicio + ", Empresa: " + empresaOrigen;
    }

    @Override
    public String mostrarResumen() {
        return "Colaborador: " + nombre + " (" + empresaOrigen + ") | Servicio: " + tipoServicio;
    }
}
