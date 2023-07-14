import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class formulario {
    private JPanel rootpanel;
    private JTextField codigotextField1;
    private JTextField cedulatextField2;
    private JTextField nombrestextField3;
    private JTextField apellidotextField4;
    private JCheckBox rojoCheckBox;
    private JCheckBox verdeCheckBox;
    private JCheckBox ningunoCheckBox;
    private JRadioButton siRadioButton;
    private JComboBox añocomboBox1;
    private JComboBox mescomboBox2;
    private JComboBox diacomboBox3;
    private JButton cargarDatosDesdeElButton;
    private JButton guardarDatosEnDiscoButton;
    private JTextPane muestratextPane1;
    private JButton verAnteriorRegistroButton;
    private JButton verSiguienteRegistroButton;
    private JRadioButton noRadioButton;
    private JComboBox signocomboBox4;
    private JTextArea textArea1;


    public formulario() {
        guardarDatosEnDiscoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crea un objeto FileWriter para escribir en el archivo "datos.txt"
                    FileWriter writer = new FileWriter("src/binary data.dat", true);

                    // Escribe los datos ingresados en los JTextField en el archivo, separados por comas
                    writer.write(codigotextField1.getText() + "," + cedulatextField2.getText() + "," + nombrestextField3.getText() + "," + apellidotextField4.getText() + "," +
                                  signocomboBox4.getSelectedItem() + "," + añocomboBox1.getSelectedItem() + "," + mescomboBox2.getSelectedItem() + "," + diacomboBox3.getSelectedItem()
                                + "," + rojoCheckBox.getActionCommand() + "," +  verdeCheckBox.getActionCommand() + "," + ningunoCheckBox.getActionCommand() +
                                "," + siRadioButton.getActionCommand() + "," + noRadioButton.getActionCommand() + "\n");

                    // Cierra el objeto FileWriter
                    writer.close();

                    // Borra el contenido de los JTextField
                    codigotextField1.setText("");
                    cedulatextField2.setText("");
                    nombrestextField3.setText("");

                    JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        cargarDatosDesdeElButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crea un objeto Scanner para leer el archivo de texto
                    Scanner scanner = new Scanner(new File("src/binary data.dat"));

                    // Lee la primera línea del archivo y separa los valores por comas
                    String[] valores = scanner.nextLine().split(",");

                    // Asigna los valores correspondientes a cada JLabel
                    textArea1.setText("Codigo: " + (valores[0]) + "\n" + "Cedula: " + valores[1] + "\n" + "Nombres: " + valores[2] + "\n" + "Apellidos: " + valores[3] + "\n"
                            + "Signo: " + valores[4] + "\n" + "Fecha de nacimiento\n" + "Año: "+ valores[5] + "\n" + "Mes: " + valores[6] + "\n" + "Dia: " + valores[7]
                            + "Color favorito\n" + valores[8] + "\n" + "Casado: " + valores[9]);

                    // Cierra el objeto Scanner
                    scanner.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Estudiantes");
        frame.setContentPane(new formulario().rootpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
