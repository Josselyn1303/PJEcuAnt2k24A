package PJInfra;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PJAppException extends Exception {
    
    // Constructor que recibe un mensaje de error
    public PJAppException(String message) {
        super(message);
        pjlogErrorToFile(message, "", "");
    }

    // Constructor que recibe una excepción, nombre de clase y método
    public PJAppException(Exception e, String clase, String metodo) {
        super("UPS...! Hormiguero sin control...");
        pjlogErrorToFile(e.getMessage(), clase, metodo);
    }

    // Método privado para registrar errores en un archivo
    private void pjlogErrorToFile(String message, String clase, String metodo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PJConfiguration.LOGFILE, true))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            System.out.println("PJAppException - " + clase + "." + metodo + ": " + message);
            writer.println(now.format(formatter) + " - " + clase + "." + metodo + ": " + message);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("PJAppException - " + clase + "." + metodo + ": " + message);
        }
    }
}