package entrega1;

import DTOs.responses.DefaultResponse;
import DTOs.requests.DefaultRequest;
import java.io.*;
import java.net.Socket;
import com.google.gson.Gson;

public class ServerThread extends Thread
{
    private Socket socket;
    
    public ServerThread(Socket socket)
    {
        this.socket = socket;
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
        DefaultRequest request = gson.fromJson(jsonRequest, DefaultRequest.class);
        switch (request.getOp())
        {
            case 100:
                return gson.toJson(new DefaultResponse(100), DefaultResponse.class);
            default: 
                return gson.toJson(new DefaultResponse(999), DefaultResponse.class);
        }
    }
    
}
