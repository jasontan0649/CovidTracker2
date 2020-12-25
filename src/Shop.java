import java.io.Serializable;

public class Shop implements Serializable, Role{
    private static int count = 0;

    private int id;

    private String password;
    private String name;
    private String phone;
    private String status;
    private String manager;



}
