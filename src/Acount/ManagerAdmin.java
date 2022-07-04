package Acount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerAdmin {
    static File file = new File("D:\\MD2\\Modun2\\Case Study 2\\src\\Data\\user.txt");
    static List<UserAdmin> userAdmins = new ArrayList<>();
    public static void creatAdmin(){
        userAdmins.add(new UserAdmin("admin","123456"));
        readAmin();
        saveAdmin();
    }
    public static void loginAdmin(Scanner scanner){
        System.out.println("nhap ten dang nhap:");
        String admin = scanner.nextLine();
        while (!admin.equals("admin")){
            System.out.println("Sai ten dang nhap,vui long nhap lai");
            admin = scanner.nextLine();
        }
        System.out.println("Nhap mat khau dang nhap:");
        String pass = scanner.nextLine();
        while (!pass.equals("123456")){
            System.out.println("Sai pass dang nhap,vui long nhap lai");
            pass = scanner.nextLine();
        }
        System.out.println("dang nhap admin thanh cong");
    }
    public static void saveAdmin(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(userAdmins);
            objectOutputStream.close();
        }catch (Exception e){
            System.out.println("khong luu duoc file");
        }
    }
    public static void readAmin(){
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            userAdmins = (ArrayList<UserAdmin>)objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e){

        }
    }

}
