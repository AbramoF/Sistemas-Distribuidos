package servidor;

import DTOs.responses.DefaultResponse;
import DTOs.requests.DefaultRequest;
import DTOs.requests.LoginRequestDTO;
import DTOs.requests.LogoutRequestDTO;
import DTOs.requests.RegisterRequestDTO;
import java.io.*;
import java.net.Socket;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import repositories.Repositorio;

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
                    writer.println("Server enviou : " + response);
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
