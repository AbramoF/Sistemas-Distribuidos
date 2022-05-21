package DTOs.responses;

public class ErrorDefaultResponse extends DefaultResponse{
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ErrorDefaultResponse(int status,String error) {
        super(status);
        this.error = error;
    }
    
    
    
}
