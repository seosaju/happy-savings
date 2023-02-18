package seosaju.happysavings.infra.happy_memory;

import org.springframework.data.jpa.repository.JpaRepository;
import seosaju.happysavings.domain.happy_memory.Memory;
import seosaju.happysavings.domain.happy_memory.MemoryRepository;

public interface JpaMemoryRepository extends JpaRepository<Memory, Long>, MemoryRepository {
}
