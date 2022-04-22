package utcn.ps.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import utcn.ps.backend.dto.StudentDto;
import utcn.ps.backend.event.BaseEvent;
import utcn.ps.backend.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final SimpMessagingTemplate messagingTemplate; // used for publishing to the topic

    @GetMapping()
    public List<StudentDto> findStudents() {
        //throw new NullPointerException();
        return studentService.findAll();
    }

    @GetMapping(value = "/{id}")
    public StudentDto findStudentById(@PathVariable("id") Integer id) {// cu PV stie ca trebuie sa ia din path variabila
        return studentService.findById(id);
    }

    @PostMapping()
    public StudentDto insert(@RequestBody StudentDto studentDto) { // anotatia de RB ii spune lui Spring ca hei ia acest studentDto din body
        return studentService.insert(studentDto);
    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable("id") Integer id) {
        studentService.remove(id);
    }

    @EventListener(BaseEvent.class)
    public void handleEvent(BaseEvent event) {
        log.info("Got an event: {}.", event);
        messagingTemplate.convertAndSend("/topic/events", event);
    }
}
