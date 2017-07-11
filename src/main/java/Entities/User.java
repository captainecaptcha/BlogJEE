package Entities;

import lombok.Data;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private Roles role;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private List<Entities.Blog> blogs;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public User() {

    }

    public User(String login, String password, Roles role)
    {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int Getid()
    {
        return id;
    }

    public String Getlogin()
    {
        return login;
    }

    public Roles Getrole()
    {
        return role;
    }

    public String GetPassword()
    {
        return password;
    }

    public enum Roles {
        Admin,
        User
    }
}
