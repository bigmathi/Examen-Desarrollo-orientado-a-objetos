package model;

public class Tarjeta {
    private String numero;
    private String banco;
    private String tipo; // Credito o Debito

    public Tarjeta(String numero, String banco, String tipo) {
        this.numero = numero;
        this.banco = banco;
        this.tipo = tipo;
    }

    public String getNumero() { return numero; }
    public String getBanco() { return banco; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return tipo + " " + banco + " (" + numero + ")";
    }
}
