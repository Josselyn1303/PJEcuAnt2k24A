package PJUserInterface;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PJForm extends JFrame {

    private JTable PJtabla;
    private DefaultTableModel PJmodeloTabla;
    private int PJultimoSecuencial = PJobtenerNuevoSecuencial();;
    private JPanel PJcomboButtonPanel;

    public PJForm() {
        PJcustomerControls();
    }

    private void PJcustomerControls() {
        setTitle("EcuAnt 2k24A");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con imagen y título
        JPanel PJtopPanel = new JPanel(new BorderLayout());
        JLabel PJimgLabel = new JLabel(new ImageIcon("src\\PJUserInterface\\PJResource\\Hormiga.png"));
        JLabel PJtitleLabel = new JLabel("Hormiguero Virtual", SwingConstants.CENTER);
        PJtitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        PJtopPanel.add(PJimgLabel, BorderLayout.NORTH);
        PJtopPanel.add(PJtitleLabel, BorderLayout.SOUTH);

        // Tabla
        String[] PJcolumnNames = {"RegisNro", "TipoHormiga", "Ubicación", "Sexo", "IngestaNativa", "GenoAlimento", "Estado"};
        PJmodeloTabla = new DefaultTableModel(PJcolumnNames, 0);
        PJtabla = new JTable(PJmodeloTabla);
        JScrollPane PJscrollPane = new JScrollPane(PJtabla);

        // Panel de combo boxes
        JPanel PJcomboPanel = new JPanel();
        String[] PJgenoOptions = {"X", "XX", "XY"};
        JComboBox<String> PJgenoCombo = new JComboBox<>(PJgenoOptions);

        String[] PJingestaOptions = {"Carnívoro", "Herbívoro", "Omnívoro", "Insectívoro", "Nectarívoros"};
        JComboBox<String> PJingestaCombo = new JComboBox<>(PJingestaOptions);
        PJcomboPanel.add(PJgenoCombo);
        PJcomboPanel.add(PJingestaCombo);

        // Panel de botones
        JPanel PJbuttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton PJcreateButton = new JButton("Crear Larva");
        JButton PJfeedButton = new JButton("Alimentar");
        JButton PJdeleteButton = new JButton("Eliminar");
        JButton PJsaveButton = new JButton("Guardar");
        PJbuttonPanel.add(PJcreateButton);
        PJbuttonPanel.add(PJfeedButton);
        PJbuttonPanel.add(PJdeleteButton);
        PJbuttonPanel.add(PJsaveButton);

        // Panel para combo boxes y botones
        PJcomboButtonPanel = new JPanel(new BorderLayout());
        PJcomboButtonPanel.add(PJcomboPanel, BorderLayout.NORTH);
        PJcomboButtonPanel.add(PJbuttonPanel, BorderLayout.SOUTH);

        // Panel principal
        JPanel PJmainPanel = new JPanel(new BorderLayout());
        PJmainPanel.add(PJscrollPane, BorderLayout.CENTER);
        PJmainPanel.add(PJcomboButtonPanel, BorderLayout.SOUTH);

        // Barra de estado
        JPanel PJstatusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel PJprogramLabel = new JLabel("Programación II");
        JLabel PJcedulaLabel = new JLabel("Cédula: 1727169631");
        JLabel PJnameLabel = new JLabel("Nombres: Josselyn Pozo");

        PJstatusBar.add(PJprogramLabel);
        PJstatusBar.add(new JLabel(" | "));
        PJstatusBar.add(PJcedulaLabel);
        PJstatusBar.add(new JLabel(" | "));
        PJstatusBar.add(PJnameLabel);

        // Añadir componentes al frame
        add(PJtopPanel, BorderLayout.NORTH);
        add(PJmainPanel, BorderLayout.CENTER);
        add(PJstatusBar, BorderLayout.PAGE_END);

        // Acciones de botones
        PJcreateButton.addActionListener(e -> PJcrearHormigaLarva());
        PJfeedButton.addActionListener(e -> PJalimentarConGenoAlimento());
        PJdeleteButton.addActionListener(e -> PJeliminarRegistro());
        PJsaveButton.addActionListener(e -> PJguardarEnArchivo());

        setVisible(true);
    }
    private void PJguardarEnArchivo() {
        File file = new File("PJEcuAnt2k24A\\Data\\PJHormigueroVirtual.txt");
        try {
            // Asegurarse de que el archivo existe
            if (!file.exists()) {
                file.createNewFile(); // Crear el archivo si no existe
            }
    
            // Abrir BufferedWriter en modo append para añadir al final del archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                // Obtener los datos de la tabla y escribir en el archivo
                for (int row = 0; row < PJmodeloTabla.getRowCount(); row++) {
                    StringBuilder line = new StringBuilder();
                    for (int col = 0; col < PJmodeloTabla.getColumnCount(); col++) {
                        Object value = PJmodeloTabla.getValueAt(row, col);
                        if (value != null) {
                            line.append(value.toString());
                        }
                        if (col < PJmodeloTabla.getColumnCount() - 1) {
                            line.append("\t"); // Separador de columnas
                        }
                    }
                    writer.write(line.toString());
                    writer.newLine(); // Nueva línea para el siguiente registro
                }
            }
            JOptionPane.showMessageDialog(this, "Datos guardados exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void PJcrearHormigaLarva() {
    int PJopcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de crear una Hormiga larva?", "Confirmación", JOptionPane.YES_NO_OPTION);
    if (PJopcion == JOptionPane.YES_OPTION) {
        String[] PJprovincias = {"Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos",
                "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza",
                "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora Chinchipe"};
        Random PJrandom = new Random();
        String PJubicacion = PJprovincias[PJrandom.nextInt(PJprovincias.length)];
        String PJhormiga = "larva";
        String PJsexo = "Asexual";
        String PJestado = "VIVA";

        Object[] PJnuevoRegistro = {PJultimoSecuencial, PJhormiga, PJubicacion, PJsexo, null, null, PJestado};
        PJagregarRegistroATabla(PJnuevoRegistro);

    }
    PJultimoSecuencial++;
    }

    private int PJobtenerNuevoSecuencial() {
        int secuencial = 0; // Valor predeterminado en caso de archivo vacío
        File file = new File("PJEcuAnt2k24A\\Data\\PJHormigueroVirtual.txt");
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Solo leer la última línea
                    String[] parts = line.split("\t");
                    if (parts.length > 0) {
                        try {
                            secuencial = Integer.parseInt(parts[0]);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            secuencial++;

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al acceder al archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return secuencial;
    }


    private void PJagregarRegistroATabla(Object[] PJregistro) {
        PJmodeloTabla.addRow(PJregistro);
    }

    private void PJalimentarConGenoAlimento() {
        int PJfilaSeleccionada = PJtabla.getSelectedRow();
        if (PJfilaSeleccionada >= 0) {
            String PJgenoAlimentoSeleccionado = (String) ((JComboBox<String>) PJcomboButtonPanel.getComponent(0)).getSelectedItem();
            String PJestado = (String) PJmodeloTabla.getValueAt(PJfilaSeleccionada, 6);

            if ("XY".equals(PJgenoAlimentoSeleccionado) && "VIVA".equals(PJestado)) {
                PJmodeloTabla.setValueAt("Zángano", PJfilaSeleccionada, 1);
                PJmodeloTabla.setValueAt("Macho", PJfilaSeleccionada, 3);
                PJmodeloTabla.setValueAt(PJgenoAlimentoSeleccionado, PJfilaSeleccionada, 5);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void PJeliminarRegistro() {
        int PJfilaSeleccionada = PJtabla.getSelectedRow();
        if (PJfilaSeleccionada >= 0) {
            String PJtipoHormiga = (String) PJtabla.getValueAt(PJfilaSeleccionada, 1);

            int PJopcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar la " + PJtipoHormiga + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (PJopcion == JOptionPane.YES_OPTION) {
                PJmodeloTabla.removeRow(PJfilaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PJForm::new);
    }
}
