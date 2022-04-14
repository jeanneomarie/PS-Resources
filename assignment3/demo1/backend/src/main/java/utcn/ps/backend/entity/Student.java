package utcn.ps.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "firstName", "lastName"})
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private List<Grade> grades;
}
