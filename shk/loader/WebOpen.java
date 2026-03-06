package shk.loader;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebOpen {
    public WebOpen() {
    }

    public static void main() throws InterruptedException {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI("https://shk.ru"));
                Desktop.getDesktop().browse(new URI("https://discord.gg/999N3bPcaC"));
            }

        } catch (IOException var1) {
            IOException e = var1;
            throw new RuntimeException(e);
        } catch (URISyntaxException var2) {
            URISyntaxException e = var2;
            throw new RuntimeException(e);
        }
    }
}
