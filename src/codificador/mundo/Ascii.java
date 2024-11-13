/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package codificador.mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Ascii {

    private List<String> tabla;
    private String texto;

    public Ascii() {
        tabla = new ArrayList<String>();
        texto = "";
        leerTxtTabla();
        leerTxtCodificar();
    }

    private void leerTxtTabla() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/asciiComp.txt"));
            String linea = br.readLine();
            while (linea != null) {
                tabla.add(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int getIndex(String c){
        int i = 0;
        for (String s : tabla) {
            if (c.equals(s)) {
                return i;
            }
            i++;
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
                    texto += tabla.get(10);
                }
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean contains(String c) {
        return tabla.contains(c);
    }

    public String getCode(int index) {
        return tabla.get(index);
    }

    public void put(String c) {
        tabla.add(c);
    }

    public String getTexto() {
        return texto;
    }
}
