package seosaju.happysavings.infra.happy_memory;

import org.springframework.data.jpa.repository.JpaRepository;
import seosaju.happysavings.domain.happy_memory.Storage;
import seosaju.happysavings.domain.happy_memory.StorageRepository;

public interface JpaStorageRepository extends JpaRepository<Storage, Long>, StorageRepository {
}
