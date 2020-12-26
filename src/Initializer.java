import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Initializer {
    public static void init() {
        Customer.Deserialize();
        Shop.Deserialize();
        Visit.Deserialize();

        if(Customer.custs.isEmpty())
            preCust();

        if(Shop.shops.isEmpty())
            preShop();

        if(Visit.visits.isEmpty())
            preVisit();


    }

    public static void preCust() {
        new Customer("Johnson Smith","jsmith","0123456789","Normal");
        new Customer("Jackson Teng","jteng","0124567890","Normal");
        new Customer("Ahmad Mohd","mohdamd","0191234567","Normal");
        new Customer("Tan Ah Beng","ahbeng","0133456789","Normal");
        new Customer("Lim Ah Chong","ahchong","0183456789","Normal");
    }

    public static void preShop() {
        new Shop("KFC", "delicious","0312345678","Normal","Ken");
        new Shop("Texas", "chicken","0322345678","Normal","John");
        new Shop("Basket Robbin", "icecream","0332345678","Normal","Smith");
        new Shop("llaollao", "llaollao","0342345678","Normal","Elson");
    }

    public static void preVisit() {
        LocalDateTime[] randomDTs = timeGene();
        final Random random = new Random();
        int CustAmt = Customer.custs.size();
        int ShopAmt = Shop.shops.size();

        for (int i = 0; i < 30; i++) {
            Customer randomCust = Customer.custs.get(random.nextInt(CustAmt));
            Shop randomShop = Shop.shops.get(random.nextInt(ShopAmt));
            new Visit(randomDTs[i], randomCust.getId(), randomShop.getId());
        }
    }

    public static LocalDateTime[] timeGene() {
        final Random random = new Random();
        final int millisInDay = 24*60*60*1000;

        LocalDateTime[] randomDTs = new LocalDateTime[30];
        long[] diffSec = new long[30];
        LocalDateTime dt = LocalDateTime.now();
        long curTime = dt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        for (int i = 0; i < 30; i++)
            diffSec[i] = random.nextInt(millisInDay);
        Arrays.sort(diffSec);
        for (int i = 0; i < 30; i++) {
            long newDT = curTime - diffSec[29-i];
            randomDTs[i] = LocalDateTime.ofInstant(Instant.ofEpochMilli(newDT), ZoneId.systemDefault());
        }

        return randomDTs;
    }


}
