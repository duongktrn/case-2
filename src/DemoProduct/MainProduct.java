package DemoProduct;

import Acount.ManagerAdmin;
import Acount.UserAdmin;
import Menu.Menu;
import Product.ManagerProduct;
import ProductService.PaymentProduct;

import java.text.NumberFormat;
import java.util.Locale;

public class MainProduct {
    public static void main(String[] args) {
        PaymentProduct.readCart();
        ManagerProduct.readProduct();
        ManagerProduct.readCatolog();
        ManagerAdmin.creatAdmin();
        Menu.Acount();

//        double vnd = 100000000;

//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
//        String str1 = currencyVN.format(vnd);
//        System.out.println("Số " + vnd + " sau khi định dạng = " + str1);
//        System.out.println("Kiểu đơn vị tiền tệ của " + localeVN.getCountry() +
//                " là " + currencyVN.getCurrency());
    }
}
