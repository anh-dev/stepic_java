package dataset;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserDataSet implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "login", unique = true, updatable = false)
    private  String login;

    @Column(name = "password")
    private  String password;

    public UserDataSet(){

    }

    public UserDataSet(String login, String pass) {
        this.login = login;
        this.password = pass;

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
