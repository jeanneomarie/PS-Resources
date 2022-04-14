package utcn.ps.backend.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import utcn.ps.backend.entity.Grade;
import utcn.ps.backend.entity.Student;
import utcn.ps.backend.entity.Teacher;
import utcn.ps.backend.persistance.GradeRepository;
import utcn.ps.backend.persistance.StudentRepository;
import utcn.ps.backend.persistance.TeacherRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationSeed implements CommandLineRunner {
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    @Override
    @Transactional
    public void run(String... args) {
        if (teacherRepository.findAll().isEmpty()) {
            Teacher teacher1 = new Teacher(0, "teacher1", "password1");
            teacherRepository.save(teacher1);

            Student student1 = new Student(0, "FirstName1", "LastName1", new ArrayList<>());
            studentRepository.save(student1);

            Student student2 = new Student(0, "FirstName2", "LastName2", new ArrayList<>());
            studentRepository.save(student2);

            Student student3 = new Student(0, "FirstName3", "LastName3", new ArrayList<>());
            studentRepository.save(student3);

            List<Grade> grades = Arrays.asList(
                    new Grade(0, 8, LocalDate.now(), teacher1),
                    new Grade(0, 9, LocalDate.now(), teacher1),
                    new Grade(0, 10, LocalDate.now(), teacher1)
            );
            gradeRepository.saveAll(grades);

            student1.setGrades(grades);
        }
    }
}
