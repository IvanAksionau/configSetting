package framework.until;

/**
 * Created by Ivan on 26.11.2016.
 */
public class Main {


    public static void main(String[] args) {
        Config config = Config.getInstance();
        config.init();
        System.out.println(config);
    }
}
