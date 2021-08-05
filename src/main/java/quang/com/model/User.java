package quang.com.model;

public class User {
    private int id_user;
    private String user_name;
    private String password;
    private String email;
    private String phone_number;
    private int id_role;

    public User() {
    }

    public User(int id_user, String user_name, String password, String email, String phone_number, int id_role) {
        this.id_user = id_user;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.id_role = id_role;
    }

    public User(int id_user, String user_name, String password) {
        this.id_user = id_user;
        this.user_name = user_name;
        this.password = password;
    }

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
}
