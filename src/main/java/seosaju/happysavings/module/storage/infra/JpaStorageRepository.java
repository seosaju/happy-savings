package seosaju.happysavings.module.storage.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import seosaju.happysavings.module.storage.domain.Storage;
import seosaju.happysavings.module.storage.domain.StorageRepository;

public interface JpaStorageRepository extends JpaRepository<Storage, Long>, StorageRepository {
}
