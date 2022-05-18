package DTOs.responses;

public class LoginResponse {

    private int status;
    private int wishlist;

    public int getStatus() {
        return status;
    }

    public void setStatus(int value) {
        status = value;
    }

    public LoginResponse(int status, int wishlist) {

        this.status = status;
        this.wishlist = wishlist;
    }
}
