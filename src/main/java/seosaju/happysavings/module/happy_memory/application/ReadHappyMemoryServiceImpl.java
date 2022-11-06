package seosaju.happysavings.module.happy_memory.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.happy_memory.domain.HappyMemory;
import seosaju.happysavings.module.happy_memory.domain.HappyMemoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReadHappyMemoryServiceImpl implements ReadHappyMemoryService {

    private final HappyMemoryRepository happyMemoryRepository;

    @Override
    public Optional<HappyMemory> bringBack(long happyMemoryId) {

        return happyMemoryRepository.findById(happyMemoryId);
    }

    @Override
    public List<HappyMemory> bringBackFromStorage(long storageId) {

        return happyMemoryRepository.findAllByStorageId(storageId);
    }
}
