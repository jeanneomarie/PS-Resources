package utcn.ps.backend.dto;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import utcn.ps.backend.entity.Grade;
import utcn.ps.backend.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    public static StudentDto studentDtoFromStudent(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());

        if (!CollectionUtils.isEmpty(student.getGrades())) {
            studentDto.setGrades(student.getGrades().stream()
                    .map(Grade::getScore)
                    .collect(Collectors.toList()));
        } else {
            studentDto.setGrades(new ArrayList<>());
        }

        return studentDto;
    }
}
