public class Initializer {
    public static void init() {
        Customer.Deserialize();
        Shop.Deserialize();
        Visit.Deserialize();

        if(Customer.custs.isEmpty())
            preCust();

        if(Shop.shops.isEmpty())
            preShop();


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


}
