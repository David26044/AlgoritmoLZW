/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificador.interfaz;

import codificador.controlador.Controlador;
import javax.swing.JFrame;

/**
 *
 * @author ACER
 */
public class InterfazApp extends JFrame {

    private PanelIp pnlIp;

    public InterfazApp(Controlador ctrl) {
        setTitle("Interfaz grafica");
        //Entre parentesis se pone el tipo de layaut, en este caso es null porqyue yo mismo lo defino
        getContentPane().setLayout(null);

        //Propiedades de la interfaz
        setSize(450, 290);
        setResizable(false); //no deja cambiar el tamaño del Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar al darle en la X
        setLocationRelativeTo(null);	//centrar JFrame

        pnlIp = new PanelIp(ctrl);
        add(pnlIp);

    }

    public static void main(String[] args) {
        InterfazApp frmMain = new InterfazApp(new Controlador()); //instancia
        frmMain.setVisible(true);
    }
}
