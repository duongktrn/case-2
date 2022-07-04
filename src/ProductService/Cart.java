package ProductService;

public class Cart {
    public int id;
    public String namePay;
    public int amountPay;
    public double pricePay;

    public Cart(int id, String namePay, int amountPay, double pricePay) {
        this.id = id;
        this.namePay = namePay;
        this.amountPay = amountPay;
        this.pricePay = pricePay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePay() {
        return namePay;
    }

    public void setNamePay(String namePay) {
        this.namePay = namePay;
    }

    public int getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(int amountPay) {
        this.amountPay = amountPay;
    }

    public double getPricePay() {
        return pricePay;
    }

    public void setPricePay(double pricePay) {
        this.pricePay = pricePay;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", namePay='" + namePay + '\'' +
                ", amountPay=" + amountPay +
                ", pricePay=" + pricePay +
                '}';
    }
}
