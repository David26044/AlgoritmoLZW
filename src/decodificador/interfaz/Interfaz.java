/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decodificador.interfaz;

import decodificador.controlador.Controlador;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class Interfaz extends JFrame {

    private PanelDecodificacion pnlDecodificacion;
    private Controlador ctr;
    
    public Interfaz(Controlador ctrl) {
        
        pnlDecodificacion = new PanelDecodificacion();
        setSize(400, 700);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        ctrl.conectar(pnlDecodificacion);
        add(pnlDecodificacion);
    }
    
    public static void main(String[] args) {
        Interfaz frmMain = new Interfaz(new Controlador());
        frmMain.setVisible(true);
    }
}
