/*package PJDataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PJHormigueroDAC {
    int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private static final String FILE_PATH = "Data\\PJhormiguero.csv";

    public static List<Hormiga> readAll() {
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
    
}
*/