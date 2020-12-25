import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Customer.Deserialize();
        Customer test = new Customer("Test", "2", "2", "Normal");

        for (Customer cust : Customer.custs)
            System.out.println(cust);

        /*
        DataContainer test = new DataContainer();
        test.metadata.add("ID");
        test.metadata.add("Name");
        test.data.add(new HashMap<String, String>());
        test.data.get(0).put("ID", "1");
        test.data.get(0).put("Name", "Jason");
        test.data.add(new HashMap<String, String>());
        test.data.get(1).put("ID", "2");
        test.data.get(1).put("Name", "Johnson");

        Table.display("Tester", test);
        CSV.export("Tester", test);
        */


    }
}
