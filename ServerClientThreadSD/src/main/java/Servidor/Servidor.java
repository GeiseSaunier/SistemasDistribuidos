/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author IanoM
 */
public class Servidor extends Thread
{
    ServerSocket serverSocket = null;
    Socket socket = null;
    static DataOutputStream ostream = null;
    static int port = 9090;// porta para comunicacao.
    DataInputStream istream = null;
    String MRcv = "";
    static String MSnd = "";

    Servidor() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Aguardando conexão...");
            socket = serverSocket.accept();// aguarda conexao com o cliente.
            System.out.println("Conexão Estabelecida.");
            ostream = new DataOutputStream(socket.getOutputStream());
            istream = new DataInputStream(socket.getInputStream());

            this.start();// inicia uma nova thread. O metodo run é executado.

            try (Scanner console = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Server Message: ");
                    String MSnd = console.nextLine(); // le string do console
                    ostream.writeUTF(MSnd);// envia string para o cliente.
                    ostream.flush();
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void run() {
        try {
            while (true) {
                MRcv = istream.readUTF();// le as strings do client
                System.out.println("Client Message: " + MRcv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Servidor();
    }
}
