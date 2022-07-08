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
    }
}
