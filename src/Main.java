import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Initializer.init(); //Deserialize aka load all the data

       /*
        Shop.Deserialize();
        Shop test = new Shop("KFC Puchong", "delicious", "0380802323", "Normal", "Ben");
        for (Shop s : Shop.shops)
            System.out.println(s);

        */
        Visit test = new Visit(4,3);
        for (Visit v : Visit.visits)
            System.out.println(v + ", " + v.getTime() + ", " + v.getDate());



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
