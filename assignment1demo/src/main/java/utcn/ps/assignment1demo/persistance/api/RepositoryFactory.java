package utcn.ps.assignment1demo.persistance.api;

/*
    this is a functional interface at the moment
    functional interfaces were introduced from java 8 and only have one method
    see https://www.geeksforgeeks.org/functional-interfaces-java/?ref=gcse
*/
//@FunctionalInterface
public interface RepositoryFactory {

    QuestionRepository createQuestionRepository();

}
