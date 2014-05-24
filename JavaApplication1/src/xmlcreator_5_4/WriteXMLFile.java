package xmlcreator_5_4;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class WriteXMLFile {

    private static BufferedReader lector;

    public static void main(String[] args) {

        try {
            //Para tomar los datos por consola
            lector = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el nombre de la raiz:");
            String rootStr = lector.readLine();
            Element root = new Element(rootStr);
            Document doc = new Document(root);
            int numeroDeAtributos=0;
            boolean isCorrect;
            do {                
               try {
                System.out.println("Ingrese el número de atributos de " + rootStr);
                numeroDeAtributos = Integer.parseInt(lector.readLine());
                isCorrect=true;
            } catch (Exception e) {
                isCorrect=false;
                   System.out.println("No se ingresa un caractes correctamente: Vuelva a intentarlo!!\n");
            } 
            } while (!isCorrect);
            
            //Atributo que se crea para obtener los atributos de la raiz y su respectivo valor.
            String atributos[][] = new String[numeroDeAtributos][2];
            for (int i = 0; i < numeroDeAtributos; i++) {
                System.out.println("Ingrese el nombre del atributo " + (i + 1));
                atributos[i][0] = lector.readLine();
            }

            for (int i = 0; i < atributos.length; i++) {
                System.out.println("Ingrese el contenido del atributo " + atributos[i][0]);
                atributos[i][1] = lector.readLine();
            }
            //Se agregan los elementos a la raiz.
            for (int i = 0; i < atributos.length; i++) {
                root.addContent(new Element(atributos[i][0]).setText(atributos[i][1]));
            }
            //Impresión por pantalla y generación de un documento.
           
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, System.out);            
            xmlOutput.output(doc, new FileWriter("file.xml"));

            System.out.println("Archivo Guardado!");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
