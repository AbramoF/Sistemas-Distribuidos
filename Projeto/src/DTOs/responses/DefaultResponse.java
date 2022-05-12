package DTOs.responses;

public class DefaultResponse {
    private int status;
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int value)
    {
        status = value;
    }
    
    public DefaultResponse(int status)
    {
        this.status = status;
    }
}
