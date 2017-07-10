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

    @ManyToOne
    private User user;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "blog")
    private List<Article> articles;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", name='" + name+ '\'' +
                '}';
    }
}
