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
        JLabel PJimgLabel = new JLabel(new ImageIcon("src\\PJUserInterface\\PJResource\\PJHormiga2.png"));
        JLabel PJtitleLabel = new JLabel("Hormiguero Virtual", SwingConstants.CENTER);
        PJtitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        PJtopPanel.add(PJimgLabel, BorderLayout.NORTH);
        PJtopPanel.add(PJtitleLabel, BorderLayout.SOUTH);

        // Tabla
        String[] PJcolumnNames = {"RegisNro", "TipoHormiga", "Sexo", "IngestaNativa", "GenoAlimento", "Estado"};
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
        PJfeedButton.addActionListener(e -> PJalimentarHormiga());
        PJdeleteButton.addActionListener(e -> PJeliminarRegistro());
        PJsaveButton.addActionListener(e -> PJguardarEnArchivo());

        setVisible(true);
    }
    private void PJguardarEnArchivo() {
        File file = new File("Data\\PJhormiguero.csv");
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
            JOptionPane.showMessageDialog(this, "HORMIGUERO respaldado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void PJcrearHormigaLarva() {
        int PJopcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de crear una Hormiga larva?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (PJopcion == JOptionPane.YES_OPTION) {
            String PJhormiga = "larva";
            String PJsexo = "Asexual";
            String PJestado = "VIVA";
            Object[] PJnuevoRegistro = {PJultimoSecuencial, PJhormiga, PJsexo, null, null, PJestado};
            PJagregarRegistroATabla(PJnuevoRegistro);
            PJultimoSecuencial++;
            JOptionPane.showMessageDialog(this, "HORMIGA LARVA, agregada al hormiguero", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private int PJobtenerNuevoSecuencial() {
        int secuencial = 0; // Valor predeterminado en caso de archivo vacío
        File file = new File("Data\\PJhormiguero.csv");
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

    private void PJalimentarHormiga() {
        try {
            int PJfilaSeleccionada = PJtabla.getSelectedRow();
            if (PJfilaSeleccionada >= 0) {
                // Obtener los JComboBox desde PJcomboButtonPanel
                JComboBox<String> ingestaCombo = (JComboBox<String>) ((JPanel) PJcomboButtonPanel.getComponent(0)).getComponent(1);
                JComboBox<String> genoCombo = (JComboBox<String>) ((JPanel) PJcomboButtonPanel.getComponent(0)).getComponent(0);
    
                String PJtipoHormiga = (String) PJmodeloTabla.getValueAt(PJfilaSeleccionada, 1);
                String PJingestaNativa = (String) ingestaCombo.getSelectedItem();
                String PJgenoAlimentoSeleccionado = (String) genoCombo.getSelectedItem();
                String PJestado = (String) PJmodeloTabla.getValueAt(PJfilaSeleccionada, 5);
    
                boolean alimentada = false;
    
                // Verificar y actualizar el estado de la hormiga
                if ("larva".equals(PJtipoHormiga)) {
                    if ("Nectarívoros".equals(PJingestaNativa)) {
                        // La larva sigue viva si se alimenta con Nectarívoros
                        PJestado = "VIVA";
                        alimentada = true;
                    } else if (("Omnívoro".equals(PJingestaNativa) || "Herbívoro".equals(PJingestaNativa) || "Carnívoro".equals(PJingestaNativa)) && "XY".equals(PJgenoAlimentoSeleccionado)) {
                        // La larva evoluciona a Zángano si se alimenta con Omnívoro, Herbívoro o Carnívoro y GenoAlimento es XY
                        PJtipoHormiga = "Zángano";
                        PJestado = "VIVA"; // Se mantiene viva después de la evolución
                        PJmodeloTabla.setValueAt("Macho", PJfilaSeleccionada, 2); // Actualizar sexo a Macho
                        alimentada = true;
                    } else {
                        // La larva muere si no se cumplen las condiciones anteriores
                        PJestado = "Muerta";
                    }
                } else {
                    // Si la hormiga no es larva, no se permite la alimentación
                    PJestado = "Muerta";
                }
    
                // Actualizar los valores en la grilla
                PJmodeloTabla.setValueAt(PJestado, PJfilaSeleccionada, 5); // Actualizar estado
                PJmodeloTabla.setValueAt(PJtipoHormiga, PJfilaSeleccionada, 1); // Actualizar tipo de hormiga
                PJmodeloTabla.setValueAt(PJgenoAlimentoSeleccionado, PJfilaSeleccionada, 4); // Inyectar GenoAlimento
                PJmodeloTabla.setValueAt(PJingestaNativa, PJfilaSeleccionada, 3); // Actualizar Ingesta Nativa
    
                // Mostrar mensaje de confirmación
                if (alimentada) {
                    JOptionPane.showMessageDialog(this, PJtipoHormiga + ", alimentada", "Alimentación Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Ups ...! tenemos problema con la alimentación de la " + PJtipoHormiga, "Error en la Alimentación", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            // Manejo de excepciones genéricas
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
