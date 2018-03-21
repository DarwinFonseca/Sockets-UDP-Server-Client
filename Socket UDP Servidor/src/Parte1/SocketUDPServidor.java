package Parte1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SocketUDPServidor {

    public static void main(String[] args) {
        try {

            DatagramSocket miSocket = new DatagramSocket(9107);
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                miSocket.receive(peticion);
                System.out.println("IP:\t" + peticion.getAddress());
                System.out.println("Puerto:\t" + peticion.getPort());
                System.out.println("Mensaje:\t" + new String(peticion.getData(), 0, peticion.getLength()));
            }

        } catch (IOException ex) {
            // Logger.getLogger(SocketUDPServidor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex);
        }

    }

}
