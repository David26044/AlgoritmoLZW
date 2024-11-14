/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codificador.mundo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class HelloSocket implements Runnable {

    private List<String> ips;

    /* Constructor */
    public HelloSocket() {
        ips = new ArrayList<String>();
        Thread treadListener = new Thread(this);
        treadListener.start();
    }

    /* Client:Data >> Socket >> Server */
    public void socket(int msg) {
    for (int i = 0; i< ips.size(); i++) {
        try {
            Socket client = new Socket(ips.get(i).toString(), 5000); // Conectar a cada IP en el puerto 5000
            DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream());
            outBuffer.writeInt(msg);
            client.close();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Client: socket(1) : UnknownHostException: " + e.getMessage() + " for IP: " + ips.get(i));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Client: socket(2) : IOException: " + e.getMessage() + " for IP: " + ips.get(i));
        }
    }
}


    @Override
    /* Client: Listen */
    public void run() {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inDataBuffer;

        try {
            serverSocket = new ServerSocket(5050); // portListen 5050

            while (true) {
                socket = serverSocket.accept();
                inDataBuffer = new DataInputStream(socket.getInputStream());
                String msg = inDataBuffer.readUTF();
                socket.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
        }
    }

    public void agregarIp(String ip) {
        ips.add(ip);
    }
}
