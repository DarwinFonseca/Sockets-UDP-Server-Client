/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.udp.servidor;

import javax.swing.JOptionPane;

/**
 *
 * @author DarwinFonck
 */
public class Juego {

    //Declaracion de Variables
    int NumeroAleatorio;
    public String Mensaje = "<html><body><center>";

    static final int A[][] = {{1, 3, 5, 7, 9, 11, 13, 15}, {17, 19, 21, 23, 25, 27, 29, 31}, {33, 35, 37, 39, 41, 43, 45, 47}, {49, 51, 53, 55, 57, 59, 61, 63}, {65, 67, 69, 71, 73, 75, 77, 79}, {81, 83, 85, 87, 89, 91, 93, 95}, {97, 99, 0, 0, 0, 0, 0, 0}};
    static final int B[][] = {{2, 3, 6, 7, 10, 11, 14, 15}, {18, 19, 22, 23, 26, 27, 30, 31}, {34, 35, 38, 39, 42, 43, 46, 47}, {50, 51, 54, 55, 58, 59, 62, 63}, {66, 67, 70, 71, 74, 75, 78, 79}, {82, 83, 86, 87, 90, 91, 94, 95}, {98, 99, 0, 0, 0, 0, 0, 0}};
    static final int C[][] = {{4, 5, 6, 7, 12, 13, 14, 15}, {20, 21, 22, 23, 28, 29, 30, 31}, {36, 37, 38, 39, 44, 45, 46, 47}, {52, 53, 54, 55, 60, 61, 62, 63}, {68, 69, 70, 71, 76, 77, 78, 79}, {84, 85, 86, 87, 92, 93, 94, 95}};
    static final int D[][] = {{8, 9, 10, 11, 12, 13, 14, 15}, {24, 25, 26, 27, 28, 29, 30, 31}, {40, 41, 42, 43, 44, 45, 46, 47}, {56, 57, 58, 59, 60, 61, 62, 63}, {72, 73, 74, 75, 76, 77, 78, 79}, {88, 89, 90, 91, 92, 93, 94, 95}};
    static final int E[][] = {{16, 17, 18, 19, 20, 21, 22, 23}, {24, 25, 26, 27, 28, 29, 30, 31}, {48, 49, 50, 51, 52, 53, 54, 55}, {56, 57, 58, 59, 60, 61, 62, 63}, {80, 81, 82, 83, 84, 85, 86, 87}, {88, 89, 90, 91, 92, 93, 94, 95}};
    static final int F[][] = {{32, 33, 34, 35, 36, 37, 38, 39}, {40, 41, 42, 43, 44, 45, 46, 47}, {48, 49, 50, 51, 52, 53, 54, 55}, {56, 57, 58, 59, 60, 61, 62, 63}, {96, 97, 98, 99, 0, 0, 0, 0}};
    static final int G[][] = {{64, 65, 66, 67, 68, 69, 70, 71}, {72, 73, 74, 75, 76, 77, 78, 79}, {80, 81, 82, 83, 84, 85, 86, 87}, {88, 89, 90, 91, 92, 93, 94, 95}, {96, 97, 98, 99, 0, 0, 0, 0}};

    public void GenerarNumeroAleatorio() {
        NumeroAleatorio = (int) (Math.random() * 99) + 1;
        //System.out.println("Aleatorio: " + NumeroAleatorio);
    }

    void imprimirMatriz(int[][] Matriz, String nombre) {
        Mensaje += (" <br> Matriz " + nombre + " <br> <table style=\"width:100%\">");
        for (int i = 0; i < Matriz.length; i++) {
            Mensaje += "<tr>";
            for (int j = 0; j < Matriz[0].length; j++) {
                if (Matriz[i][j] == 0) {
                Mensaje += ("<td></td>");
                } else {
                    Mensaje += ("<td>" + Matriz[i][j] + " </td> ");
                }
            }
            Mensaje += (" </tr>");
        }
        Mensaje += (" </table>");

    }

    String recorrerMatriz(int[][] Matriz, int num) {
        String respuesta = "El numero secreto NO está en esta carta <br> ";
        int i = 0;
        //System.out.println();
        for (i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[0].length; j++) {
                //System.out.print(Matriz[i][j] + " | ");
                if (num == Matriz[i][j]) {
                    respuesta = "El numero secreto está en esta carta <br> ";
                    i = Matriz.length;
                    break;
                }
            }
            //System.out.println("");
        }
        return respuesta;
    }

    String consultarNumero(int Numero) {
        String resp = " <br> Has perdido, el número secreto era " + this.NumeroAleatorio;
        //Numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un número"));
        if (Numero == this.NumeroAleatorio) {
            resp = " <br> Felicidades, el número secreto era " + this.NumeroAleatorio;
        }
        return resp;
    }

    void buscarNumero() {

        Mensaje += "<table style=\"width:100%\"><tr>  ";
        Mensaje += "<th>";
        imprimirMatriz(A, "A");
        Mensaje += (recorrerMatriz(A, this.NumeroAleatorio));
        Mensaje += "</th><th>";
        imprimirMatriz(B, "B");
        Mensaje += (recorrerMatriz(B, this.NumeroAleatorio));
        Mensaje += "</th><th>";
        imprimirMatriz(C, "C");
        Mensaje += (recorrerMatriz(C, this.NumeroAleatorio));
        Mensaje += "</th><th>";
        imprimirMatriz(D, "D");
        Mensaje += (recorrerMatriz(D, this.NumeroAleatorio));
        Mensaje += "</th></tr><tr><th>";
        imprimirMatriz(E, "E");
        Mensaje += (recorrerMatriz(E, this.NumeroAleatorio));
        Mensaje += "</th><th>";
        imprimirMatriz(F, "F");
        Mensaje += (recorrerMatriz(F, this.NumeroAleatorio));
        Mensaje += "</th><th>";
        imprimirMatriz(G, "G");
        Mensaje += (recorrerMatriz(G, this.NumeroAleatorio));
        Mensaje += " </th></tr></table></body></html> ";

        //System.out.println(Mensaje);
    }

    public void Jugar() {
        // SocketUDPServidor ObjUDP = new SocketUDPServidor();
        setMensaje();
        GenerarNumeroAleatorio();
        buscarNumero();
        //ObjJuego.obtenerNumero();

    }

    public void setMensaje() {
        this.Mensaje = " <br> ";
    }

    public String getMensaje() {
        return Mensaje;
    }
}
