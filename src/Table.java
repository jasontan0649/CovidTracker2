import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private static int[] maxColLen(ArrayList<String> metadata, ArrayList<HashMap<String, String>> data) {
        int[] res = new int[metadata.size()];

        for (int i = 0; i < metadata.size(); i++)
            res[i] = metadata.get(i).length();

        for (int i = 0; i < data.size(); i++)
            for (int j = 0; j < metadata.size(); j++)
                res[j] = Math.max(res[j], data.get(i).get(metadata.get(j)).length());


        return res;
    }

    private static String getLine(int[] cMaxLen, ArrayList<String> colString) {
        String[] newColString = new String[colString.size()];
        for (int i = 0; i < colString.size(); i++) {
            int rightSpace = cMaxLen[i] - colString.get(i).length();
            newColString[i] = colString.get(i) + " ".repeat(rightSpace);
        }

        return String.join("  ", newColString);
    }


    public static void display(String title, DataContainer dataContainer) {
        ArrayList<String> metadata = dataContainer.metadata;
        ArrayList<HashMap<String, String>> data = dataContainer.data;

        if (!title.isEmpty())
            System.out.println(title + "\n");

        int[] cMaxLen = maxColLen(metadata, data);

        System.out.println(getLine(cMaxLen, metadata));

        for (HashMap<String, String> d : data) {
            ArrayList<String> tmpList = new ArrayList<String>();
            for (String item : metadata)
                tmpList.add(d.get(item));
            System.out.println(getLine(cMaxLen, tmpList));
        }
    }
}
