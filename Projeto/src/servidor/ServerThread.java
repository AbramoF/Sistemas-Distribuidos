package servidor;

import DTOs.responses.DefaultResponse;
import DTOs.requests.DefaultRequest;
import DTOs.requests.LoginRequestDTO;
import DTOs.requests.LogoutRequestDTO;
import DTOs.requests.RegisterRequestDTO;
import DTOs.responses.LoginResponse;
import DTOs.responses.RegisterResponse;
import java.io.*;
import java.net.Socket;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import model.Usuario;
import repositories.Repositorio;

public class ServerThread extends Thread {

    ViewServidor viewServidor;
    Socket socket;
    String currentUser;
    Usuario usuariotabela;

    public ServerThread(ViewServidor viewServidor) {
        super();
        this.viewServidor = viewServidor;

    }

    public void run() {
        try {
            InputStream input = viewServidor.socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = viewServidor.socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String jsonRequest;

            do {
                jsonRequest = reader.readLine();
                System.out.println("Cliente Enviou: " + jsonRequest);
                if (jsonRequest != null) {
                    String response = TreatRequest(jsonRequest);
                    writer.println(response);
                    System.out.println("Servidor respondeu: " + response);
                }
            } while (jsonRequest != null);

            if (currentUser != null) {
                viewServidor.repositorio.logOut(currentUser); // DESLOGAR USER QUANDO FECHA O CLIENTE
                atualizarTabela();
            }
            System.out.println("Encerrou Thread");

            viewServidor.socket.close();
        } catch (Exception ex) {
            System.out.println("Encerrou Thread inesperadamente");
            if (currentUser != null) {
                viewServidor.repositorio.logOut(currentUser); // DESLOGAR USER QUANDO FECHA O CLIENTE
                atualizarTabela();
            }
            //System.out.println("Server exception: " + ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void atualizarTabela() {
        String user;

        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel) viewServidor.getTabela().getModel();
        dtm.fireTableDataChanged(); // limpando
        dtm.setRowCount(0); // começa pela linha 0

        for (int cont = 0; cont < viewServidor.repositorio.usuariosOnline.size(); cont++) {
            user = viewServidor.repositorio.usuariosOnline.get(cont);
            String[] data
                    = {
                        "" + user
                    };
            dtm.addRow(data);
        }
    }

    public String TreatRequest(String jsonRequest) {
        Gson gson = new Gson();
        try {
            DefaultRequest request = gson.fromJson(jsonRequest, DefaultRequest.class);

            boolean result;
            int resultNumber;

            switch (request.getOp()) {
                // LOGIN
                case 100:
                    LoginRequestDTO loginRequest = gson.fromJson(jsonRequest, LoginRequestDTO.class);
                    result = viewServidor.repositorio.login(loginRequest.getUsername(), loginRequest.getPassword());
                    if (result) {
                        currentUser = loginRequest.getUsername();
                        atualizarTabela();
                        return gson.toJson(new LoginResponse(101, 0));
                    }
                    return gson.toJson(new DefaultResponse(102));
                // LOGOUT
                case 200:
                    LogoutRequestDTO logoutRequest = gson.fromJson(jsonRequest, LogoutRequestDTO.class);
                    if (viewServidor.repositorio.logOut(currentUser)) {
                        atualizarTabela();
                        return gson.toJson(new DefaultResponse(201));
                    }
                // sem resposta se n der certo o logout
                // REGISTRO
                case 300:
                    RegisterRequestDTO registerRequest = gson.fromJson(jsonRequest, RegisterRequestDTO.class);
                    resultNumber = viewServidor.repositorio.registrarUsuario(registerRequest.getUsername(), registerRequest.getPassword());
                    if (resultNumber == 0) { // Algum campo vazio
                        return gson.toJson(new RegisterResponse(303, "Algum campo vazio"));
                    } else if (resultNumber == 1) { // Usuario ja existe 
                        return gson.toJson(new RegisterResponse(302, "Usuario ja existe"));
                    } else if (resultNumber == 2) { // Sucesso registro
                        return gson.toJson(new DefaultResponse(301));
                    }
                // NOVO PRODUTO
                case 800:

                default:
                    return gson.toJson(new DefaultResponse(999), DefaultResponse.class);
            }

        } catch (JsonSyntaxException ex) {
            System.out.println("Erro ao converter para Json");
            return "";
        }
    }

}

/*
public class ServerThread extends Thread
{
    
    private Socket socket;
    Repositorio repositorio;
    String currentUser;
    
    public ServerThread(Socket socket, Repositorio repositorio)
    {
        this.socket = socket;
        this.repositorio = repositorio;
    }
    
    public void run()
    {
        try 
        {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            String jsonRequest;
            
            do
            {
                jsonRequest = reader.readLine();
                System.out.println("Cliente Enviou: " +jsonRequest);
                if(jsonRequest != null)
                {
                    String response = TreatRequest(jsonRequest);
                    writer.println(response);
                }
            } while(jsonRequest != null);
            
            if(currentUser != null)
                repositorio.logOut(currentUser); // DESLOGAR USER QUANDO FECHA O CLIENTE
            System.out.println("Encerrou Thread");
            socket.close();
        } 
        catch(IOException ex) 
        {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();   
        }
    }
    
public String TreatRequest(String jsonRequest)
    {
        Gson gson = new Gson();
        try
        {
            DefaultRequest request = gson.fromJson(jsonRequest, DefaultRequest.class);
            
            boolean result;
            
            switch (request.getOp())
            {
                case 100:
                    LoginRequestDTO loginRequest = gson.fromJson(jsonRequest, LoginRequestDTO.class);
                    result = repositorio.login(loginRequest.getUsername(), loginRequest.getPassword());
                    if (result)
                    {
                        currentUser = loginRequest.getUsername();
                        return gson.toJson(new DefaultResponse(101), DefaultResponse.class);
                    }
                    return gson.toJson(new DefaultResponse(102), DefaultResponse.class);
                case 200:
                    LogoutRequestDTO logoutRequest = gson.fromJson(jsonRequest, LogoutRequestDTO.class);
                    return gson.toJson(new DefaultResponse(201));
                case 300:
                    RegisterRequestDTO registerRequest = gson.fromJson(jsonRequest, RegisterRequestDTO.class);
                    result = repositorio.registrarUsuario(registerRequest.getUsername(), registerRequest.getPassword());
                    if (result)
                        return gson.toJson(new DefaultResponse(301));
                    return gson.toJson(new DefaultResponse(302));
                        
                default: 
                    return gson.toJson(new DefaultResponse(999), DefaultResponse.class);
            }
            
        }
        catch(JsonSyntaxException ex)
        {
            System.out.println("Erro ao converter para Json");
            return "";
        }
    }
    
}
 */
