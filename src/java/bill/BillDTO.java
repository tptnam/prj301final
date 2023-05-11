package bill;

public class BillDTO {

    private String billID;
    private String name;
    private String email;
    private String address;
    private String note;
    private boolean status;
    private String proID;
    private String phone;
    private int quantity;

    public BillDTO() {
    }

    public BillDTO(String name, String email, String address, String note, boolean status, String proID, String phone, int quantity) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.note = note;
        this.status = status;
        this.proID = proID;
        this.phone = phone;
        this.quantity = quantity;
    }
    
    

    public BillDTO(String billID, String name, String email, String address, String note, boolean status, String proID, String phone, int quantity) {
        this.billID = billID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.note = note;
        this.status = status;
        this.proID = proID;
        this.phone = phone;
        this.quantity = quantity;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    

   
    
}
