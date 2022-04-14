package utcn.ps.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utcn.ps.backend.entity.Student;
import utcn.ps.backend.exception.NotFoundException;
import utcn.ps.backend.persistance.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    @Transactional
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void remove(int id) {
        Student student = studentRepository.findById(id).orElseThrow(NotFoundException::new);
        studentRepository.delete(student);
    }
}
