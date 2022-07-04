package ProductService;

import Product.ManagerProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentProduct {
    static List<Cart> carts = new ArrayList<>();
    public static List<Cart> carts1 = new ArrayList<>();
    static File file = new File("D:\\MD2\\Modun2\\Case Study 2\\src\\Data\\cart.txt");
    public static void addCart(Scanner scanner){
        Cart cart = payment(scanner);
        carts.add(cart);
        saveCart();
        System.out.println("Thanh toan thanh cong,kiem tra trong muc trang thai don hang");
    }
    public static Cart  payment(Scanner scanner){
        System.out.println("nhap ma san pham muon mua");
        int choice = Integer.parseInt(scanner.nextLine());
        ManagerProduct.displayPayProduct(choice);
        System.out.println("Nhap so luong san pham can mua");
        int amountPay = Integer.parseInt(scanner.nextLine());
        ManagerProduct.checkAmountPay(amountPay,choice);
        boolean check=true;
        String name ="";
        double pricePay = 0;
        while (check==true) {
            if (ManagerProduct.checkAmountPay(amountPay, choice)) {
                ManagerProduct.payPrice(choice);
                name = ManagerProduct.payNameCatolog(choice);
                ManagerProduct.payProduct(choice, amountPay);
                check = false;
            }else {
                System.out.println("Khong du hang,vui long chon so luong nho hon");
                amountPay = Integer.parseInt(scanner.nextLine());
                check =false;
            }
        }
        return new Cart(choice,name,amountPay,pricePay);
    }
    public static void displayCart(){
        readCart();
        for (Cart b:carts){
            System.out.println(b);
        }
    }
    public static void saveCart() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(carts);
            objectOutputStream.close();
        } catch (Exception e) {
        }
    }
    public static void readCart(){
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            carts=(ArrayList<Cart>)objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e){

        }
    }
}
