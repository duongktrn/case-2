package Acount;

import Product.ManagerProduct;
import ProductService.Cart;
import ProductService.PaymentProduct;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagerGuest {
    static File file = new File("D:\\MD2\\Modun2\\Case Study 2\\src\\Data\\user.txt");
    public static List<UserGuest> registers = new ArrayList<>();
    public static int indexCustomer ;
    public static void addUser() {
        UserGuest register = creatUser();
        registers.add(register);
        int id = registers.get(registers.size()-1).getId();
        while (checkId(id)==true){
                    id = id+1;
                    registers.get(registers.size()-1).setId(id);
                    id = registers.get(registers.size()-1).getId();
                    checkId(id);
        }
        saveUser();
        System.out.println("dang ky tai khoan khach hang thanh cong");
    }
    public static boolean checkId(int id){
        int j = registers.size()-1;
        for (int i=0;i<j;i++){
            if (id==registers.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    public static UserGuest creatUser() {
        readUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ten dang nhap muon tao");
        String name = scanner.nextLine();
        Pattern p = Pattern.compile("^[a-zA-Z0-9]{3,18}$");
        while (p.matcher(name).find()==false) {
            if (!p.matcher(name).find()) {
                System.err.println("Ten dang nhap phai bat dau bang 1 so hoac 1 chu cai va co do dai tu 3-18 ky tu,vui long nhap lai");
                name = scanner.nextLine();
            }
        }
        while (checkUser(name)==true){
            System.out.println("Ten dang nhap da ton tai,vui long nhap ten khac");
            name = scanner.nextLine();
        }
        System.out.println("Mat khau muon tao");
        String pass = scanner.nextLine();
        while (p.matcher(pass).find()==false) {
            if (!p.matcher(pass).find()) {
                System.err.println("Pass phai bat dau bang 1 so hoac 1 chu cai va co do dai tu 3-18 ky tu,vui long nhap lai");
                pass = scanner.nextLine();
            }
        }
        checkDeleteLoginProduct(name);
        return new UserGuest(name, pass);
    }
    public static boolean checkUser(String name){
        for (int i=0;i<registers.size();i++){
            if (name.equals(registers.get(i).getUser())){
                return true;
            }
        }
        return false;
    }
    public static void checkDeleteLoginProduct(String userName){
        boolean checkUserName = false;
        for (int i =0;i<PaymentProduct.carts.size();i++){
            if (userName.equals(PaymentProduct.carts.get(i).getUserGuest().getUser())){
                checkUserName=true;
                break;
            }
        }
        if (checkUserName){
            int j = PaymentProduct.carts.size();
            for (int i =0;i<j&&j>0;i++){
                if (userName.equals(PaymentProduct.carts.get(i).getUserGuest().getUser())){
                    PaymentProduct.carts.remove(i);
                    i=-1;
                    j--;
                }
            }
            PaymentProduct.saveCart();
        }
    }
    public static void deleteUser(Scanner scanner){
        displayUser();
        System.out.println("chon id tai khoan muon xoa");
        try{
        int id = Integer.parseInt(scanner.nextLine());
        boolean check =true;
        for (int i=0;i<registers.size();i++){
            if (id==registers.get(i).getId()){
                System.out.println("xoa thanh cong user: "+registers.get(i).getUser());
                registers.remove(registers.get(i));
                saveUser();
                check=false;
                break;
                }
            }
        if (check){
            System.out.println("khong ton tai id can xoa");
        }
        }catch (Exception e){
            System.out.println("khong ton tai id");
        }
    }
    public static void saveUser() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(registers);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println("user loi roi");
        }
    }

    public static void readUser() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            registers = (List<UserGuest>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
        }
    }
    public static void displayUser(){
        readUser();
        for (UserGuest b:registers){
            System.out.println(b);
        }
    }
    public static void loginUser(Scanner scanner){
        System.out.println("Nhap ten dang nhap: ");
        String user = scanner.nextLine();
        while (checkUserName(user)==-1){
            System.out.println("Sai ten dang nhap,vui long nhap lai");
            user = scanner.nextLine();
        }
        System.out.println("Nhap mat khau dang nhap:");
        String pass = scanner.nextLine();
         while (checkPassUser(user,pass)==false){
             System.out.println("sai pass dang nhap,vui long nhap lai");
             pass = scanner.nextLine();
         }
         indexCustomer = checkUserName(user);
        System.out.println("dang nhap khach hang thanh cong");
    }
    public static int checkUserName(String user){
        readUser();
        for (int i=0;i<registers.size();i++){
            if (user.equals(registers.get(i).getUser())){

                return i;
            }
        }
        return -1;
    }
    public static boolean checkPassUser(String user,String pass){
        readUser();
       if (pass.equals(registers.get(checkUserName(user)).getPass())){
           return true;
       }

        return false;
    }
}
