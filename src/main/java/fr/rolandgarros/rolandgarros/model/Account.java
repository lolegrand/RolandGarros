package fr.rolandgarros.rolandgarros.model;

public class Account {
    private final String password;

    private final String login;

    private final Role role;

    public Account(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public Role getRole() {
        return role;
    }
}
