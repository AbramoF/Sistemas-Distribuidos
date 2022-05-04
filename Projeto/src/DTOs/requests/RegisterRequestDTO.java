package DTOs.requests;

public class RegisterRequestDTO extends DefaultRequest{
    private String username;
    private String password;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String value)
    {
        username = value;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String value)
    {
        password = value;
    }
}