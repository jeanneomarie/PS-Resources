package utcn.ps.backend.entity;

import lombok.*;
import utcn.ps.backend.entity.Teacher;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "score", "date"})
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int score;

    private LocalDate date;

    @ManyToOne
    @JoinColumn
    private Teacher teacher;
}
