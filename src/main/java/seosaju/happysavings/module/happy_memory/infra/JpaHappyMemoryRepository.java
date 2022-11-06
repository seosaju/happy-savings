package seosaju.happysavings.module.happy_memory.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import seosaju.happysavings.module.happy_memory.domain.HappyMemory;
import seosaju.happysavings.module.happy_memory.domain.HappyMemoryRepository;

public interface JpaHappyMemoryRepository extends JpaRepository<HappyMemory, Long>, HappyMemoryRepository {
}
