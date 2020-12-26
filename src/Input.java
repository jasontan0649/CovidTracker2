import java.util.Scanner;

public class Input {
    public static boolean isInt(String strNum) {
        if (strNum == null)
            return false;
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int inputRange(int low, int up) {
        Scanner input = new Scanner(System.in);
        while(true){
            String resStr = input.nextLine();
            if (!isInt(resStr)) {
                System.out.println("Error, please try again");
                continue;
            }
            int res = Integer.parseInt(resStr);
            if (res >= low && res <= up)
                return  res;
            System.out.println("Error, please try again");
        }
    }

}
