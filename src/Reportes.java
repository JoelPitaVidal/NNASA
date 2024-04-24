
import javax.swing.*;
import java.io.*;

public class Reportes {

    public static void main(String[] args) {
    String MensajeLeido="";
     try {

         FileWriter fw = new FileWriter("ReporteMision.txt");

         fw.write("1. La nave recorrerá una cantidad de 156 años luz\n");
         fw.write("2. El destino de la nave es el planeta de Cadia\n");
         fw.write("3. El objetivo de la misión es cerrar la estructura paranormal conocida como 'ojo del terror'\n");

         fw.close();
        } catch (IOException e) {

            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }

            try {

                FileReader lector = new FileReader("ReporteMision.txt");
                BufferedReader BR = new BufferedReader(lector);
                MensajeLeido = BR.readLine();

            } catch (Exception e) {}

        JOptionPane.showMessageDialog(null,MensajeLeido);

    }
}