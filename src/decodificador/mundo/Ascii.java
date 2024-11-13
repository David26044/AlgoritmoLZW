/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package decodificador.mundo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        tabla.set(10, "\n");
    }

    private void leerTxtTabla() {
    try {
        // Usamos InputStreamReader con UTF-8
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/asciiComp.txt"), "UTF-8"));
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

    public boolean contains(String c) {
        int i = 0;
        for (String s : tabla) {
            if (c.equals(s)) {
                return true;
            }
        }
        return false;
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

    public String getCode(int index) {
        if (index >= tabla.size()) {
            return null;
        }
        return tabla.get(index);
    }

    public void put(String c) {
        tabla.add(c);
    }

    public int length(){
        return tabla.size();
    }
    
    public String getTexto() {
        return texto;
    }   
    
    public String getLast(){
        return tabla.getLast();
    }
}
