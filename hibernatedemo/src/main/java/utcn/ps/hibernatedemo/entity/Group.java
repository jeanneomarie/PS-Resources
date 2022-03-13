package utcn.ps.hibernatedemo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "year", "name"})
@Entity
@Table(name = "class")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer year;
    private Integer name;

    @OneToMany
    @JoinColumn
    private List<Student> students;

    // https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
    @ManyToMany(mappedBy = "groups")
    private List<Teacher> teachers;
}
