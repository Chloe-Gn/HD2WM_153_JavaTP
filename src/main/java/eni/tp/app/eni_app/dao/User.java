package eni.tp.app.eni_app.dao;

public class User {

    public String email;
    public long id;
    public String password;


    public User(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String email, long id) {
        this.email = email;
        this.id = id;
    }

    public User(String email, long id, String password) {
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
