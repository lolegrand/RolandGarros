package fr.rolandgarros.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAccount;

    private  String password;

    @Column(unique = true)
    private  String login;

    @Enumerated(EnumType.STRING)
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
