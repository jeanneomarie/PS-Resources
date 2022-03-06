package utcn.ps.assignment1demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import utcn.ps.assignment1demo.entity.Question;
import utcn.ps.assignment1demo.exception.QuestionNotFoundException;
import utcn.ps.assignment1demo.service.QuestionService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
// Command line runners are executed by Spring after the initialization of the app has been done
// https://www.baeldung.com/spring-boot-console-app
public class ConsoleController implements CommandLineRunner {
    private final Scanner scanner = new Scanner(System.in);
    private final QuestionService questionService;

    @Override
    public void run(String... args) {
        print("Welcome to my awesome reinterpretation of StackOverflow.");
        boolean done = false;
        while (!done) {
            print("Enter a command: ");
            String command = scanner.next().trim();
            try {
                done = handleCommand(command);
            } catch (QuestionNotFoundException questionNotFoundException) {
                print("The question with the given ID was not found!");
            }
        }
    }

    private boolean handleCommand(String command) {
        switch (command) {
            case "list":
                handleList();
                return false;
            case "insert":
                handleInsert();
                return false;
            case "remove":
                handleRemove();
                return false;
            case "exit":
                return true;
            default:
                print("Unknown command. Try again.");
                return false;
        }
    }

    private void handleList() {
        questionService.findAll().forEach(question -> print(question.toString()));
    }

    private void handleInsert() {
        print("Title:");
        String title = scanner.next().trim();
        print("Body:");
        String body = scanner.next().trim();
        Question question = questionService.insert(new Question(title, body));
        print("Created question: " + question + ".");
    }

    private void handleRemove() {
        print("Question ID:");
        int id = scanner.nextInt();
        questionService.remove(id);
    }

    private void print(String value) {
        System.out.println(value);
    }
}
