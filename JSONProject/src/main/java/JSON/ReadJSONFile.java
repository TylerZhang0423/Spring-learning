package JSON;

import java.io.*;
import org.json.JSONException;


public class ReadJSONFile {
    public static void main (String[] args) throws IOException , JSONException {
        String result = "";
        try {
            FileInputStream fis = new FileInputStream("/Users/tyler/Desktop/Spring-learning/JSONProject/src/main/java/JSON/student.json");
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader in  = new BufferedReader(inputStreamReader);

            String str;
            while ((str = in.readLine()) != null) {
                result = result + str;
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }

        System.out.println(result);
    }
}
