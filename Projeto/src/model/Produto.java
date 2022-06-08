package model;


public class Produto {
    
    private int productId;
    private String name;
    private float value;
    private String description;
    private String username;

    public Produto(int idproduct, String name, float value, String description, String user_username) {
        this.productId = idproduct;
        this.name = name;
        this.value = value;
        this.description = description;
        this.username = user_username;
    }
    

    public int getIdproduct() {
        return productId;
    }

    public void setIdproduct(int idproduct) {
        this.productId = idproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser_username() {
        return username;
    }

    public void setUser_username(String user_username) {
        this.username = user_username;
    }


    
    
    
}
