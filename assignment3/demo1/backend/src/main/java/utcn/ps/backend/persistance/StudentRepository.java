package utcn.ps.backend.persistance;


import org.springframework.data.jpa.repository.JpaRepository;
import utcn.ps.backend.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
