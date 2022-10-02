package seosaju.happysavings.module.storage.domain;

import java.time.Instant;
import java.util.Optional;

public interface StorageRepository {

    Optional<Storage> findByUserIdAndCreationTimeBetween(String userId, Instant beginTime, Instant endTime);

    Storage save(Storage storage);
}
