package helpme.Netflix.Repository;

import helpme.Netflix.DAO.Overview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverViewRepository extends JpaRepository<Overview, Long> {
}
