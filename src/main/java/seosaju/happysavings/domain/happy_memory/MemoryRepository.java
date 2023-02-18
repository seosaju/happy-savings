package seosaju.happysavings.domain.happy_memory;

import java.util.List;
import java.util.Optional;

public interface MemoryRepository {

    Memory save(Memory memory);

    List<Memory> findAllByStorageId(long storageId);

    Optional<Memory> findById(long happyMemoryId);

    void deleteAllById(Iterable<? extends Long> memoryIds);
}
