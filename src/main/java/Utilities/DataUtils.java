package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {
    public final static String Test_Data_path = "src/test/resources/TestData/";

    public static String getJsonData(String jsonFileName, String field) {
        try {
            // Define object of file reader
            FileReader reader = new FileReader(Test_Data_path + jsonFileName + ".json");
            // Parse the Json directly into a JsonElement
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return jsonElement.getAsJsonObject().get(field).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getPropertyValue(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(Test_Data_path + fileName + ".properties"));
        return properties.getProperty(key);
    }
}
