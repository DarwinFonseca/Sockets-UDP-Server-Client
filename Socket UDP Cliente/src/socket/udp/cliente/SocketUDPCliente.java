package socket.udp.cliente;

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

    static GUI ObjGui = new GUI();
    static SocketUDPCliente ObjCliente = new SocketUDPCliente();
    private DatagramSocket miSocket;
    static InetAddress host;
    private final int puerto = 9107;
    private static String ip;

    public static void main(String[] args) {

        try {
            ip = JOptionPane.showInputDialog(null,
                    "¿ Con qué IP\n quiere establecer conexión ?",
                    "127.0.0.1");
            host = InetAddress.getByName(ip);

            System.out.println("ip: " + ip);
            ObjCliente.conectar("OK");

            ObjCliente.recibirDatos();
            String Mensaje = JOptionPane.showInputDialog("Digite el valor: ");
            ObjCliente.enviarDatos(Mensaje);
            ObjCliente.recibirDatos();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SocketUDPCliente() {
        try {
            this.miSocket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void conectar(String msn) {
        try {
            byte[] mensaje = msn.getBytes();
            System.out.println(host);
            System.out.println(puerto);
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

    void enviarDatos(String Mensaje) {
        try {
            byte[] buffer = Mensaje.getBytes();

            DatagramPacket miPaquete2 = new DatagramPacket(buffer, buffer.length, host, puerto);
            miSocket.send(miPaquete2);

        } catch (SocketException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void recibirDatos() {
        try {
            byte[] bufferRecibido = new byte[20480];
            DatagramPacket miPaquete3 = new DatagramPacket(bufferRecibido, bufferRecibido.length);
            miSocket.receive(miPaquete3);
            ObjGui.setVisible(true);
            ObjGui.jLabel1.setText("<html>" + new String(miPaquete3.getData(), 0, miPaquete3.getLength()));

        } catch (SocketException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketUDPCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
