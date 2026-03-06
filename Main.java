import shk.loader.WebOpen;
import shk.loader.Window;

import java.util.concurrent.TimeUnit;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws InterruptedException {
        new Window();
        new WebOpen();
        WebOpen.main();
        Window.main();
    }

    public static void println(String name, int cooldown) throws InterruptedException {
        for(int i = 0; i < name.length(); ++i) {
            System.out.println(" ");
            TimeUnit.SECONDS.sleep((long)cooldown);
        }

    }
}
