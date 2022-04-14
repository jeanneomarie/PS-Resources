package utcn.ps.backend.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import utcn.ps.backend.entity.Teacher;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByUsername(String username);
}
