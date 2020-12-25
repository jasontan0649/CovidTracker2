import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CSV {
    public static void export(String filename, DataContainer dataContainer) {
        ArrayList<String> metadata = dataContainer.metadata;
        ArrayList<HashMap<String, String>> data = dataContainer.data;

        String res = String.join(",", metadata);

        for (HashMap<String, String> d : data) {
            ArrayList<String> tmpList = new ArrayList<String>();
            for (String item : metadata)
                tmpList.add(d.get(item));
            res += "\n" + String.join(",", tmpList);
        }

        //Create file
        try{
            File f = new File(filename+".csv");
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Write file
        try {
            FileWriter f = new FileWriter(filename+".csv");
            f.write(res);
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
