package cliente;

import java.io.*;
import java.net.*;
import DTOs.responses.DefaultResponse;
import DTOs.requests.DefaultRequest;
import DTOs.requests.LoginRequestDTO;
import DTOs.requests.LogoutRequestDTO;
import DTOs.requests.RegisterRequestDTO;
import com.google.gson.Gson;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TCPClient {

    public static void createInterfaceLogin(JFrame f, BufferedReader in, PrintWriter out, Socket echoSocket) {
        JLabel login = new JLabel("Bem Vindo");
        JLabel username = new JLabel("Usuario:");
        JLabel password = new JLabel("Senha:");
        JTextPane usernameBox = new JTextPane();
        JPasswordField passwordBox = new JPasswordField();
        JButton botaoCadastro = new JButton("Registro");
        JButton botaoLogin = new JButton("Login");

        botaoLogin.setBounds(100, 140, 100, 40);
        botaoCadastro.setBounds(100, 190, 100, 40);
        usernameBox.setBounds(110, 55, 75, 25);
        passwordBox.setBounds(110, 95, 75, 25);
        login.setBounds(110, 1, 75, 75);
        username.setBounds(60, 55, 75, 25);
        password.setBounds(68, 95, 75, 25);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    out.close();
                    in.close();
                    echoSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        f.add(botaoLogin);
        f.add(botaoCadastro);
        f.add(login);
        f.add(username);
        f.add(password);
        f.add(usernameBox);
        f.add(passwordBox);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

        botaoLogin.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = usernameBox.getText();
                    String password = String.valueOf(passwordBox.getPassword());
                    Gson gson = new Gson();
                    LoginRequestDTO loginRequest = new LoginRequestDTO();
                    loginRequest.setOp(100);
                    loginRequest.setUsername(username);
                    loginRequest.setPassword(password);
                    System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(loginRequest) + "\n\n");
                    out.println(gson.toJson(loginRequest));
                    String resposta = in.readLine();
                    System.out.println("Servidor respondeu : " + resposta);
                    
                    DefaultResponse respostaJson = gson.fromJson(resposta, DefaultResponse.class);
                    if(respostaJson.getStatus() == 101)
                    {
                      JOptionPane.showMessageDialog(null, "Sucesso", "Login", 1);
                    } else if(respostaJson.getStatus() == 102) {
                      JOptionPane.showMessageDialog(null, "Fail", "Login", 1);
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        botaoCadastro.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = usernameBox.getText();
                    String password = String.valueOf(passwordBox.getPassword());
                    Gson gson = new Gson();
                    RegisterRequestDTO registerRequest = new RegisterRequestDTO();
                    registerRequest.setOp(300);
                    registerRequest.setUsername(username);
                    registerRequest.setPassword(password);
                    System.out.printf("\n\nMensagem Enviada para o Server : " + gson.toJson(registerRequest) + "\n\n");
                    out.println(gson.toJson(registerRequest));
                    String resposta = in.readLine();
                    System.out.println("Servidor respondeu : " + resposta);
                } catch (IOException ex) {
                    Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {

        String serverHostname = new String("127.0.0.1"); //127.0.0.1 //jeremy 10.20.8.16
        if (args.length > 0) {
            serverHostname = args[0];
        }
        System.out.println("Attemping to connect to host " + serverHostname + " on port 20000.");
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 20000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: " + serverHostname);
            System.exit(1);
        }

        // CRIACAO DA INTERFACE
        JFrame f = new JFrame();
        createInterfaceLogin(f, in, out, echoSocket);
        // --------------------

    }
}
