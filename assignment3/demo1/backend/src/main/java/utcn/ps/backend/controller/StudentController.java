package utcn.ps.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import utcn.ps.backend.dto.StudentDto;
import utcn.ps.backend.service.StudentService;

import java.util.List;

@Slf4j
@RestController // practic clasa aceasta va stii sa respunda la requesturi REST
@CrossOrigin
@RequestMapping(value = "/students")
@RequiredArgsConstructor // pentru ca avem service-ul
public class StudentController {
    private final StudentService studentService;

    @GetMapping()// raspunde la un http get request
    public List<StudentDto> findStudents() {
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

//    @PutMapping()
//    public StudentDto update(@RequestBody StudentDto student) {
//        return studentService.update(student);
//    }

    @DeleteMapping(value = "/{id}")
    public void remove(@PathVariable("id") Integer id) {
        studentService.remove(id);
    }
}
