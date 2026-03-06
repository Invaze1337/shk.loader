package shk;

public class Customer {
    private String password;
    private String uuid;

    public Customer(String password, String uuid) {
        this.password = password;
        this.uuid = uuid;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUUID() {
        return this.uuid;
    }

    public static String getUserGroup(String login) {
        return "Invaze".equals(login) | "customer".equals(login) ? "Admin" : "User";
    }
}