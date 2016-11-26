package framework.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public final class PropertiesData {
    private Properties property;
    private FileInputStream fis;
    private static final PropertiesData instance = new PropertiesData();

    private PropertiesData() {
        property = new Properties();
        try {
            fis = new FileInputStream("C:\\Users\\Ivan\\IdeaProjects\\configPro\\configurationName.properties");
            property.load(fis);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }

    public static PropertiesData getPropertiesData(){
        return instance;
    }

    public String getLanguageKey(){
        return property.getProperty("LanguageKey");
    }
    public String getBuffSizeKey(){
        return property.getProperty("BuffSizeKey");
    }
    public String getCountOffUsersKey(){
        return property.getProperty("CountOffUsersKey");
    }
}
