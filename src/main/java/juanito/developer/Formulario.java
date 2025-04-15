package juanito.developer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {

    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField dniField;
    private JComboBox<String> provinciaComboBox;
    private JComboBox<String> comunidadComboBox;

    public Formulario() {
        super("Formulario de Registro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Panel para campos del formulario
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));

        // Campo nombre
        JPanel nombrePanel = new JPanel();
        nombrePanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(20);
        nombrePanel.add(nombreField);
        panelForm.add(nombrePanel);

        // Campo apellidos
        JPanel apellidosPanel = new JPanel();
        apellidosPanel.add(new JLabel("Apellidos:"));
        apellidosField = new JTextField(20);
        apellidosPanel.add(apellidosField);
        panelForm.add(apellidosPanel);

        // Campo DNI
        JPanel dniPanel = new JPanel();
        dniPanel.add(new JLabel("DNI:"));
        dniField = new JTextField(20);
        dniPanel.add(dniField);
        panelForm.add(dniPanel);

        // Campo provincia
        JPanel provinciaPanel = new JPanel();
        provinciaPanel.add(new JLabel("Provincia:"));
        String[] provincias = {"Madrid", "Barcelona", "Valencia", "Sevilla", "Gijón"};
        provinciaComboBox = new JComboBox<>(provincias);
        provinciaPanel.add(provinciaComboBox);
        panelForm.add(provinciaPanel);

        // Campo comunidad autónoma
        JPanel comunidadPanel = new JPanel();
        comunidadPanel.add(new JLabel("Comunidad Autónoma:"));
        String[] comunidades = {"Comunidad de Madrid", "Cataluña", "Comunidad Valenciana", "Andalucía", "Asturias"};
        comunidadComboBox = new JComboBox<>(comunidades);
        comunidadPanel.add(comunidadComboBox);
        panelForm.add(comunidadPanel);

        // Botones
        JPanel botonesPanel = new JPanel();
        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para guardar los datos
                String nombre = nombreField.getText();
                String apellidos = apellidosField.getText();
                String dni = dniField.getText();
                String provincia = (String) provinciaComboBox.getSelectedItem();
                String comunidad = (String) comunidadComboBox.getSelectedItem();

                JOptionPane.showMessageDialog(null, "Datos guardados:\n" +
                        "Nombre: " + nombre + "\n" +
                        "Apellidos: " + apellidos + "\n" +
                        "DNI: " + dni + "\n" +
                        "Provincia: " + provincia + "\n" +
                        "Comunidad Autónoma: " + comunidad);
            }
        });
        botonesPanel.add(guardarButton);
        panelForm.add(botonesPanel);

        this.add(panelForm, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Formulario();
            }
        });
    }
}

