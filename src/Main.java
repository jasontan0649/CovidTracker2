import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Initializer.init(); //Deserialize aka load all the dat

        Customer c1 = new Customer("T","1","2","N");
        Shop c2 = new Shop("n","2","2","s","w");
        Visit n1 = new Visit(c1.getId(),1);
        Visit n2 = new Visit(c1.getId(),1);
        Visit n3 = new Visit(c1.getId(),1);

        Report rpt = new Report(c1);
        rpt.display();
        rpt.exportCSV();

    }
}
