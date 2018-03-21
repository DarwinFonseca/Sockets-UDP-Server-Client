package Parte1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SocketUDPCliente {

    static SocketUDPCliente ObjCliente = new SocketUDPCliente();

    public static void main(String[] args) {
        String Mensaje=JOptionPane.showInputDialog("Digite...");
        ObjCliente.enviarDatos(Mensaje);

//        ObjCliente.enviarDatos("\n"
//                + "Estudiante:\t Darwin Gonzalo Fonseca Abril\n"
//                + "NRC:\t\t 7996"
//                + "\nAsignatura:\t Interconectividad"
//                + "\nDocente:\t Ing. Johnn Eduar Criollo Salamanca");
    }

    void enviarDatos(String msn) {
        try {
            // TODO code application logic here

            DatagramSocket miSocket = new DatagramSocket();
            byte[] mensaje = msn.getBytes();
            InetAddress host = InetAddress.getByName("127.0.0.1");
            int puerto = 9107;
            DatagramPacket miPaquete = new DatagramPacket(mensaje, msn.length(), host, puerto);
            miSocket.send(miPaquete);

        } catch (SocketException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
