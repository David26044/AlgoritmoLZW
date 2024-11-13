/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decodificador.mundo;

import decodificador.controlador.Controlador;


/**
 *
 * @author David
 */
public class Decodificacion {

    private String pe;
    private String se;
    private String ps;
    private StringBuilder texto;
    private Ascii diccionario;
    private boolean peB;
    private Controlador ctrl;

    public Decodificacion(Ascii diccionario, Controlador ctrl) {
        texto = new StringBuilder();
        this.diccionario = diccionario;
        pe = "";
        se = "";
        peB = true;//es true se recibe pe, sino se recibe se
        this.ctrl = ctrl;
    }

    public void recibirEntrada(int in) {
        ctrl.setCod(String.valueOf(in));
        if (peB && pe.equals("")) {//primera vez que se llama al metodo
            pe = diccionario.getCode(in); // se decodifica pe primera vez, ahora debe recibir se por primera vez.
            decodificar(pe); //se decodifica pe
            peB = false;
            return;
        }
        if (!peB) { // primera vez que llega se, solo se lee.
            se = diccionario.getCode(in);
            if (se == null) {
                se = pe + pe.substring(0, 1); // si se no existe, se es igual al último recibido mas su primer caracter
            }
            if (se.equals(diccionario.getCode(10))) {
                ps = pe + se;
            } else {
                ps = pe + se.substring(0, 1); //se concatenan las dos entradas, pe y solo el primer caracter de se
            }
            veryfPs(in);
            return;
        }
    }

    public void decodificar(String cod) {
        ctrl.setDecod(cod);
    }

    public void veryfPs(int in) {
        if (!diccionario.contains(ps)) { // si ps no está en el diccionario
            diccionario.put(ps); //se agrega ps
        }
        decodificar(se);
        pe = se;
        se = "";
    }
}
