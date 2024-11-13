/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificador.interfaz;

import codificador.controlador.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelIp extends JPanel implements ActionListener {

    private JButton btnAgregar;
    private JButton btnEmpezar;
    private JTextField txtIp;
    private JLabel lblIp;
    private JList<String> listaIps;
    private DefaultListModel<String> listaModel;
    private Controlador ctrl;

    public PanelIp(Controlador ctrl) {
        
         this.ctrl = ctrl;
        setLayout(null);
        setBounds(10, 10, 420, 233);
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));

        lblIp = new JLabel("Ingresa la ip");
        lblIp.setBounds(10, 25, 150, 25);
        add(lblIp);

        txtIp = new JTextField();
        txtIp.setBounds(10, 60, 150, 25);
        add(txtIp);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 95, 150, 25);
        add(btnAgregar);

        btnEmpezar = new JButton("Enviar mensaje");
        btnEmpezar.setBounds(120, 180, 180, 25);
        add(btnEmpezar);

        // Crear el modelo y la lista para mostrar las IPs ingresadas
        listaModel = new DefaultListModel<>();
        listaIps = new JList<>(listaModel);
        JScrollPane scrollPane = new JScrollPane(listaIps);
        scrollPane.setBounds(180, 25, 200, 125);
        add(scrollPane);

        // Agregar evento al botón "Agregar" para añadir la IP a la lista
        btnAgregar.addActionListener(this);
        btnEmpezar.addActionListener(this);
    }

    private void agregarIp() {
        String ip = txtIp.getText();
        if (!ip.isEmpty()) {
            listaModel.addElement(ip); // Añadir la IP al modelo de la lista
            txtIp.setText(""); // Limpiar el campo de texto
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
            agregarIp();  // Llama al método agregarIp para añadir la IP a la lista y limpiar el campo
            ctrl.agregarIp(txtIp.getText());
        }
        if (e.getSource() == btnEmpezar) {
            ctrl.iniciar();
        }
    }

}
