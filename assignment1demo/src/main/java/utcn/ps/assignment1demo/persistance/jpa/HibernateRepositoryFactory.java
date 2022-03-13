package utcn.ps.assignment1demo.persistance.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import utcn.ps.assignment1demo.persistance.api.QuestionRepository;
import utcn.ps.assignment1demo.persistance.api.RepositoryFactory;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Component
@ConditionalOnProperty(name = "repository-type", havingValue = "JPA")
public class HibernateRepositoryFactory implements RepositoryFactory {
	private final EntityManager entityManager;

	@Override
	public QuestionRepository createQuestionRepository() {
		return new HibernateQuestionRepository(entityManager);
	}
}
