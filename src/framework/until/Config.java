package framework.until;

import framework.resources.PropertiesData;

import java.util.HashMap;


public final class Config {
    private String language;
    private String buffSize;
    private String countOffUsers;
    private HashMap<String, String> fileData;
    private PropertiesData property;

    private static final Config instance = new Config();

    private Config() {
        fileData = Data.getData("src\\framework\\resources\\configuration.txt");
        property = PropertiesData.getPropertiesData();
    }

    public void init() {
        language = fileData.get(property.getLanguageKey());
        buffSize = fileData.get(property.getBuffSizeKey());
        countOffUsers = fileData.get(property.getCountOffUsersKey());
    }

    public static Config getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "Config : " +
                "language = " + language  +
                ", buffSize = " + buffSize +
                ", countOffUsers = " + countOffUsers ;
    }


}
