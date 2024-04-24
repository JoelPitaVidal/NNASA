import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import javax.swing.*;
import java.io.*;

public class NASA extends JFrame {
    int opcion = 0;
    ArrayList<String> misiones = new ArrayList<>();
    Reportes r = new Reportes();

    public class Layout extends JFrame {

        public Layout() {
            //TODO: cambiar a inglés los textos
            //Configuramos el titulo del Layout y el cierre del mismo
            setTitle("Bienvenido a la interfaz de gestión de misiones de la NASA");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            //Configuramos JPanel y establecemos FlowLayout como su gestor de layout
            JPanel panel = new JPanel(new FlowLayout());
            //Botones
            JButton MisionGestion = new JButton("Gestión de misiones");
            JButton DirectionSimulator = new JButton("Simulacion de Trayectoria");
            JButton MisionReport = new JButton("Reportes de mision");
            // Añadir los botones al panel
            panel.add(MisionGestion);
            panel.add(DirectionSimulator);
            panel.add(MisionReport);
            // Añadir el panel al JFrame
            add(panel);
            //Configuramos las acciónes de los botones

            //Gestion de Misiones
            MisionGestion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("Que deséa hacer? (1-añadir mision/2-eliminar todas las misiones/3-lista de misiones;)"));
                    switch (opcion) {
                        case 1:
                            String nuevaMision = JOptionPane.showInputDialog("Inserte el nombre de la misión a realizar");
                            if (misiones.contains(nuevaMision)) {
                                JOptionPane.showMessageDialog(null, "La misión ya existe en la base de datos.");
                                misiones.remove(2);
                            } else {
                                misiones.add(nuevaMision);
                            }
                            break;
                        case 2:
                            misiones.removeAll(misiones);
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Las misiones actuales són las siguientes: " + misiones);
                            break;
                    }
                }
            });

            //Simulación de Trayectoria
            DirectionSimulator.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Definir la secuencia de signos para simular la trayectoria
                    String trayectoria = generarTrayectoria(10); // Cambia el número para cambiar la longitud de la trayectoria

                    // Mostrar la trayectoria en un JOptionPane
                    JOptionPane.showMessageDialog(null, trayectoria, "Trayectoria Simulada", JOptionPane.PLAIN_MESSAGE);
                }

                // Método para generar una secuencia de signos para simular la trayectoria
                public static String generarTrayectoria(int longitud) {
                    // Generar coordenadas espaciales aleatorias
                    String comunicado = "Fin de la simulación";
                    double coordenadaX = Math.random() * 2000 - 1000;
                    double coordenadaY = Math.random() * 2000 - 1000;
                    double coordenadaZ = Math.random() * 2000 - 1000;

                    // Generar una dirección aleatoria
                    String[] direcciones = {"Norte", "Sur", "Este", "Oeste", "Arriba", "Abajo"};
                    int indiceDireccion = (int) (Math.random() * direcciones.length);
                    String direccion = direcciones[indiceDireccion];

                    // Construir el mensaje para mostrar en el JOptionPane
                    String mensaje = "Coordenadas Espaciales:\n" +
                            "X: " + coordenadaX + "\n" +
                            "Y: " + coordenadaY + "\n" +
                            "Z: " + coordenadaZ + "\n\n" +
                            "Dirección: " + direccion;

                    // Mostrar el mensaje en un JOptionPane
                     JOptionPane.showMessageDialog(null, mensaje, "Trayectoria Espacial", JOptionPane.INFORMATION_MESSAGE);
                    return comunicado;
                }
            });
            //Ver Reportes de mision
            MisionReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String MensajeLeido = "";
                    try {

                        FileWriter fw = new FileWriter("ReporteMision.txt");

                        fw.write("1. La nave recorrerá una cantidad de 156 años luz  " +
                                "2. El destino de la nave es el planeta de Cadia   " +
                                "3. El objetivo de la misión es cerrar la estructura paranormal conocida como 'ojo del terror'   " +
                                "FIN DEL REGISTRO DE LA MISION: " + misiones);

                        fw.close();
                    } catch (IOException ex) {

                        System.out.println("Ocurrió un error al escribir en el archivo: " + ex.getMessage());
                    }

                    try {

                        FileReader lector = new FileReader("ReporteMision.txt");
                        BufferedReader BR = new BufferedReader(lector);
                        MensajeLeido = BR.readLine();

                    } catch (Exception ex) {
                    }

                    JOptionPane.showMessageDialog(null, MensajeLeido);
                }
            });
            // Ajustar el tamaño del JFrame y hacerlo visible
            setSize(441, 147);
            setVisible(true);
        }
    }
}
