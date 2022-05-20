package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadWhile extends Thread {

    //Socket socket;
    //ServerSocket serverSocket;
    ViewServidor viewServidor;

    public ThreadWhile(ViewServidor viewServidor) {
        this.viewServidor = viewServidor;
    }

    public void run() {
        try {
            while (true) {
                viewServidor.socket = viewServidor.serverSocket.accept();
                System.out.println("Novo cliente conectado");
                //System.out.println(viewServidor.socket.getRemoteSocketAddress().toString());
                new ServerThread(viewServidor).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
