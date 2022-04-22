package utcn.ps.backend.event;

import lombok.Data;
import utcn.ps.backend.dto.StudentDto;

@Data
public class StudentCreatedEvent extends BaseEvent {
    private final StudentDto student;

    public StudentCreatedEvent(StudentDto student) {
        super(EventType.STUDENT_CREATED);
        this.student = student;
    }
}
