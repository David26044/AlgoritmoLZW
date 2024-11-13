/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificador.controlador;


import codificador.mundo.Codificacion;
import codificador.mundo.HelloSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class Controlador {

    Codificacion cod;
    HelloSocket socket;

    public Controlador() {
        socket = new HelloSocket();
        cod = new Codificacion(socket);
    }

    public void iniciar() {
        try {
            cod.codificar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarIp(String ip) {
        socket.agregarIp(ip);
    }

}
