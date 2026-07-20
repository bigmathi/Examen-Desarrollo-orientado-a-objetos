package data;

import model.Registrable;
import model.Persona;
import model.Cliente;
import model.GuiaTuristico;
import model.Vehiculo;
import model.ColaboradorExterno;
import model.Tour;
import model.Reserva;
import java.util.ArrayList;

public class GestorEntidades {
    private ArrayList<Registrable> entidades;

    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable entidad) {
        entidad.registrar();
        entidades.add(entidad);
    }

    public Persona buscarPersonaPorRut(String rutStr) {
        for (Registrable e : entidades) {
            if (e instanceof Persona) {
                Persona p = (Persona) e;
                if (p.getRut().getValor().equals(rutStr)) {
                    return p;
                }
            }
        }
        return null;
    }

    public Tour buscarTourPorNombre(String nombre) {
        for (Registrable e : entidades) {
            if (e instanceof Tour) {
                Tour p = (Tour) e;
                if (p.getNombreTour().equalsIgnoreCase(nombre)) {
                    return p;
                }
            }
        }
        return null;
    }

    public String generarReporte() {
        if (entidades.isEmpty()) {
            return "No hay entidades registradas en el sistema.";
        }

        StringBuilder reporte = new StringBuilder("=== Resumen de Entidades ===\n\n");
        int countClientes = 0;
        int countGuias = 0;
        int countVehiculos = 0;
        int countColaboradores = 0;
        int countProductos = 0;
        int countReservas = 0;

        for (Registrable entidad : entidades) {
            reporte.append("- ").append(entidad.mostrarResumen()).append("\n");

            if (entidad instanceof Cliente) countClientes++;
            else if (entidad instanceof GuiaTuristico) countGuias++;
            else if (entidad instanceof Vehiculo) countVehiculos++;
            else if (entidad instanceof ColaboradorExterno) countColaboradores++;
            else if (entidad instanceof Tour) countProductos++;
            else if (entidad instanceof Reserva) countReservas++;
        }

        reporte.append("\n=== Totalizaciones ===\n")
               .append("Clientes: ").append(countClientes).append("\n")
               .append("Guías: ").append(countGuias).append("\n")
               .append("Colaboradores: ").append(countColaboradores).append("\n")
               .append("Vehículos: ").append(countVehiculos).append("\n")
               .append("Tours (Productos): ").append(countProductos).append("\n")
               .append("Reservas: ").append(countReservas);

        return reporte.toString();
    }

    public ArrayList<Registrable> getLista() {
        return entidades;
    }
}

