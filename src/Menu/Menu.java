package Menu;

import Acount.ManagerAdmin;
import Acount.ManagerGuest;
import Product.ManagerProduct;
import Product.Product;
import ProductService.PaymentProduct;

import java.util.Scanner;

public class Menu {
    public static void Acount() {
        int choice = 0;
        do {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Chon dang nhap hoac dang ky de tiep tuc \n" + "1.Dang nhap admin       " + "2.Dang nhap khach hang            " + "3.Dang ky khach hanh       ");
            try {
                System.out.println("nhap so:");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ManagerAdmin.loginAdmin(scanner);
                        System.out.println("----------------------");
                        managerAdmin();
                    break;
                    case 2:
                        ManagerGuest.loginUser(scanner);
                        System.out.println("----------------------");
                        managerGuest();
                        break;
                    case 3:
                        ManagerGuest.addUser();
                        break;
//                    case 4:ManagerGuest.displayUser();
                }
            } catch (Exception e) {
                System.out.println("Nhap khong dung ,vui long chon so \n" + "----------------------------");
            }

        } while (choice != 9);
    }
    public static void managerAdmin(){
        int choiceManager=0;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Chon chuc nang:\n"
                        +"1.Quan ly san pham        "+"2.Quan ly user          "+"3.Hien thi don dat hang            "+"4.Thoat chuong trình");
                choiceManager = Integer.parseInt(scanner.nextLine());
                switch (choiceManager){
                    case 1:
                        int choiceAdmin = 0;
                        do {
                            System.out.println("Chon: ");
                            System.out.println("1.Them moi san pham         "+"2.Sua san pham         "+"3.Xoa san pham         " +"4.Kiem tra kho hang         "+"5.Exit");
                             choiceAdmin =Integer.parseInt(scanner.nextLine());
                             switch (choiceAdmin){
                                 case 1:
                                     System.out.println("Chon ten san pham hoac them moi ten san pham:");
                                     System.out.println("1.Iphone8       "+"2.Iphone10      "+"3.Iphone11      "+"4.Iphone12       "
                                             +"5.Them ten san pham moi          "+"6.exit");
                                     System.out.println("Nhap lua chon bang so : ");
                                     ManagerProduct.addProduct(scanner);
                                     break;
                                 case 2:
                                     ManagerProduct.changeProduct(scanner);
                                     break;
                                 case 3:
                                     System.out.println("Danh sach san pham: ");
                                     ManagerProduct.displayProduct();
                                     ManagerProduct.deleteProduct(scanner);
                                     break;
                                 case 4:
                                     ManagerProduct.displayProduct();
                                     break;
                             }
                        }while (choiceAdmin!=5);
                        break;
                    case 2:
                        int choiceManagerUser = 0;
                        do {
                            System.out.println("1.Them moi nguoi dung         "+"2.Hien thi danh sach nguoi dung         "+"3.Xoa nguoi dung         "+"4.Exit");
                            choiceManagerUser = Integer.parseInt(scanner.nextLine());
                            switch (choiceManagerUser){
                                case 1:
                                    ManagerGuest.addUser();
                                    break;
                                case 2:
                                    ManagerGuest.displayUser();
                                    break;
                                case 3:
                                    ManagerGuest.deleteUser(scanner);
                                    break;
                            }
                        }while (choiceManagerUser!=4);
                        break;
                    case 3:PaymentProduct.displayCart();
                }
            }catch (Exception e){
                System.out.println("vui long nhap so");
            }

        }while (choiceManager!=4);
    }
    public static void managerGuest(){
        int choiceGuest = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------------");
            System.out.println("nhap lua chon de tiep tuc: ");
            System.out.println("1.Mua hang      "+"2.Quan ly don hang        "
                    +"Nhap chu bat ky de thoat");
            choiceGuest = Integer.parseInt(scanner.nextLine());
            switch (choiceGuest){
                case 1:
                    System.out.println("Danh sach san pham");
                    ManagerProduct.displayProduct();
                    System.out.println("--------------------------");
                    PaymentProduct.addCart(scanner);
                    break;
                case 2:
                    System.out.println("Danh sach san pham da mua");
                    PaymentProduct.displayCartByUser();
//                    System.out.print("Tong so tien thanh toan: ");
////                    double payTotal = PaymentProduct.totalPay();
//                    System.out.println(payTotal);
                    break;

            }
        }while (choiceGuest!=5);
    }
}
