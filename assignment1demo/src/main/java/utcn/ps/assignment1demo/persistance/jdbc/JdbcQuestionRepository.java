package utcn.ps.assignment1demo.persistance.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import utcn.ps.assignment1demo.entity.Question;
import utcn.ps.assignment1demo.persistance.api.QuestionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcQuestionRepository implements QuestionRepository {
    /*
        template.query  - when we want to read from the database
        template.update - when we want to modify the database (eg: delete, insert, update)
        The Jdbc template is a helper class for doing JDBC operations (usually "templates" simplify common tasks)
        see https://spring.io/guides/gs/relational-data-access/
    */
    private final JdbcTemplate template;

    @Override
    public Question save(Question question) {
        if (question.getQuestionId() != null) {
            update(question);
        } else {
            Integer id = insert(question);
            question.setQuestionId(id);
        }

        return question;
    }

    @Override
    public Optional<Question> findById(int id) {
        // bad approach because of sql injection
        // template.query("SELECT * FROM question WHERE question_id = " + question_id,..);

        // therefore it is better to use a placeholder
        List<Question> questions = template.query("SELECT * FROM question WHERE question_id = ?",
                ((resultSet, i) -> new Question(resultSet.getInt("question_id"),
                        resultSet.getString("title"),
                        resultSet.getString("body"))),
                id);

        if (questions.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(questions.get(0));
        }

        // return questions.isEmpty() ? Optional.empty() : Optional.of(questions.get(0));
    }

    @Override
    public void remove(Question question) {
        template.update("DELETE FROM question WHERE question_id = ?", question.getQuestionId());
    }

    @Override
    public List<Question> findAll() {
        return template.query("SELECT * FROM question",
                (resultSet, i) -> new Question(resultSet.getInt("question_id"),
                        resultSet.getString("title"),
                        resultSet.getString("body")));
    }

    private int insert(Question question) {
        // we use the SimpleJdbcInsert to easily retrieve the generated ID
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("question");
        insert.usingGeneratedKeyColumns("question_id");

        // String for the column's name
        // Object for the column's inserted value
        Map<String, Object> data = new HashMap<>();
        data.put("title", question.getTitle());
        data.put("body", question.getBody());

        return insert.executeAndReturnKey(data).intValue();
    }

    private void update(Question question) {
        template.update("UPDATE question SET title = ?, body = ? WHERE question_id = ?",
                question.getTitle(),
                question.getBody(),
                question.getQuestionId());
    }
}
