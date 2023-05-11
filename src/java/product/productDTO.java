package product;

public class productDTO {

    private String proID;
    private String proName;
    private float price;
    private String infor;
    private int quantity;
    private String path;
    private boolean status;

    public productDTO() {
    }

    public productDTO(String proID, String proName, float price, String infor, int quantity, String path, boolean status) {
        this.proID = proID;
        this.proName = proName;
        this.price = price;
        this.infor = infor;
        this.quantity = quantity;
        this.path = path;
        this.status = status;
    }

  

    public productDTO(String proID, String proName, float price, int quantity, String path) {
        this.proID = proID;
        this.proName = proName;
        this.price = price;
        this.quantity = quantity;
        this.path = path;
    }

    public productDTO(String proID, String proName, float price, String infor, int quantity, String path) {
        this.proID = proID;
        this.proName = proName;
        this.price = price;
        this.infor = infor;
        this.quantity = quantity;
        this.path = path;
    }

    public productDTO(String proID, String proName, float price, String path) {
        this.proID = proID;
        this.proName = proName;
        this.price = price;
        this.path = path;
    }

    public productDTO(String proID, int quantity) {
        this.proID = proID;
        this.quantity = quantity;
    }
    
    

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
      public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
