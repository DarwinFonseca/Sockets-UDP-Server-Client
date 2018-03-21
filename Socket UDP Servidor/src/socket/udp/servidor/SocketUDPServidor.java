package socket.udp.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SocketUDPServidor {

    static SocketUDPServidor ObjServidor = new SocketUDPServidor();
    private static Juego ObjJuego = new Juego();
    private DatagramSocket miSocket;
    private int puerto = 9107;
    private static String aux;
    private static String thisIp;
    private static Frame f;
    InetAddress host;

    public SocketUDPServidor(String a) {
    }

    public SocketUDPServidor() {
        try {
            thisIp = InetAddress.getLocalHost().getHostAddress();
            miSocket = new DatagramSocket(9107);
            host = InetAddress.getByName(thisIp);
        } catch (SocketException ex) {
            Logger.getLogger(SocketUDPServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException e) {
            Logger.getLogger(SocketUDPServidor.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Servidor Iniciado en " + thisIp + "\nEsperando conexión desde el Cliente");
        //Ejecuta la Clase Frame
        f = new Frame();

        while (true) {
            ObjServidor.recibirDatos();

        }
    }

    void recibirDatos() {

        try {
            byte[] buffer = new byte[20480];
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            miSocket.receive(peticion);

            this.host = peticion.getAddress();
            this.puerto = peticion.getPort();
            aux = new String(peticion.getData(), 0, peticion.getLength());

            if (aux.equals("")) {
                aux = "";
                ObjJuego.Jugar();
                System.out.println(ObjJuego.NumeroAleatorio);
                ObjServidor.enviarDatos("1");
            } else {
                System.out.println(new String(peticion.getData(), 0, peticion.getLength()));
                aux = new String(peticion.getData(), 0, peticion.getLength());
                aux = ObjJuego.consultarNumero(Integer.parseInt(aux));
                ObjServidor.enviarDatos("2");

            }
        } catch (IOException ex) {
            Logger.getLogger(SocketUDPServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void enviarDatos(String var) {
        try {

            switch (var) {
                case "1":
                    byte[] sendBuffer = ObjJuego.getMensaje().getBytes();
                    System.out.println("Se ha conectado desde " + host + ", por el puerto: " + puerto);

                    DatagramPacket peticion2 = new DatagramPacket(sendBuffer, sendBuffer.length, this.host, puerto);
                    miSocket.send(peticion2);
                    break;

                case "2":
                    byte[] buffer2 = aux.getBytes();

                    DatagramPacket peticion3 = new DatagramPacket(buffer2, buffer2.length, this.host, puerto);
                    miSocket.send(peticion3);
                    break;

                default:
                    throw new AssertionError();
            }

        } catch (IOException ex) {
            Logger.getLogger(SocketUDPServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void CerrarServidor() {
        miSocket.close();
    }
}
