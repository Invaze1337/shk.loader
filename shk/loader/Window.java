package shk.loader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import shk.Customer;

public class Window {
    public static String user;
    public static int chose1;
    public static String directoryloader = "C:/shkAntiLeak";
    public static String directoryjar = "C:/shkAntiLeak";
    public static String jar = "джарка";
    public static String archive = "архив на jdk и залупку";
    private static final Map<String, String> credentials = new HashMap();
    private static final Map<String, Customer> users = new LinkedHashMap();
    public static String command;

    public Window() {
    }

    public static void main() throws InterruptedException {
        try {
            (new ProcessBuilder(new String[]{"cmd", "/c", "title shk.xyz"})).inheritIO().start().waitFor();
        } catch (IOException | InterruptedException var18) {
            Exception var17 = var18;
            ((Exception)var17).printStackTrace();
        }

        (new File(directoryloader)).mkdirs();
        boolean filesExist = checkSpecificJarFileExist(directoryjar, "minecraft.jar");
        boolean foldersExist = checkFoldersExist(directoryloader + "/jdk", directoryloader + "/lib", directoryloader + "/assets");

        try {
            (new ProcessBuilder(new String[]{"cmd", "/c", "mode con cols=80 lines=20"})).inheritIO().start().waitFor();
        } catch (IOException | InterruptedException var17) {
            Exception var16 = var17;
            ((Exception)var16).printStackTrace();
        }

        System.out.println("░██████╗██╗░░██╗██╗░░██╗░░░██╗░░██╗██╗░░░██╗███████╗  ");
        System.out.println("██╔════╝██║░░██║██║░██╔╝░░░╚██╗██╔╝╚██╗░██╔╝╚════██║  ");
        System.out.println("╚█████╗░███████║█████═╝░░░░░╚███╔╝░░╚████╔╝░░░███╔═╝  ");
        System.out.println("░╚═══██╗██╔══██║██╔═██╗░░░░░██╔██╗░░░╚██╔╝░░██╔══╝░░  ");
        System.out.println("██████╔╝██║░░██║██║░╚██╗██╗██╔╝╚██╗░░░██║░░░███████╗  ");
        System.out.println("╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝  ");
        System.out.println();
        println("{/} Loading...", 30);
        TimeUnit.SECONDS.sleep(1L);
        println("{/} Проверка соединения с интернетом", 30);

        try {
            InetAddress inetAddress = InetAddress.getByName("www.google.com");
            if (inetAddress.isReachable(100000)) {
                TimeUnit.SECONDS.sleep(1L);
                println("{/} Соединение установлено", 30);
                print("{/} Введите никнейм: ", 30);
                user = (new Scanner(System.in)).nextLine();
                Console console = System.console();
                (new ProcessBuilder(new String[]{"cmd", "/c", "title shk.xyz"})).inheritIO().start().waitFor();
                println("{/} Авторизация прошла успешно", 30);
                println("{/} Хвид вашего пк: " + getHWID(), 10);
                println("{/} Подключение к серверу...", 30);
                InetAddress serverIp = InetAddress.getByName("127.0.0.1");
                if (serverIp.isReachable(100000)) {
                }

                TimeUnit.SECONDS.sleep(1L);
                println("{/} Соединение установлено", 30);
                println("{/} Проверка целостности файлов", 30);
                String fileName;
                String filePath;
                String line;
                BufferedReader errorStreamReader;
                int exitCode;
                Process process;
                BufferedReader inputStreamReader;
                IOException var12;
                InterruptedException var19;
                if (foldersExist && filesExist) {
                    try {
                        if (!Files.exists(Paths.get(directoryjar), new LinkOption[0])) {
                            Files.createDirectories(Paths.get(directoryjar));
                        }

                        fileName = jar.substring(jar.lastIndexOf("/") + 1);
                        filePath = directoryjar + "/" + fileName;
                        downloadFile(jar, filePath);
                    } catch (IOException var16) {
                        println("{/} Проверка фалов прошла успешно!", 30);
                        TimeUnit.SECONDS.sleep(5L);
                    }

                    println("{/} Идет запуст клиента", 37);
                    print("{/} Показывать логи в консоли? (1 - да, 2 - нет ):", 30);
                    chose1 = (new Scanner(System.in)).nextInt();
                    if (chose1 != 1 && chose1 != 2) {
                        println("{/} Произошла ошибка в выботе показов логов в консоли " + chose1, 30);
                        println("{/} Пожалуйста ответьте: " + chose1, 30);
                        println("1 - да", 30);
                        println("2 - нет", 30);
                        print("{/} this window will shutdown in 5 seconds...", 30);
                        TimeUnit.SECONDS.sleep(5L);
                    } else if (chose1 == 2) {
                        try {
                            Runtime.getRuntime().exec(command);
                        } catch (IOException var15) {
                            var12 = var15;
                            var12.printStackTrace();
                        }

                        println("{/} this window will shutdown in 5 seconds...", 30);
                        TimeUnit.SECONDS.sleep(5L);
                    } else {
                        try {
                            process = Runtime.getRuntime().exec(command);
                            inputStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                            while((line = inputStreamReader.readLine()) != null) {
                                System.out.println(line);
                            }

                            errorStreamReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

                            while((line = errorStreamReader.readLine()) != null) {
                                System.out.println(line);
                            }

                            exitCode = process.waitFor();
                            println(String.valueOf(exitCode), 5);
                        } catch (IOException var22) {
                            var12 = var22;
                            var12.printStackTrace();
                        } catch (InterruptedException var23) {
                            var19 = var23;
                            var19.printStackTrace();
                        }

                        println("{/} this window will shutdown in 5 seconds...", 30);
                        TimeUnit.SECONDS.sleep(5L);
                    }
                } else {
                    if (!foldersExist && !filesExist) {
                        println("{/} Идет скачивание файлов, подождите", 30);
                    } else {
                        println("{/} Скачаны не все файлы", 30);
                    }

                    try {
                        if (!Files.exists(Paths.get(directoryjar), new LinkOption[0])) {
                            Files.createDirectories(Paths.get(directoryjar));
                        }

                        fileName = jar.substring(jar.lastIndexOf("/") + 1);
                        filePath = directoryjar + "/" + fileName;
                        downloadFile(jar, filePath);
                        if (foldersExist && !filesExist) {
                            println("{/} 100% files will download", 30);
                        } else {
                            println("{/} 50% files will download", 30);
                        }
                    } catch (IOException var21) {
                        println("{/} Произошла ошибка во время скачивания файлов", 30);
                        println("{/} this window will shutdown in 5 seconds...", 30);
                        TimeUnit.SECONDS.sleep(5L);
                    }

                    if (!foldersExist) {
                        try {
                            if (!Files.exists(Paths.get(directoryloader), new LinkOption[0])) {
                                Files.createDirectories(Paths.get(directoryloader));
                            }

                            fileName = archive.substring(archive.lastIndexOf("/") + 1);
                            filePath = directoryloader + "/" + fileName;
                            downloadFile(archive, filePath);
                            unpackFile(filePath, directoryloader);
                            println("{/} 100% files will download ", 30);
                        } catch (IOException var14) {
                            println("{/} Произошла ошибка во время скачивания", 30);
                            println("{/} this window will shutdown in 5 seconds...", 30);
                            TimeUnit.SECONDS.sleep(5L);
                        }
                    }

                    println("{/} Клиент скачан, запускаю клиент...", 30);
                    print("{/} Показывать логи? (1 - да, 2 - нет): ", 30);
                    chose1 = (new Scanner(System.in)).nextInt();
                    if (chose1 != 1 && chose1 != 2) {
                        println("{/} Произошла ошибка в выботе показов логов в консоли " + chose1, 30);
                        println("{/} Пожалуйста ответьте: " + chose1, 30);
                        println("1 - да", 30);
                        println("2 - нет", 30);
                        print("{/} this window will shutdown in 5 seconds...", 30);
                        TimeUnit.SECONDS.sleep(5L);
                    } else if (chose1 == 2) {
                        try {
                            Runtime.getRuntime().exec(command);
                        } catch (IOException var13) {
                            var12 = var13;
                            var12.printStackTrace();
                        }

                        print("{/} this window will shutdown in 5 seconds...", 30);
                        TimeUnit.SECONDS.sleep(5L);
                    } else {
                        try {
                            process = Runtime.getRuntime().exec(command);
                            inputStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                            while((line = inputStreamReader.readLine()) != null) {
                                System.out.println(line);
                            }

                            errorStreamReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

                            while((line = errorStreamReader.readLine()) != null) {
                                System.out.println(line);
                            }

                            exitCode = process.waitFor();
                            println(String.valueOf(exitCode), 5);
                        } catch (InterruptedException var20) {
                            var19 = var20;
                            var19.printStackTrace();
                        }

                        print("{/} this window will shutdown in 5 seconds...", 30);
                        TimeUnit.SECONDS.sleep(5L);
                    }
                }
            }
        } catch (IOException var24) {
            println("{/} Отсутствует интернет соединение", 30);
            System.exit(-1);
            TimeUnit.SECONDS.sleep(5L);
        }

    }

    private static boolean checkSpecificJarFileExist(String directoryPath, String fileName) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> {
            return name.equalsIgnoreCase(fileName);
        });
        return files != null && files.length > 0;
    }

    private static boolean checkFoldersExist(String... folderPaths) {
        String[] var1 = folderPaths;
        int var2 = folderPaths.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String folderPath = var1[var3];
            File folder = new File(folderPath);
            if (!folder.isDirectory()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAdmin() {
        boolean isAdmin = false;
        Path path = Paths.get(System.getProperty("user.home"));

        try {
            isAdmin = Files.isDirectory(path, new LinkOption[0]);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return isAdmin;
    }

    public static void print(String name, int cooldown) {
        for(int i = 0; i < name.length(); ++i) {
            System.out.print(name.charAt(i));

            try {
                Thread.sleep((long)cooldown);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }
        }

    }

    public static void println(String name, int cooldown) {
        for(int i = 0; i < name.length(); ++i) {
            System.out.print(name.charAt(i));

            try {
                Thread.sleep((long)cooldown);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }
        }

        System.out.println();
    }

    public static void unpackFile(String filePath, String destinationFolder) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(Files.newInputStream(Paths.get(filePath))));
        Throwable var3 = null;

        try {
            byte[] buffer = new byte[1024];

            for(ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry()) {
                File newFile = new File(destinationFolder + File.separator + zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    if (!newFile.exists()) {
                        newFile.mkdirs();
                    }
                } else {
                    (new File(newFile.getParent())).mkdirs();
                    FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                    Throwable var8 = null;

                    try {
                        int bytesRead;
                        try {
                            while((bytesRead = zipInputStream.read(buffer)) != -1) {
                                fileOutputStream.write(buffer, 0, bytesRead);
                            }
                        } catch (Throwable var32) {
                            Throwable var31 = var32;
                            var8 = var31;
                            throw var31;
                        }
                    } finally {
                        if (fileOutputStream != null) {
                            if (var8 != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable var31) {
                                    Throwable var30 = var31;
                                    var8.addSuppressed(var30);
                                }
                            } else {
                                fileOutputStream.close();
                            }
                        }

                    }
                }
            }
        } catch (Throwable var34) {
            Throwable var33 = var34;
            var3 = var33;
        } finally {
            if (zipInputStream != null) {
                if (var3 != null) {
                    try {
                        zipInputStream.close();
                    } catch (Throwable var30) {
                        Throwable var29 = var30;
                        var3.addSuppressed(var29);
                    }
                } else {
                    zipInputStream.close();
                }
            }

        }

        File zipFile = new File(filePath);
        if (zipFile.exists()) {
            zipFile.delete();
        }

    }

    public static void downloadFile(String fileUrl, String filePath) throws IOException {
        URL url = new URL(fileUrl);
        BufferedInputStream in = new BufferedInputStream(url.openStream());
        Throwable var4 = null;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            Throwable var6 = null;

            try {
                byte[] buffer = new byte[1024];

                int bytesRead;
                while((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            } catch (Throwable var30) {
                var6 = var30;
                throw var30;
            } finally {
                if (fileOutputStream != null) {
                    if (var6 != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable var29) {
                            var6.addSuppressed(var29);
                        }
                    } else {
                        fileOutputStream.close();
                    }
                }

            }
        } catch (Throwable var32) {
            var4 = var32;
        } finally {
            if (in != null) {
                if (var4 != null) {
                    try {
                        in.close();
                    } catch (Throwable var28) {
                        var4.addSuppressed(var28);
                    }
                } else {
                    in.close();
                }
            }

        }

    }

    public static void clearConsole() throws InterruptedException {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                (new ProcessBuilder(new String[]{"cmd", "/c", "cls"})).inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception var1) {
            println("{/} Возникла неизвестная ошибка", 30);
            print("{/} Лоадер закроется через 5 секунд", 30);
            TimeUnit.SECONDS.sleep(5L);
        }

    }

    private static File extractJar(String jarPath) {
        String var10002 = System.getProperty("java.io.tmpdir");
        File tempDir = new File(var10002 + File.separator + "jar-extract");
        tempDir.mkdirs();

        try {
            ProcessBuilder pb = new ProcessBuilder(new String[]{"jar", "-xf", jarPath, "-d", tempDir.getAbsolutePath()});
            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException var4) {
            ((Exception)var4).printStackTrace();
        }

        return tempDir;
    }

    public static boolean isValidCredentials(String login, String password) {
        Customer userInfo = (Customer)users.get(login);
        return userInfo != null && userInfo.getPassword().equals(password);
    }

    public static void addUser(String login, String password) {
        String uuid = UUID.randomUUID().toString();
        users.put(login, new Customer(password, uuid));
    }

    public static String getHWID() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            StringBuilder sb = new StringBuilder();
            int count = 0;

            while(true) {
                byte[] mac;
                do {
                    if (!networkInterfaces.hasMoreElements()) {
                        String hwid = sb.toString().toLowerCase();
                        return hwid.substring(0, Math.min(count, 15));
                    }

                    NetworkInterface networkInterface = (NetworkInterface)networkInterfaces.nextElement();
                    mac = networkInterface.getHardwareAddress();
                } while(mac == null);

                for(int i = 0; i < mac.length; ++i) {
                    sb.append(String.format("%02X", mac[i]));
                }

                count += mac.length;
            }
        } catch (SocketException var5) {
            SocketException var6 = var5;
            var6.printStackTrace();
            return null;
        }
    }

    static {
        command = directoryloader + "/jdk/bin/javaw.exe -noverify -cp " + directoryloader + "/lib/*;" + directoryjar + "/minecraft.jar net.minecraft.client.main.Main -accessToken 0 --assetsDir " + directoryloader + "/assets --assetIndex 1.16 -version verify --username " + user;
    }
}
