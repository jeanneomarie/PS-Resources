package utcn.ps.backend.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import utcn.ps.backend.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
