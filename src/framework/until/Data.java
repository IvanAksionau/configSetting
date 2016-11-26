package framework.until;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * Используя Singleton, создайте класс Config.
 * Который не позволит создать больше чем одну конфигурацию программы, которая храниться в файле.
 * Текстовый файл "config.txt" со строками типа "ключ=значение" хранит в себе настройки вашей программы.
 * Например : Interfacelanguage = EN
 * Используйте для загрузки и обращения к файлу:
 * FileInputStream stream = new FileInputStream(new File("config.txt"));
 * для возможности "втянуть" значение по ключу:
 * java.util.Properties
 */
public class Data {

    public static HashMap<String, String> getData(String path) {
        File dataFile = new File(path);
        HashMap<String, String> dataMap = new HashMap<>();
        if (!dataFile.isDirectory()) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(dataFile), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String key = line.substring(0, line.indexOf("="));
                    String value = line.substring(line.indexOf('=') + 1);
                    dataMap.put(key, value);
                }
            } catch (IOException e) {
                System.out.println("File not found or incorrect path");
            }
        }
        return dataMap;
    }


}

