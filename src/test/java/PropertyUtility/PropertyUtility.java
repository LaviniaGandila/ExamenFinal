package PropertyUtility;


import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//aceasta clasa reprezinta interactiunea cu un fisier de proprietati
//trebuie sa facem o metoda care sa incarce un fisier
//trebuie sa facem o metoda care sa citeasca toate datele dintr-un fisier
public class PropertyUtility {
    //primul obiect reprezinta extensia
    private Properties properties;

    private FileInputStream fileInputStream;
    //o sa trebuiasca sa facem o clasa

    public PropertyUtility(String path) {
        loadFile(path);
    }

    private void loadFile (String path) {
        properties=new Properties();
        try {
            fileInputStream=new FileInputStream("src/test/resources/InputData/" + path + ".properties");
            properties.load(fileInputStream);
        } catch (Exception e) {
            }
    }

    public Map<String,String> getAllData () {
        Map<String, String> testData = new HashMap<>();
        for (String key: properties.stringPropertyNames()){
            testData.put(key, properties.getProperty(key));
        }
        return testData;
    }
}
