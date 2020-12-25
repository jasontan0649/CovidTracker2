import java.io.*;
import java.util.ArrayList;

public class Shop implements Serializable, Role{
    public static ArrayList<Shop> shops = new ArrayList<Shop>();

    private static int count = 0;

    private int id;

    private String password;
    private String name;
    private String phone;
    private String status;
    private String manager;

    public Shop(String name, String password, String phone, String status, String manager) {
        this.id = ++count;
        setPassword(password);
        setName(name);
        setPhone(phone);
        setStatus(status);
        setManager(manager);
    }

    private static void Serialize() {
        try {
            FileOutputStream fos = new FileOutputStream("Shops.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(shops);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Deserialize() {
        shops.clear();
        try {
            FileInputStream fis = new FileInputStream("Shops.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            shops = (ArrayList) ois.readObject();
            count = shops.size();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            return; //No serialization found
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }




}
