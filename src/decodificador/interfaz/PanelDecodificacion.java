/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decodificador.interfaz;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author David
 */
public class PanelDecodificacion extends JPanel {

    private JTextArea txtDecod, txtCod;
    private JLabel lblCod, lblDecod;
    private JScrollPane scrollDecod, scrollCod;

    public PanelDecodificacion() {
        setBounds(20, 20, 340, 700);
        setLayout(null);
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));

        txtCod = new JTextArea();
        txtDecod = new JTextArea();
        lblCod = new JLabel("    MENSAJE CODIFICADO");
        lblDecod = new JLabel(" MENSAJE DECODIFICADO");

        // Configuración de áreas de texto
        txtCod.setBounds(20, 70, 340, 60);
        txtDecod.setBounds(20, 210, 340, 425);
        lblCod.setBounds(120, 10, 160, 45);
        lblDecod.setBounds(120, 150, 160, 45);

        txtDecod.setBackground(Color.lightGray);
        txtCod.setBackground(Color.LIGHT_GRAY);
        lblCod.setOpaque(true);
        lblDecod.setOpaque(true);
        lblCod.setBackground(Color.YELLOW);
        lblDecod.setBackground(Color.YELLOW);

        txtCod.setEditable(false);
        txtDecod.setEditable(false);

        // Envolvemos txtCod y txtDecod en JScrollPane para agregar barra de desplazamiento
        scrollCod = new JScrollPane(txtCod);
        scrollDecod = new JScrollPane(txtDecod);

        // Ajustamos las posiciones y tamaños de los JScrollPane
        scrollCod.setBounds(20, 70, 340, 60);
        scrollDecod.setBounds(20, 210, 340, 425);

        // Agregamos los componentes
        add(scrollCod);
        add(scrollDecod);
        add(lblCod);
        add(lblDecod);
    }

    public void addCod(String cod) {
        if (txtCod.getText().isEmpty()) {
            txtCod.setText(cod);
        } else {
            txtCod.setText(txtCod.getText() + ", " + cod);
        }
    }

    public void addDecod(String decod) {
        if (txtDecod.getText().isEmpty()) {
            txtDecod.setText(decod);
        } else {
            txtDecod.setText(txtDecod.getText() + decod);
        }
    }
}
