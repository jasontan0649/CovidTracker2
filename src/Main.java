import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Initializer.init();
        while (true) {
            int choice = Menu.landing();
            Customer cust = null;
            if (choice == 1)
                cust = Menu.login();
            else if (choice == 2)
                cust = Menu.signUp();
            else
                return;
            Menu.main(cust);
        }
    }
}
