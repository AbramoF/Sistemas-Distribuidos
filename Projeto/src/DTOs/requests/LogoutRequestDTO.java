package DTOs.requests;


public class LogoutRequestDTO extends DefaultRequest{
    private String username;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String value)
    {
        username = value;
    }
}