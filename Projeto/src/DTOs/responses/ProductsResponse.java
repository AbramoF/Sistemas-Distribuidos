package DTOs.responses;

import java.util.ArrayList;
import model.Produto;

public class ProductsResponse extends DefaultResponse {

    private ArrayList<Produto> productArray;

    public ProductsResponse(int status, ArrayList<Produto> productArray) {
        super(status);
        this.productArray = productArray;
    }

    public ArrayList<Produto> getProductArray() {
        return productArray;
    }
    
    

}
