package utcn.ps.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utcn.ps.backend.entity.Teacher;
import utcn.ps.backend.service.TeacherUserDetailsService;

@RestController()
@RequestMapping(value = "/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherUserDetailsService teacherUserDetailsService;

    @GetMapping("/me")
    public Teacher loadCurrentTeacher() {
        return teacherUserDetailsService.loadCurrentTeacher();
    }
}
