package quang.com.model;

public class Order {
    protected int id;
    protected String cus_name;
    protected String phone;
    protected String address;
    protected String product_name;
    protected float product_price;
    protected String status;

    public Order() {
    }

    public Order(int id, String cus_name, String phone, String address, String product_name, float product_price, String status) {
        this.id = id;
        this.cus_name = cus_name;
        this.phone = phone;
        this.address = address;
        this.product_name = product_name;
        this.product_price = product_price;
        this.status = status;
    }

    public Order(String cus_name, String phone, String address, String product_name, float product_price, String status) {
        this.cus_name = cus_name;
        this.phone = phone;
        this.address = address;
        this.product_name = product_name;
        this.product_price = product_price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
