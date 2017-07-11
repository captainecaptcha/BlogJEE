package Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private boolean isArchived;

    @ManyToOne
    private User user;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "blog")
    private List<Article> articles;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", name='" + name+ '\'' +
                '}';
    }
}
