/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author IanoM
 */
public class Cliente extends Thread
{
    static DataOutputStream ostream = null;
    DataInputStream istream = null;
    static String host = "";
    static int port = 9090;// porta para comunicacao. Deve ser a mesma do servidor.
    Socket socket = null;
    String MRcv = "";
    static String MSnd = "";

    Cliente()
    {
        try {
            socket = new Socket("localhost", port);// conecta com o servidor.
            System.out.println("Connect on PORT: " + socket.getPort());
            
            this.start();// comeca uma nova thread. O metodo run é executado.
            
            ostream = new DataOutputStream(socket.getOutputStream());
            istream = new DataInputStream(socket.getInputStream());
            
            try (Scanner console = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Client Message: ");
                    String MSnd = console.nextLine();// le mensagem do console.
                    ostream.writeUTF(MSnd);// manda mensagem para o servidor.
                    ostream.flush();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {
                MRcv = istream.readUTF();// le mensagem do server
                System.out.println("Server Message: " + MRcv);
            } catch (Exception e) {}
        }
    }

    public static void main(String args[]) {
        new Cliente();
    }
}
