package fr.rolandgarros.model;

import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

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
        this.password = this.hash(password);
        this.role = role;
    }

    public Account() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = this.hash(password);
    }

    public String getLogin() {
        return login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    private  String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public  boolean verifyHash(String password) {
        return BCrypt.checkpw(password, this.password);
    }


    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", password='" + password +
                ", login='" + login ;
    }
    @Override
    public boolean equals(Object o) {

        if (o == null || this == null) {
            return false;
        }

        if (o instanceof Account) {
            Account account = (Account) o;
            return this.login.equals(account.getLogin()) && this.verifyHash(account.getPassword()) && this.idAccount.equals(account.getIdAccount()) && this.role.equals(account.getRole());
        }

        return false;

    }

}
