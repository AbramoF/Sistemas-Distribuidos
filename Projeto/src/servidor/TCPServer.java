package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import repositories.Repositorio;

public class TCPServer {
    
    public static void main(String[] args)
    {
       int port = 10009;
       Repositorio repositorio = new Repositorio();
       
       try (ServerSocket serverSocket = new ServerSocket(port))
       {
           System.out.println("Server is listening on port : " + port);
           
           while (true)
           {
               Socket socket = serverSocket.accept();
               System.out.println("New client connected");
               
               new ServerThread(socket, repositorio).start();
           }
       }
       catch (IOException ex)
       {
           System.out.println("Server exception : "+ ex.getMessage());
           ex.printStackTrace();
       }
    }
}
