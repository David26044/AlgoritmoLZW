package codificador.mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Ascii {

    private HashMap<Integer, String> tabla;
    private String texto;
    private int nextIndex;  // Índice para los nuevos valores agregados

    public Ascii() {
        tabla = new HashMap<>();
        texto = "";
        llenarTablaAscii();
        nextIndex = 256;  // Inicia en 256 para agregar nuevos valores después de la tabla ASCII estándar
        leerTxtCodificar();
    }

    private void llenarTablaAscii() {
        // Crea una tabla ASCII de 0 a 255
        for (int i = 0; i < 256; i++) {
            tabla.put(i, String.valueOf((char) i));
        }
    }

    public int getIndex(String c) {
        // Busca el índice de la cadena en la tabla
        for (int i = 0; i < nextIndex; i++) {
            if (c.equals(tabla.get(i))) {
                return i;
            }
        }
        return -1;
    }
    
    private void leerTxtCodificar() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/texto.txt"));
            String linea = br.readLine();
            while (linea != null) {
                texto += linea;
                linea = br.readLine();
                if (linea != null) {
                    texto += tabla.get(10);  // Añade salto de línea (ASCII 10)
                }
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean contains(String c) {
        return tabla.containsValue(c);
    }

    public String getCode(int index) {
        return tabla.get(index);
    }

    public void put(String c) {
        // Añade un nuevo valor con un índice único si no existe en la tabla
        if (!tabla.containsValue(c)) {
            tabla.put(nextIndex, c);
            nextIndex++;  // Incrementa el índice para la próxima entrada
        }
    }

    public String getTexto() {
        return texto;
    }
}
