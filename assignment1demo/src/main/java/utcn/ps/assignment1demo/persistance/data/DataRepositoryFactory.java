package utcn.ps.assignment1demo.persistance.data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import utcn.ps.assignment1demo.persistance.api.RepositoryFactory;

@RequiredArgsConstructor
@Component
@ConditionalOnProperty(name = "repository-type", havingValue = "DATA")
public class DataRepositoryFactory implements RepositoryFactory {
	private final DataQuestionRepository dataQuestionRepository;

	@Override
	public DataQuestionRepository createQuestionRepository() {
		return dataQuestionRepository;
	}
}
