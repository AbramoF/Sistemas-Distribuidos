package DTOs.responses;

public class RegisterResponse {
    private int status;
    private String error;
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int value)
    {
        status = value;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
    public RegisterResponse(int status, String error)
    {
        this.status = status;
        this.error = error;
    }
}
