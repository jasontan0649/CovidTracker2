import java.util.Scanner;

public class Menu {
    public static int landing() {
        System.out.println("Welcome to CovidTracker \n");
        System.out.println("Please select the following option");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit Program");

        return Input.inputRange(1,3);
    }

    public static Customer login() {
        String number, password;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter phone number ");
            number = input.nextLine();
            System.out.println("Please enter password ");
            password = input.nextLine();
            Customer c = Customer.getCustByNumber(number);
            if (c == null) {
                System.out.println("No user found. \nPlease try again");
                continue;
            }
            if (c.getPassword().equals(password))
                return c;
            System.out.println("Wrong password. \nPlease try again");
        }
    }

    public static Customer signUp() {
        String name, phone, password;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter name ");
        name = input.nextLine();
        System.out.println("Please enter phone ");
        phone = input.nextLine();
        System.out.println("Please enter password ");
        password = input.nextLine();
        Customer c = new Customer(name, password, phone, "Normal");
        return c;
    }

    public static void main (Customer c) {
        while (true) {
            System.out.println("Welcome, " + c.getName() + "\n");
            System.out.println("Please select");
            System.out.println("1. Check In");
            System.out.println("2. View History");
            System.out.println("3. View Status");
            System.out.println("4. LogOut");

            int res = Input.inputRange(1,4);
            switch (res) {
                case 1 : System.out.println("Check in function");
                case 2 : System.out.println("View History function");
                case 3 : System.out.println("View status function");
                case 4 : return;
            }

            //done
        }
    }
}
