package utcn.ps.assignment1demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import utcn.ps.assignment1demo.entity.Question;
import utcn.ps.assignment1demo.service.QuestionService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping()
    public List<Question> findQuestions() {
        return questionService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Question findQuestionById(@PathVariable("id") Integer id){
        return questionService.findById(id);
    }

    @PostMapping()
    public Question insert(@RequestBody Question question){
        return questionService.insert(question);
    }

    @PutMapping()
    public Question update(@RequestBody Question question) {
        return questionService.update(question);
    }

    @DeleteMapping(value="/{id}")
    public void remove(@PathVariable("id") Integer id){
        questionService.remove(id);
    }
}
