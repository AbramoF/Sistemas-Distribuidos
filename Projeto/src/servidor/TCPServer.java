package servidor;

import DTOs.requests.LoginRequestDTO;
import DTOs.requests.RegisterRequestDTO;
import DTOs.responses.DefaultResponse;
import cliente.TCPClient;
import static cliente.TCPClient.createInterfaceLogin;
import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import repositories.Repositorio;

public class TCPServer {

    static int port = 0;

    public static void main(String[] args) {

        Repositorio repositorio = new Repositorio();

        JFrame f = new ViewServidor();
        f.setVisible(true);
        //new Interface(repositorio);
        
        repositorio.port = 20000;

        while (repositorio.port == 0) {

        }
        
        

        try ( ServerSocket serverSocket = new ServerSocket(repositorio.port)) {
            System.out.println("Servidor usando porta: " + repositorio.port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Novo cliente conectado");

                //new ServerThread(socket, repositorio).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

/*
        JFrame f = new JFrame();
        JLabel titulo = new JLabel("Interface Servidor");
        JLabel portLabel = new JLabel("Porta:");
        JTextPane portBox = new JTextPane();
        JButton botaoPort = new JButton("Escolher");

        titulo.setBounds(110, 1, 200, 75);
        portLabel.setBounds(60, 55, 75, 25);
        portBox.setBounds(110, 55, 75, 25);
        botaoPort.setBounds(100, 140, 100, 40);

        f.add(titulo);
        f.add(portLabel);
        f.add(portBox);
        f.add(botaoPort);

        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

        botaoPort.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String porta = portBox.getText();
                port = Integer.parseInt(porta);
                System.out.println("Porta escolhida: " + porta);

            }
        });
 */
