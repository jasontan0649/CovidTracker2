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

            int choice = Input.inputRange(1,4);
            switch (choice) {
                case 1 : checkIn(c); break;
                case 2 : viewHistory(c); break;
                case 3 : viewStatus(c); break;
                case 4 : return;
            }
            //done
        }
    }
    
    public static void checkIn(Customer c) {
        System.out.println("Please select shop");
        for (int i = 0; i < Shop.shops.size(); i++)
            System.out.println(i+1 + ". " + Shop.shops.get(i).getName());
        int choice = Input.inputRange(1, Shop.shops.size());

        new Visit(c.getId(), choice);
        System.out.println("New visit created \nPress 1 to continue");
        Input.inputRange(1,1);
    }
    
    public static void viewHistory(Customer c) {
        Report rpt = new Report(c);
        rpt.display();
        System.out.println("\n\nDo you want to export to CSV ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = Input.inputRange(1,2);
        if (choice == 1)
            rpt.exportCSV();
    }
    
    public static void viewStatus(Customer c) {
        System.out.println("Your status is " + c.getStatus());
        System.out.println("Press 1 to continue");
        Input.inputRange(1,1);
    }
    
}
