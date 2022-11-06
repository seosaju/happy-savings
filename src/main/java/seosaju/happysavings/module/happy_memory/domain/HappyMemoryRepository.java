package seosaju.happysavings.module.happy_memory.domain;

import java.util.List;
import java.util.Optional;

public interface HappyMemoryRepository {

    HappyMemory save(HappyMemory happyMemory);

    List<HappyMemory> findAllByStorageId(long storageId);

    Optional<HappyMemory> findById(long happyMemoryId);

    void deleteAllById(Iterable<? extends Long> memoryIds);
}
