package DTOs.responses;

public class EditResponse extends DefaultResponse{

    private String description;
    private float productValue;
    private String objectname;

    public EditResponse(int status,String description, float productValue, String objectname) {
        super(status);
        this.description = description;
        this.productValue = productValue;
        this.objectname = objectname;
    }
}
