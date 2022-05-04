package model.bean;


public class Produto {
    
    
    private int idproduct;
    private String name;
    private float value;
    private String description;
    //private int user_iduser;

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
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

//    public int getUser_iduser() {
//        return user_iduser;
//    }
//
//    public void setUser_iduser(int user_iduser) {
//        this.user_iduser = user_iduser;
//    }
    
    
    
}
