package model;

import java.util.ArrayList;

public class Reserva implements Registrable {
    private static int contadorId = 1;
    private String idReserva;
    private Cliente cliente;
    private ArrayList<Tour> tours;
    private Tarjeta medioPago;
    private String fecha;

    public Reserva(Cliente cliente, Tarjeta medioPago, String fecha) {
        this.idReserva = String.format("%02d", contadorId++);
        this.cliente = cliente;
        this.medioPago = medioPago;
        this.fecha = fecha;
        this.tours = new ArrayList<>();
    }

    public void agregarTour(Tour tour) {
        this.tours.add(tour);
    }

    public int calcularTotal() {
        int total = 0;
        for (Tour t : tours) {
            total += t.getPrecio();
        }
        return total;
    }

    @Override
    public void registrar() {
        System.out.println("Procesando Reserva #" + idReserva);
    }

    @Override
    public String mostrarDatos() {
        return "Reserva #" + idReserva + " | Fecha: " + fecha + " | Cliente: " + cliente.getNombre() + " | Total: $" + calcularTotal() + " | Pago: " + medioPago.toString();
    }

    @Override
    public String mostrarResumen() {
        String nombresTours = "";
        for (int i = 0; i < tours.size(); i++) {
            nombresTours += tours.get(i).getNombreTour();
            if (i < tours.size() - 1) {
                nombresTours += ", ";
            }
        }
        return "Reserva #" + idReserva + " | Cliente: " + cliente.getNombre() + " | Tour: " + (nombresTours.isEmpty() ? "Ninguno" : nombresTours) + " | Fecha: " + fecha + " | Total: $" + calcularTotal();
    }
}
