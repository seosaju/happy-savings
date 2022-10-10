package seosaju.happysavings.module.paper.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import seosaju.happysavings.module.paper.domain.Paper;
import seosaju.happysavings.module.paper.domain.PaperRepository;

public interface JpaPaperRepository extends JpaRepository<Paper, Long>, PaperRepository {
}
