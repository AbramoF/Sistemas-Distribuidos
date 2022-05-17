package DTOs.responses;

public class LoginResponse {

    private int status;
    private int whislist;

    public int getStatus() {
        return status;
    }

    public void setStatus(int value) {
        status = value;
    }

    public LoginResponse(int status, int whislist) {

        this.status = status;
        this.whislist = whislist;
    }
}
