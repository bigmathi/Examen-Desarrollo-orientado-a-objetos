package data;

import java.io.*;
import java.util.ArrayList;

public class EditorArchivos {

    public static ArrayList<String[]> leerArchivoTexto(String ruta, String separador) {
        ArrayList<String[]> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if(linea.trim().isEmpty()) continue;
                lineas.add(linea.split(separador));
            }
        } catch (IOException e) {
            // Ignorar error si el archivo no existe aún (primera ejecución)
        }
        return lineas;
    }

    public static void guardarArchivoTexto(String ruta, ArrayList<String> lineas) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            for (String linea : lineas) {
                pw.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivo: " + e.getMessage());
        }
    }
}
