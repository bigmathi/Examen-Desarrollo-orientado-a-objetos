package model;

import utils.RutInvalidoException;

public class Rut {
    private String valor;

    public Rut(String rut) throws RutInvalidoException {
        if (!validar(rut)) {
            throw new RutInvalidoException("El RUT ingresado no es válido: " + rut);
        }
        this.valor = rut;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) throws RutInvalidoException {
        if (!validar(valor)) {
            throw new RutInvalidoException("El RUT ingresado no es válido: " + valor);
        }
        this.valor = valor;
    }

    private boolean validar(String rut) {
        // Validación simplificada: que no sea nulo, no esté vacío y contenga guión.

        if (rut == null || rut.trim().isEmpty()) {
            return false;
        }
        return rut.contains("-");
    }

    @Override
    public String toString() {
        return valor;
    }
}
