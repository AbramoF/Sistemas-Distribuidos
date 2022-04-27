package entrega1;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    
    public static void main(String[] args)
    {
       int port = 10009;
       
       try (ServerSocket serverSocket = new ServerSocket(port))
       {
           System.out.println("Server is listening on port : " + port);
           
           while (true)
           {
               Socket socket = serverSocket.accept();
               System.out.println("New client connected");
               
               new ServerThread(socket).start();
           }
       }
       catch (IOException ex)
       {
           System.out.println("Server exception : "+ ex.getMessage());
           ex.printStackTrace();
       }
    }
}
