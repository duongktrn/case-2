package ProductService;

import Acount.UserGuest;

import java.io.Serializable;

public class Cart implements Serializable {
    public int id;
    public String namePay;
    public int amountPay;
    public double pricePay;
    public UserGuest userGuest;


    public UserGuest getUserGuest() {
        return userGuest;
    }

    public void setUserGuest(UserGuest userGuest) {
        this.userGuest = userGuest;
    }

    public Cart(int id, String namePay, int amountPay, double pricePay, UserGuest userGuest) {
        this.id = id;
        this.namePay = namePay;
        this.amountPay = amountPay;
        this.pricePay = pricePay;
        this.userGuest = userGuest;
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

    public String displayFullCart(){
        return "Cart{" +
                "id=" + id +
                ", namePay='" + namePay + '\'' +
                ", amountPay=" + amountPay +
                ", pricePay=" + pricePay +
                ", userGuest=" + userGuest +
                '}';
    }
}
