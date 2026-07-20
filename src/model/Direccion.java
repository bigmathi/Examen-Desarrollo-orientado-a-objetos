package model;

public class Direccion {
    private String calle;
    private String numero;
    private String comuna;
    private String ciudad;

    public Direccion(String calle, String numero, String comuna, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
        this.ciudad = ciudad;
    }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getComuna() { return comuna; }
    public void setComuna(String comuna) { this.comuna = comuna; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    @Override
    public String toString() {
        return calle + " " + numero + ", " + comuna + ", " + ciudad;
    }
}
