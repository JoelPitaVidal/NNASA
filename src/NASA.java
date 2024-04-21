import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NASA extends JFrame {
            int opcion = 0;
    public class Layout extends JFrame {

        public Layout(){
            //TODO: cambiar a inglés los textos
            //Configuramos el titulo del Layout y el cierre del mismo
            setTitle("Bienvenido a la interfaz de gestión de misiones de la NASA");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            //Configuramos JPanel y establecemos FlowLayout como su gestor de layout
            JPanel panel = new JPanel(new FlowLayout());
            //Botones
            JButton MisionGestion = new JButton("Gestión de misiones");
            JButton FileGestion = new JButton("Gestión de Archivos");
            JButton DirectionSimulator = new JButton("Simulacion de Trayectoria");
            JButton MisionReport = new JButton("Reportes de mision");
            // Añadir los botones al panel
            panel.add(MisionGestion);
            panel.add(FileGestion);
            panel.add(DirectionSimulator);
            panel.add(MisionReport);
            // Añadir el panel al JFrame
            add(panel);
            //Configuramos las acciónes de los botones
            ArrayList<String> misiones= new ArrayList<>();
            //Gestion de Misiones
            MisionGestion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("Que deséa hacer? (1-añadir mision/2-eliminar mision/3-lista de misiones;)"));
                    switch (opcion){
                        case 1:
                            misiones.add(JOptionPane.showInputDialog("Inserte el nombre de la misión a realizar"));
                        break;
                        case 2:
                            //TODO: configurar el borrado de misiones
                            misiones.remove(misiones);
                        break;
                        case 3:
                            JOptionPane.showMessageDialog(null,"Las misiones actuales són las siguientes: "+misiones);
                        break;
                    }

                }
            });
            //Gestion de Archivos
            FileGestion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            //Simulación de Trayectoria
            DirectionSimulator.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            //Ver Reportes de mision
            MisionReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            // Ajustar el tamaño del JFrame y hacerlo visible
            setSize(441, 147);
            setVisible(true);
        }
    }

}
