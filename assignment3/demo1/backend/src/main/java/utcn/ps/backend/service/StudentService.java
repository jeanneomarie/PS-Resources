package utcn.ps.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utcn.ps.backend.persistance.StudentRepository;
import utcn.ps.backend.dto.StudentDto;
import utcn.ps.backend.entity.Student;
import utcn.ps.backend.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public StudentDto findById(Integer id){
        return StudentDto.studentDtoFromStudent(studentRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Transactional
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(StudentDto::studentDtoFromStudent).collect(Collectors.toList());
    }

    @Transactional
    public StudentDto insert(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setGrades(new ArrayList<>());
        return StudentDto.studentDtoFromStudent(studentRepository.save(student));
    }

//    @Transactional
//    public StudentDto update(StudentDto studentDto) {
//        Student student = new Student();
//        student.setFirstName(studentDto.getFirstName());
//        student.setLastName(studentDto.getLastName());
//        return StudentDto.studentDtoFromStudent(studentRepository.save(student));
//    }

    @Transactional
    public void remove(int id) {
        Student student = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        studentRepository.delete(student);
    }
}
