package ui;

import javax.swing.JOptionPane;
import model.*;
import utils.RutInvalidoException;
import data.GestorEntidades;
import java.util.ArrayList;

public class MainGUI {

    public static void main(String[] args) {
        GestorEntidades gestor = new GestorEntidades();
        
        // Cargar datos al iniciar
        cargarDatos(gestor);

        int opcion = 0;

        do {
            String menu = "=== Llanquihue Tours ===\n"
                    + "1. Crear Reserva\n"
                    + "2. Crear Cliente\n"
                    + "3. Gestión Interna (Personal, Vehículos, Tours)\n"
                    + "4. Mostrar Resumen del Sistema\n"
                    + "5. Buscar Persona por RUT\n"
                    + "6. Salir y Guardar\n\n"
                    + "Seleccione una opción:";


            String entrada = JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null) {
                break;
            }

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcion) {
                case 1: //opcion 1 Crear reserva
                    try {
                        String rutCliente = JOptionPane.showInputDialog("Ingrese RUT del Cliente para la reserva:");
                        Persona p = gestor.buscarPersonaPorRut(rutCliente);
                        if (p == null || !(p instanceof Cliente)) {
                            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                            break;
                        }
                        
                        String nombreTour = JOptionPane.showInputDialog("Nombre del Tour a reservar:");
                        Tour tour = gestor.buscarTourPorNombre(nombreTour);
                        if (tour == null) {
                            JOptionPane.showMessageDialog(null, "Tour no encontrado.");
                            break;
                        }

                        String numTarjeta = JOptionPane.showInputDialog("Número de Tarjeta:");
                        String bancoTarjeta = JOptionPane.showInputDialog("Banco de la Tarjeta:");
                        String tipoTarjeta = JOptionPane.showInputDialog("Tipo de Tarjeta (ej. Débito, Crédito):");
                        Tarjeta t = new Tarjeta(numTarjeta, bancoTarjeta, tipoTarjeta);
                        
                        String fecha = JOptionPane.showInputDialog("Fecha de la reserva (ej. 19/07/2026):");
                        Reserva reserva = new Reserva((Cliente) p, t, fecha);
                        reserva.agregarTour(tour);
                        gestor.agregarEntidad(reserva);
                        JOptionPane.showMessageDialog(null, "Reserva creada con éxito:\n" + reserva.mostrarResumen());
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al crear reserva.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 2: //crea cliente
                    try {
                        String nombre = JOptionPane.showInputDialog("Nombre del Cliente:");
                        if (nombre == null) break;
                        
                        String rutStr = JOptionPane.showInputDialog("RUT (ej. 12345678-9):");
                        Rut rut = new Rut(rutStr); 
                        
                        String calle = JOptionPane.showInputDialog("Calle de la dirección:");
                        String numero = JOptionPane.showInputDialog("Número:");
                        String ciudad = JOptionPane.showInputDialog("Ciudad:");
                        String comuna = JOptionPane.showInputDialog("Comuna:");
                        Direccion dir = new Direccion(calle, numero, ciudad, comuna);
                        String nacionalidad = JOptionPane.showInputDialog("Nacionalidad:");
                        Cliente c = new Cliente(nombre, rut, dir, nacionalidad);
                        gestor.agregarEntidad(c);
                        JOptionPane.showMessageDialog(null, "Cliente " + nombre + " registrado.");
                    } catch (RutInvalidoException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error en los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3: // gestion Interna para crear datos internos y modificarlos
                    int opcInterna = 0;
                    do {
                        String menuInterno = "=== Gestión Interna ===\n"
                                + "1. Gestión de Personal (Guías, Colaboradores)\n"
                                + "2. Gestión de Vehículos\n"
                                + "3. Gestión de Tours\n"
                                + "4. Modificar Datos\n"
                                + "5. Volver\n";
                        String entI = JOptionPane.showInputDialog(null, menuInterno, "Gestión Interna", JOptionPane.QUESTION_MESSAGE);
                        
                        if (entI == null) break;

                        try {
                            opcInterna = Integer.parseInt(entI);
                            if (opcInterna == 5) break;
                            switch (opcInterna) {
                                case 1:
                                    int opcPersonal = 0;
                                    do {
                                        String menuPersonal = "=== Gestión de Personal ===\n"
                                                + "1. Ingresar Guía Turístico\n"
                                                + "2. Ingresar Colaborador Externo\n"
                                                + "3. Volver\n";
                                        String entP = JOptionPane.showInputDialog(null, menuPersonal, "Personal", JOptionPane.QUESTION_MESSAGE);
                                        if (entP == null) break;

                                        opcPersonal = Integer.parseInt(entP);
                                        if (opcPersonal == 3) break;

                                        String nombreP = JOptionPane.showInputDialog("Nombre:");
                                        if (nombreP == null) break;
                                        
                                        String rutStrP = JOptionPane.showInputDialog("RUT (ej. 12345678-9):");
                                        Rut rutP = new Rut(rutStrP); 
                                        String calle = JOptionPane.showInputDialog("Calle de la dirección:");
                                        String numero = JOptionPane.showInputDialog("Número:");
                                        String ciudad = JOptionPane.showInputDialog("Ciudad:");
                                        String comuna = JOptionPane.showInputDialog("Comuna:");
                                        Direccion dirP = new Direccion(calle, numero, ciudad, comuna);

                                        if (opcPersonal == 1) {
                                            String idioma = JOptionPane.showInputDialog("Idiomas:");
                                            String expStr = JOptionPane.showInputDialog("Años de experiencia:");
                                            int exp = Integer.parseInt(expStr);
                                            GuiaTuristico g = new GuiaTuristico(nombreP, rutP, dirP, idioma, exp);
                                            gestor.agregarEntidad(g);
                                            JOptionPane.showMessageDialog(null, "Guía " + nombreP + " registrado.");
                                        } else if (opcPersonal == 2) {
                                            String empresa = JOptionPane.showInputDialog("Empresa Origen:");
                                            String servicio = JOptionPane.showInputDialog("Servicio Ofrecido:");
                                            ColaboradorExterno ce = new ColaboradorExterno(nombreP, rutP, dirP, servicio, empresa);
                                            gestor.agregarEntidad(ce);
                                            JOptionPane.showMessageDialog(null, "Colaborador " + nombreP + " registrado.");
                                        }
                                    } while (opcPersonal != 3);
                                    break;

                                case 2:
                                    String tipo = JOptionPane.showInputDialog("Tipo (ej. Van, Bus):");
                                    if (tipo == null) break;
                                    String patente = JOptionPane.showInputDialog("Patente:");
                                    String capStr = JOptionPane.showInputDialog("Capacidad:");
                                    int cap = Integer.parseInt(capStr);
                                    Vehiculo v = new Vehiculo(patente, cap, tipo);
                                    gestor.agregarEntidad(v);
                                    JOptionPane.showMessageDialog(null, "Vehículo registrado.");
                                    break;

                                case 3:
                                    String nombreT = JOptionPane.showInputDialog("Nombre del Tour:");
                                    if (nombreT == null) break;
                                    String desc = JOptionPane.showInputDialog("Descripción:");
                                    String precStr = JOptionPane.showInputDialog("Precio:");
                                    int precio = Integer.parseInt(precStr);
                                    Tour pt = new Tour(nombreT, desc, precio);
                                    gestor.agregarEntidad(pt);
                                    JOptionPane.showMessageDialog(null, "Tour registrado.");
                                    break;
                                    
                                case 4:
                                    int opcModificar = 0;
                                    do {
                                        String menuModificar = "=== Modificar Datos ===\n"
                                                + "1. Modificar Personal\n"
                                                + "2. Modificar Vehículo\n"
                                                + "3. Modificar Tour\n"
                                                + "4. Volver\n";
                                        String entM = JOptionPane.showInputDialog(null, menuModificar, "Modificar", JOptionPane.QUESTION_MESSAGE);
                                        if (entM == null) break;
                                        
                                        opcModificar = Integer.parseInt(entM);
                                        if (opcModificar == 4) break;
                                        
                                        if (opcModificar == 1) {
                                            String rutMod = JOptionPane.showInputDialog("RUT del Personal a modificar:");
                                            Persona per = gestor.buscarPersonaPorRut(rutMod);
                                            if (per != null) {
                                                if (per instanceof GuiaTuristico) {
                                                    GuiaTuristico g = (GuiaTuristico) per;
                                                    String nuevoIdioma = JOptionPane.showInputDialog("Nuevos idiomas (actual: " + g.getIdiomas() + "):");
                                                    String nuevaExp = JOptionPane.showInputDialog("Nueva experiencia (actual: " + g.getAniosExperiencia() + "):");
                                                    if (nuevoIdioma != null && !nuevoIdioma.isEmpty()) g.setIdiomas(nuevoIdioma);
                                                    if (nuevaExp != null && !nuevaExp.isEmpty()) g.setAniosExperiencia(Integer.parseInt(nuevaExp));
                                                    JOptionPane.showMessageDialog(null, "Guía modificado.");
                                                } else if (per instanceof ColaboradorExterno) {
                                                    ColaboradorExterno ce = (ColaboradorExterno) per;
                                                    String nuevoServ = JOptionPane.showInputDialog("Nuevo servicio (actual: " + ce.getTipoServicio() + "):");
                                                    String nuevaEmpresa = JOptionPane.showInputDialog("Nueva empresa (actual: " + ce.getEmpresaOrigen() + "):");
                                                    if (nuevoServ != null && !nuevoServ.isEmpty()) ce.setTipoServicio(nuevoServ);
                                                    if (nuevaEmpresa != null && !nuevaEmpresa.isEmpty()) ce.setEmpresaOrigen(nuevaEmpresa);
                                                    JOptionPane.showMessageDialog(null, "Colaborador modificado.");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "El RUT corresponde a un Cliente, no a Personal.");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Persona no encontrada.");
                                            }
                                        } else if (opcModificar == 2) {
                                            String patenteMod = JOptionPane.showInputDialog("Patente del Vehículo a modificar:");
                                            Vehiculo vMod = null;
                                            for (Registrable r : gestor.getLista()) {
                                                if (r instanceof Vehiculo) {
                                                    Vehiculo veh = (Vehiculo) r;
                                                    if (veh.getPatente().equalsIgnoreCase(patenteMod)) {
                                                        vMod = veh; break;
                                                    }
                                                }
                                            }
                                            if (vMod != null) {
                                                String nuevoTipo = JOptionPane.showInputDialog("Nuevo tipo (actual: " + vMod.getTipo() + "):");
                                                String nuevaCap = JOptionPane.showInputDialog("Nueva capacidad (actual: " + vMod.getCapacidadPasajeros() + "):");
                                                if (nuevoTipo != null && !nuevoTipo.isEmpty()) vMod.setTipo(nuevoTipo);
                                                if (nuevaCap != null && !nuevaCap.isEmpty()) vMod.setCapacidadPasajeros(Integer.parseInt(nuevaCap));
                                                JOptionPane.showMessageDialog(null, "Vehículo modificado.");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                                            }
                                        } else if (opcModificar == 3) {
                                            String nomT = JOptionPane.showInputDialog("Nombre del Tour a modificar:");
                                            Tour pMod = gestor.buscarTourPorNombre(nomT);
                                            if (pMod != null) {
                                                String nuevaDesc = JOptionPane.showInputDialog("Nueva descripción (actual: " + pMod.getDescripcion() + "):");
                                                String nuevoPrec = JOptionPane.showInputDialog("Nuevo precio (actual: " + pMod.getPrecio() + "):");
                                                if (nuevaDesc != null && !nuevaDesc.isEmpty()) pMod.setDescripcion(nuevaDesc);
                                                if (nuevoPrec != null && !nuevoPrec.isEmpty()) pMod.setPrecio(Integer.parseInt(nuevoPrec));
                                                JOptionPane.showMessageDialog(null, "Tour modificado.");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Tour no encontrado.");
                                            }
                                        }
                                    } while (opcModificar != 4);
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                            }

                        } catch (RutInvalidoException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error en los datos ingresados.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (opcInterna != 5);
                    break;

                case 4:
                    String reporte = gestor.generarReporte();
                    javax.swing.JTextArea textArea = new javax.swing.JTextArea(reporte);
                    textArea.setEditable(false);
                    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);
                    scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, "Resumen del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 5:
                    String rut = JOptionPane.showInputDialog("Ingrese RUT a buscar:");
                    if (rut == null) break;
                    Persona per = gestor.buscarPersonaPorRut(rut);
                    if (per != null) {
                        JOptionPane.showMessageDialog(null, "Encontrado:\n" + per.mostrarDatos());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con ese RUT.");
                    }
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Datos guardados. Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 6);

        // Guardar datos incondicionalmente al salir del bucle (sea por opción 6 o por cancelar el menú)
        guardarDatos(gestor);
    }
    
    private static void cargarDatos(GestorEntidades gestor) {
        // Cargar Personas (Clientes, Guías, Colaboradores)
        ArrayList<String[]> datosPersonas = data.EditorArchivos.leerArchivoTexto("personas.txt", ";");
        for (String[] d : datosPersonas) {
            if (d.length >= 7) {
                try {
                    String tipo = d[0];
                    String nombre = d[1];
                    Rut rut = new Rut(d[2]);
                    Direccion dir = new Direccion(d[3], d[4], d[5], d[6]);
                    
                    if (tipo.equals("Cliente")) {
                        String nacionalidad = "Chilena";
                        if (d.length >= 8) {
                            nacionalidad = d[7];
                        }
                        Cliente c = new Cliente(nombre, rut, dir, nacionalidad);
                        gestor.agregarEntidad(c);
                    } else if (tipo.equals("GuiaTuristico") && d.length >= 9) {
                        String idiomas = d[7];
                        int exp = Integer.parseInt(d[8]);
                        GuiaTuristico g = new GuiaTuristico(nombre, rut, dir, idiomas, exp);
                        gestor.agregarEntidad(g);
                    } else if (tipo.equals("ColaboradorExterno") && d.length >= 9) {
                        String servicio = d[7];
                        String empresa = d[8];
                        ColaboradorExterno ce = new ColaboradorExterno(nombre, rut, dir, servicio, empresa);
                        gestor.agregarEntidad(ce);
                    }
                } catch (Exception e) { /* Ignorar errores de linea */ }
            }
        }

        // Cargar Vehiculos
        ArrayList<String[]> datosVehiculos = data.EditorArchivos.leerArchivoTexto("vehiculos.txt", ";");
        for (String[] d : datosVehiculos) {
            if (d.length >= 3) {
                try {
                    Vehiculo v = new Vehiculo(d[0], Integer.parseInt(d[1]), d[2]);
                    gestor.agregarEntidad(v);
                } catch (Exception e) {}
            }
        }

        // Cargar Tours
        ArrayList<String[]> datosTours = data.EditorArchivos.leerArchivoTexto("tours.txt", ";");
        for (String[] d : datosTours) {
            if (d.length >= 3) {
                try {
                    Tour p = new Tour(d[0], d[1], Integer.parseInt(d[2]));
                    gestor.agregarEntidad(p);
                } catch (Exception e) {}
            }
        }
    }

    private static void guardarDatos(GestorEntidades gestor) {//ingreso de datos a los archivos .txt
        ArrayList<String> lineasPersonas = new ArrayList<>();
        ArrayList<String> lineasVehiculos = new ArrayList<>();
        ArrayList<String> lineasTours = new ArrayList<>();

        for (Registrable r : gestor.getLista()) {
            if (r instanceof Persona) {
                Persona p = (Persona) r;
                String base = p.getNombre() + ";" + p.getRut().getValor() + ";" 
                            + p.getDireccion().getCalle() + ";" + p.getDireccion().getNumero() + ";" 
                            + p.getDireccion().getCiudad() + ";" + p.getDireccion().getComuna();
                
                if (p instanceof Cliente) {
                    Cliente c = (Cliente) p;
                    lineasPersonas.add("Cliente;" + base + ";" + c.getNacionalidad());
                } else if (p instanceof GuiaTuristico) {
                    GuiaTuristico g = (GuiaTuristico) p;
                    lineasPersonas.add("GuiaTuristico;" + base + ";" + g.getIdiomas() + ";" + g.getAniosExperiencia());
                } else if (p instanceof ColaboradorExterno) {
                    ColaboradorExterno ce = (ColaboradorExterno) p;
                    lineasPersonas.add("ColaboradorExterno;" + base + ";" + ce.getTipoServicio() + ";" + ce.getEmpresaOrigen());
                }
            } else if (r instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) r;
                lineasVehiculos.add(v.getPatente() + ";" + v.getCapacidadPasajeros() + ";" + v.getTipo());
            } else if (r instanceof Tour) {
                Tour p = (Tour) r;
                lineasTours.add(p.getNombreTour() + ";" + p.getDescripcion() + ";" + p.getPrecio());
            }
        }

        data.EditorArchivos.guardarArchivoTexto("personas.txt", lineasPersonas);
        data.EditorArchivos.guardarArchivoTexto("vehiculos.txt", lineasVehiculos);
        data.EditorArchivos.guardarArchivoTexto("tours.txt", lineasTours);
    }
}

