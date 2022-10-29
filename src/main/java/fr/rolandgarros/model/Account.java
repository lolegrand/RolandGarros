package fr.rolandgarros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAccount = 0;

    @Column(name = "password", nullable = false)
    private  String password;

    @Column(name = "login",unique = true)
    private  String login;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private  Role role;



    public Account(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Account() {

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

    public Integer getIdAccount() {
        return idAccount;
    }
}
