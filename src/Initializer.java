public class Initializer {
    public static void init() {
        Customer.Deserialize();
        Shop.Deserialize();
        Visit.Deserialize();
    }
}
