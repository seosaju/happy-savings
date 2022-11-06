package seosaju.happysavings.module.happy_memory.application;

import seosaju.happysavings.module.happy_memory.domain.HappyMemory;
import seosaju.happysavings.module.storage.domain.Storage;

import java.util.List;
import java.util.Optional;

public interface ReadHappyMemoryService {

    Optional<HappyMemory> bringBack(long happyMemoryId);

    List<HappyMemory> bringBackFromStorage(Storage storage);
}
