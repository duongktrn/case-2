package Product;

import ProductService.Cart;
import ProductService.ManagerCart;
import ProductService.PaymentProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    static File file = new File("D:\\MD2\\Modun2\\Case Study 2\\src\\Data\\product.txt");
    static File fileCatolog = new File("D:\\MD2\\Modun2\\Case Study 2\\src\\Data\\catolog.txt");
    public static List<Product> products = new ArrayList<>();
    static List<Catolog> catologs = new ArrayList<>();

    public static void menuCatolog() {
        catologs.add(new Catolog("Iphone8"));
        catologs.add(new Catolog("Iphone10"));
        catologs.add(new Catolog("Iphone11"));
        catologs.add(new Catolog("Iphone12"));
    }
    public static Catolog creatCatolog(){
        displayCatolog();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten san pham : ");
        String name = scanner.nextLine();
        checkNameCatolog(name);
        while (checkNameCatolog(name)==true){
            System.out.println("da ton tai ten san pham,vui long nhap lai");
            name=scanner.nextLine();
        }
        return new Catolog(name);
    }
    public static boolean checkNameCatolog(String name){
        for (int i=0;i<catologs.size();i++){
            if (name.equals(catologs.get(i).getName())){
                return true;
            }
        }
        return false;
    }
    public static void saveCatolog(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileCatolog));
            objectOutputStream.writeObject(catologs);
        }catch (Exception e){

        }
    }
    public static void readCatolog(){
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileCatolog));
            catologs = (ArrayList<Catolog>)objectInputStream.readObject();
        }catch (Exception e){

        }
    }
    public static void displayCatolog(){
        for (Catolog b:catologs){
            System.out.println(b);
        }
    }
    public static void addProduct(Scanner scanner) {
        Product product = creatProduct(scanner);
        products.add(product);
        int id = products.get(products.size()-1).getId();
        while (checkId(id)!=-1){
            id = id+1;
            products.get(products.size()-1).setId(id);
            id = products.get(products.size()-1).getId();
            checkId(id);
        }
        saveProduct();
        System.out.println("Them thanh cong san pham ");
    }
    public static int checkId(int id){
        int j = products.size()-1;
        for (int i=0;i<j;i++){
            if (id==products.get(i).getId()){
                return i;
            }
        }
        return -1;
    }
    public static Product creatProduct(Scanner scanner) {
        if (catologs.size()==0){
            menuCatolog();
        }
        Catolog catolog = null;
        int choiceNameByProduct = 0;
        choiceNameByProduct = Integer.parseInt(scanner.nextLine());
        if (choiceNameByProduct==5){
            catolog = creatCatolog();
            catologs.add(catolog);
            saveCatolog();
        }
        if (0<choiceNameByProduct&&choiceNameByProduct<4){
            catolog = catologs.get(choiceNameByProduct-1);
        }
        System.out.println("Nhap so luong san pham");
        int amount = Integer.parseInt(scanner.nextLine());
        checkNameCatologInProduct(catolog);
        if (checkNameCatologInProduct(catolog)!=-1){
            amount = amount+products.get(checkNameCatologInProduct(catolog)).getAmount();
            products.get(checkNameCatologInProduct(catolog)).setAmount(amount);
            System.out.println("da ton tai "+ catologs.get(choiceNameByProduct-1)+" ,so luong san pham da duoc cong them");
        }
        System.out.println("Nhap gia san pham");
        double price = scanner.nextDouble();
        scanner.nextLine();
        if (checkNameCatologInProduct(catolog)!=-1){
            products.get(checkNameCatologInProduct(catolog)).setPrice(price);
            System.out.println("da ton tai "+ catologs.get(choiceNameByProduct-1)+" ,gia sp duoc cap nhat");
            products.remove(products.get(checkNameCatologInProduct(catolog)));
        }

        return new Product(catolog, amount, price);
    }
    public static void changeProduct(Scanner scanner){
        System.out.println("Danh sach san pham");
        displayProduct();
        System.out.println("Chon ma san pham can sua");
        int id = Integer.parseInt(scanner.nextLine());
        int index = 0;
        boolean check = true;
        while (check) {
            boolean flag = true;
            for (int i = 0; i < products.size(); i++) {
                if (id == products.get(i).getId()) {
                    index = i;
                    check = false;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Ma san pham khong dung,vui long nhap lai");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        int choice=0;
        do {
            System.out.println("1.Thay doi ten san pham          "
                    +"2.Thay doi so luong san pham         "
                    +"3.Thay doi gia san pham          "
                    +"4.Thay doi tat ca        "
                    +"5.Quay lai");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Nhap ten san pham moi");
                    String nameCatolog = scanner.nextLine();
                    products.get(index).getName().setName(nameCatolog);
                    System.out.println("Cap nhat ten san pham thanh cong");
                    break;
                case 2:
                    System.out.println("Nhap amount moi");
                    int amount = Integer.parseInt(scanner.nextLine());
                    products.get(index).setAmount(amount);
                    System.out.println("Cap nhat so luong san pham thanh cong");
                    break;
                case 3:
                    System.out.println("Nhap price moi");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    products.get(index).setPrice(price);
                    System.out.println("Cap nhat gia san pham thanh cong");
                    break;
                case 4:
                    System.out.println("Nhap ten san pham moi");
                    String nameCatolog1 = scanner.nextLine();
                    products.get(index).getName().setName(nameCatolog1);
                    System.out.println("Cap nhat ten san pham thanh cong");
                    System.out.println("Nhap amount moi");
                    int amount1 = Integer.parseInt(scanner.nextLine());
                    products.get(index).setAmount(amount1);
                    System.out.println("Cap nhat so luong san pham thanh cong");
                    System.out.println("Nhap price moi");
                    double price1 = scanner.nextDouble();
                    scanner.nextLine();
                    products.get(index).setPrice(price1);
                    System.out.println("Cap nhat gia san pham thanh cong");
                    break;

            }
        }while (choice!=5);

        saveProduct();
    }
    public static void deleteProduct(Scanner scanner){
        int choiceDelete = Integer.parseInt(scanner.nextLine());
        int checkIdDelete = 0;
        boolean checkDelete = true;
        while (checkDelete==true){
            for (int i=0;i<products.size();i++){
                if (choiceDelete==products.get(i).getId()){
                    checkIdDelete = i;
                    break;
                }else {
                    checkIdDelete=-1;
                }
            }
            if (checkIdDelete!=-1) {
                System.out.println("Chon : \n"+"1.Dong y xoa        "+"2.Huy xoa");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice==1){
                    products.remove(products.get(checkIdDelete));
                    checkDelete = false;
                    saveProduct();
                    System.out.println("xoa thanh cong san pham");
                }
                if (choice==2){
                    System.out.println("Ban da huy uu cau xoa");
                    checkDelete=false;
                }
            }else{
                System.out.println("Khong ton tai ma san pham,vui long nhap lai");
                choiceDelete = Integer.parseInt(scanner.nextLine());
                checkDelete = true;
            }
        }

    }
    public static int checkNameCatologInProduct(Catolog catolog){
        for (int i=0;i<products.size();i++){
            if (catolog.getName().equals(products.get(i).getName().getName())){
                return i;
            }
        }
        return -1;
    }
    public static void saveProduct(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        }catch (Exception e){
            System.out.println("loi luu file");
        }
    }
    public static void readProduct(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            products = (ArrayList<Product>)objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e){

        }
    }
    public static void displayProduct(){
        readProduct();
        for (Product b:products){
            System.out.println(b);
        }
    }
    public static int checkIdPay(int choice){
        for (int i =0;i<products.size();i++){
            if (products.get(i).getId()==choice){
                return i;
            }
        }
        return -1;
    }
    public static void displayPayProduct(int choice){
        if (checkIdPay(choice)==-1){
            System.out.println("khong ton tai ma san pham");
        }else {
            System.out.println("Ban da lua chon san pham:");
            System.out.println( products.get(checkIdPay(choice)));;
        }
    }
    public static boolean checkAmountPay(int amount,int choice){
        if (amount<=products.get(checkIdPay(choice)).getAmount()){
            return true;
        }else {
            return false;
        }
    }
    public static void payProduct(int choice,int amountPay){
        System.out.println("Chon:\n"+ "1.Thanh toan    "+"2.Them vao gio hang      "+"3.Huy lua chon");
        Scanner scanner = new Scanner(System.in);
        int inputPay = Integer.parseInt(scanner.nextLine());
        do {
            switch (inputPay){
                case 1:
                    int amount = products.get(checkIdPay(choice)).getAmount() - amountPay ;
                    products.get(checkIdPay(choice)).setAmount(amount);
                    saveProduct();
                    inputPay=3;
                    break;
                case 2:
                    String name = products.get(checkIdPay(choice)).getName().getName();
                    double price = products.get(checkIdPay(choice)).getPrice();
                    PaymentProduct.carts1.add(new Cart(choice,name,amountPay,price));
                    displayCarts1();
                    inputPay=3;
                    break;
            }
        }while (inputPay!=3);
    }
    public static void displayCarts1(){
        for (Cart b:PaymentProduct.carts1){
            System.out.println(b);
        }
    }
    public static String payNameCatolog(int choice){
        return  products.get(checkIdPay(choice)).getName().getName();
    }
    public static double payPrice(int choice){
        return products.get(checkIdPay((choice))).getPrice();
    }

}
