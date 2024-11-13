/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decodificador.controlador;

import decodificador.interfaz.PanelDecodificacion;
import decodificador.mundo.Ascii;
import decodificador.mundo.Decodificacion;
import decodificador.mundo.HelloSocket;

/**
 *
 * @author David
 */
public class Controlador {
    
private PanelDecodificacion pnlDecodificacion;

 public Controlador(){
      Decodificacion decodificador = new Decodificacion(new Ascii(), this);
      HelloSocket socket = new HelloSocket(decodificador);
 }
 
 public void conectar(PanelDecodificacion pnlDecodificacion){
     this.pnlDecodificacion = pnlDecodificacion;
 }
 
 public void setCod(String cod){
  pnlDecodificacion.addCod(cod);
 }
 
 public void setDecod(String decod){
  pnlDecodificacion.addDecod(decod);
 }
 
}
