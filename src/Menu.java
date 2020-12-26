import java.util.Scanner;

public class Menu {
    public static int landing() {
        System.out.println("Welcome to CovidTracker \n");
        System.out.println("Please select the following option");
        System.out.println("1. Login");
        System.out.println("2. Sign Up");

        return Input.inputRange(1,2);
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
        Customer cust = Customer.custs.get(0); //test
        return cust;
    }

}
