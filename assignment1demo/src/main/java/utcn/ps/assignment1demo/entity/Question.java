package utcn.ps.assignment1demo.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Integer questionId;
    private String title;
    private String body;

    public Question(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
