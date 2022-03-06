package utcn.ps.assignment1demo.service;

import org.junit.Assert;
import org.junit.Test;
import utcn.ps.assignment1demo.entity.Question;
import utcn.ps.assignment1demo.persistance.api.RepositoryFactory;
import utcn.ps.assignment1demo.persistance.memory.InMemoryRepositoryFactory;

public class QuestionServiceTests {

    private static RepositoryFactory createMockedFactory() {
        RepositoryFactory factory = new InMemoryRepositoryFactory();
        factory.createQuestionRepository().save(new Question(1, "Title1", "Body1"));
        factory.createQuestionRepository().save(new Question(2, "Title2", "Body2"));
        return factory;
    }

    @Test
    public void addQuestionTest() {
        RepositoryFactory factory = createMockedFactory();

        factory.createQuestionRepository().save(new Question(3, "Title3", "Body3"));

        Question question = new Question(3, "Title3", "Body3");

        Question foundQuestion = factory.createQuestionRepository().findById(3).get();

        Assert.assertEquals(foundQuestion, question);
    }

    @Test
    public void findAllTest() {
        RepositoryFactory factory = createMockedFactory();

        Assert.assertEquals(factory.createQuestionRepository().findAll().size(), 2);
    }

}