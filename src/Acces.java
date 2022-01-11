import java.sql.*;
import java.util.Scanner;

public class Acces {
    int id;
    String prenom;
    String login;
    String password;
    String statut;
    int age;

    public Acces(int id, String prenom, String login, String password, String statut, int age) {
        this.id = id;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.statut = statut;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
