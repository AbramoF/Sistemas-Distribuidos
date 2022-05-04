package DTOs.responses;

public class DefaultResponse {
    private int statusCode;
    
    public int getStatusCode()
    {
        return statusCode;
    }
    
    public void setStatusCode(int value)
    {
        statusCode = value;
    }
    
    public DefaultResponse(int statusCode)
    {
        this.statusCode = statusCode;
    }
}
