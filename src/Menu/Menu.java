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
            System.out.println("Chon dang nhap hoac dang ky de tiep tuc \n" + "1.Dang nhap admin       " + "2.Dang nhap khach hang            " + "3.Dang ky khach hanh       "+"4.Hien thi user");
            try {
                System.out.println("nhap so:");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ManagerAdmin.loginAdmin(scanner);
                        managerAdmin();
                    break;
                    case 2:
                        ManagerGuest.loginUser(scanner);
                        managerGuest();
                        break;
                    case 3:
                        ManagerGuest.addUser();
                        break;
                    case 4:ManagerGuest.displayUser();
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
                System.out.println("----------------------------------\n" + "Chon chuc nang:\n"
                        + "1.Them san pham            " + "2.Sua san pham                       " + "3.Xem ton kho        \n"
                        + "4.Xoa san pham             " + "5.Hien thi danh sach user            " + "6.Them moi user nguoi dung         \n"
                        + "7.Xoa user nguoi dung       " + "8.Thoat chuong trinh               \n"
                        +"9.Hien thi catolog\n"
                        + "------------------------------------");
                choiceManager = Integer.parseInt(scanner.nextLine());
                switch (choiceManager){
                    case 1:
                        System.out.println("1.Iphone8       "+"2.Iphone10      "+"3.Iphone11      "+"4.Iphone12       "
                                +"5.Them moi Catolog");
                        System.out.println("Nhap lua chon bang so : ");
                        ManagerProduct.addProduct(scanner);
                        break;
                    case 2:ManagerProduct.changeProduct(scanner);
                    break;
                    case 3:
                        ManagerProduct.displayProduct();
                        break;
                    case 4:
                        System.out.println("Danh sach san pham: ");
                        ManagerProduct.displayProduct();
                        System.out.println("Chon ma san pham muon xoa :");
                        ManagerProduct.deleteProduct(scanner);
                        break;
                    case 5:ManagerGuest.displayUser();
                    break;
                    case 6:ManagerGuest.addUser();
                    break;
                    case 7:ManagerGuest.deleteUser(scanner);
                    break;
                    case 9:ManagerProduct.displayCatolog();
                    break;
                }
            }catch (Exception e){
                System.out.println("vui long nhap so");
            }

        }while (choiceManager!=8);
    }
    public static void managerGuest(){
        int choiceGuest = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------------");
            System.out.println("nhap lua chon de tiep tuc: ");
            System.out.println("1.Mua hang      "+"2.Gio hang      "+"3.Xem trang thai don hang");
            choiceGuest = Integer.parseInt(scanner.nextLine());
            switch (choiceGuest){
                case 1:
                    System.out.println("Danh sach san pham");
                    ManagerProduct.displayProduct();
                    System.out.println("--------------------------");
                    PaymentProduct.addCart(scanner);
                    break;
                case 2:

                case 3:
                    System.out.println("Danh sach san pham da mua");
                    PaymentProduct.displayCart();
                    break;

            }
        }while (choiceGuest!=5);
    }
}
