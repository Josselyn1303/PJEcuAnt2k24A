package PJDataAccess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PJHormigaDAO {

    private static final String FILE_PATH = "PJEcuAnt2k24A\\Data\\PJHormigueroVirtual.txt";

    // Leer todos los registros del archivo
    public static List<PJHormigaDTO> readAll() {
        List<PJHormigaDTO> hormigas = new ArrayList<>();
        File file = new File(FILE_PATH);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 7) {
                    int secuencial = Integer.parseInt(parts[0]);
                    String tipoHormiga = parts[1];
                    String ubicacion = parts[2];
                    String sexo = parts[3];
                    String ingestaNativa = parts[4];
                    String genoAlimento = parts[5];
                    String estado = parts[6];
                    PJHormigaDTO hormiga = new PJHormigaDTO(secuencial, tipoHormiga, ubicacion, sexo, ingestaNativa, genoAlimento, estado);
                    hormigas.add(hormiga);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }

        return hormigas;
    }

    // Escribir un nuevo registro en el archivo
    public void save(PJHormigaDTO hormiga) {
        File file = new File(FILE_PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(hormiga.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }
    }

    // Obtener el último número secuencial del archivo
    public int getLastSecuencial() {
        int lastSecuencial = 0;
        File file = new File(FILE_PATH);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length > 0) {
                    try {
                        lastSecuencial = Integer.parseInt(parts[0]);
                    } catch (NumberFormatException e) {
                        // Manejar el caso donde la línea no comienza con un número
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
        }

        return lastSecuencial;
    }
}