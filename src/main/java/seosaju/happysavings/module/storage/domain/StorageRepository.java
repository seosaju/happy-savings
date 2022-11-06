package seosaju.happysavings.module.storage.domain;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface StorageRepository {

    Optional<Storage> findByOwnerIdAndCreationTimeBetween(String ownerId, Instant beginTime, Instant endTime);

    Storage save(Storage storage);

    Optional<Storage> findById(long storageId);

    void delete(Storage storage);

    List<Storage> findByOwnerId(String ownerId);
}
