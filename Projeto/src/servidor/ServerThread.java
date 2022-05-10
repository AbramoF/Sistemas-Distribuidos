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

public class ServerThread extends Thread
{
    private Socket socket;
    //private UsuarioDAO usuario;
    
    public ServerThread(Socket socket)
    {
        this.socket = socket;
        //this.usuario = new UsuarioDAO();
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
                String response = TreatRequest(jsonRequest);
                writer.println("Server enviou : " + response);
            } while(!jsonRequest.equals("Bye"));
            
            System.out.println("ENCERROU");
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
            // ---------------------
            result = true;// tirar 
            // ---------------------
            
            switch (request.getOp())
            {
                case 100:
                    LoginRequestDTO loginRequest = gson.fromJson(jsonRequest, LoginRequestDTO.class);
                    //result = usuario.checkLogin(loginRequest.getUsername(), loginRequest.getPassword());
                    if (result)
                        return gson.toJson(new DefaultResponse(101), DefaultResponse.class);
                    return gson.toJson(new DefaultResponse(102), DefaultResponse.class);
                case 200:
                    LogoutRequestDTO logoutRequest = gson.fromJson(jsonRequest, LogoutRequestDTO.class);
                    //usuario.logout(logoutRequest.getUsername());
                    return gson.toJson(new DefaultResponse(201));
                case 300:
                    RegisterRequestDTO registerRequest = gson.fromJson(jsonRequest, RegisterRequestDTO.class);
                    //result = usuario.register(registerRequest.getUsername(), registerRequest.getPassword());
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
