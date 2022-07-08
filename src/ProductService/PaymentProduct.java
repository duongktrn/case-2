package ProductService;

import Acount.ManagerGuest;
import Acount.UserGuest;
import Product.ManagerProduct;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PaymentProduct {
    public static List<Cart> carts = new ArrayList<>();
    static File file = new File("D:\\MD2\\Modun2\\Case Study 2\\src\\Data\\cart.txt");
    static boolean checkAddCart = true;
    static UserGuest userGuest=null;

    public static void addCart(Scanner scanner) {
        Cart cart = payment(scanner);
        if (checkAddCart) {
            carts.add(cart);
            saveCart();
        }

    }

    public static Cart payment(Scanner scanner) {
        System.out.println("nhap ma san pham muon mua");
        int choice = Integer.parseInt(scanner.nextLine());
        choice = ManagerProduct.displayPayProduct(choice);
        System.out.println("Nhap so luong san pham can mua");
        int amountPay = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        while (flag == true) {
            if (amountPay < 0) {
                System.out.println("vui long nhap so luong > 0");
                amountPay = Integer.parseInt(scanner.nextLine());
                flag = true;
            } else {
                flag = false;
            }
        }
        ManagerProduct.checkAmountPay(amountPay, choice);
        boolean check = true;
        String name = "";
        double pricePay = 0;
        while (check == true) {
            if (ManagerProduct.checkAmountPay(amountPay, choice)) {
                pricePay = ManagerProduct.payPrice(choice);
                name = ManagerProduct.payNameCatolog(choice);
                checkAddCart = ManagerProduct.payProduct(choice, amountPay);
                int checkCartUser = checkCartUser(amountPay,choice);
                if (checkCartUser!=-1){
                    amountPay=checkCartUser;
                    System.out.println("Da ton tai san pham trong gio hang,so luong san pham da duoc cong them");
                }
                check = false;
            } else {
                System.out.println("Khong du hang,vui long chon so luong nho hon");
                amountPay = Integer.parseInt(scanner.nextLine());
                check = true;
            }
        }
         userGuest = ManagerGuest.registers.get(ManagerGuest.indexCustomer);
        return new Cart(choice, name, amountPay, pricePay,userGuest);
    }

    public static void displayCart() {
        readCart();
        long sum = 0;
        for (int i=0;i<carts.size();i++){
            System.out.println(carts.get(i).displayFullCart());
            sum += carts.get(i).getPricePay();
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        System.err.println("Tong so tien la : "+currencyVN.format(sum)+" VND");
    }
    public static void displayCartByUser(){
        readCart();
        long sum = 0;
        for (int i =0;i<carts.size();i++){
            if (ManagerGuest.registers.get(ManagerGuest.indexCustomer).getUser().equals(carts.get(i).getUserGuest().getUser())){
                System.out.println(carts.get(i));
                sum += carts.get(i).getPricePay() * (long) carts.get(i).amountPay;
            }
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        System.err.println("Tong tien thanh toan la: "+currencyVN.format(sum)+" VND");
    }
    public static int checkCartUser(int amountPay,int choice){
        for (int i =0;i<carts.size();i++){
            if (ManagerGuest.registers.get(ManagerGuest.indexCustomer).getUser().equals(carts.get(i).getUserGuest().getUser())
            &&choice==carts.get(i).getId()){
                amountPay +=carts.get(i).getAmountPay();
                carts.remove(i);
                return amountPay;
            }
        }
        return -1;
    }

    public static void saveCart() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(carts);
            objectOutputStream.close();
        } catch (Exception e) {
        }
    }

    public static void readCart() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            carts = (ArrayList<Cart>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {

        }
    }
}
