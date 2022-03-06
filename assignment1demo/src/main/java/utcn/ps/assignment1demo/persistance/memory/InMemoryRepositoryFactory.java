package utcn.ps.assignment1demo.persistance.memory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import utcn.ps.assignment1demo.persistance.api.QuestionRepository;
import utcn.ps.assignment1demo.persistance.api.RepositoryFactory;

@Component
@ConditionalOnProperty(name = "repository-type", havingValue = "MEMORY")
public class InMemoryRepositoryFactory implements RepositoryFactory {

    private final InMemoryQuestionRepository inMemoryQuestionRepository = new InMemoryQuestionRepository();

    @Override
    public QuestionRepository createQuestionRepository() {
        return inMemoryQuestionRepository;
    }
}
