package seosaju.happysavings.module.happy_memory.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.happy_memory.domain.HappyMemory;
import seosaju.happysavings.module.happy_memory.domain.HappyMemoryRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RemoveHappyMemoryServiceImpl implements RemoveHappyMemoryService {

    private final HappyMemoryRepository happyMemoryRepository;


    @Override
    public void removeInStorage(long storageId) {

        List<HappyMemory> memories = happyMemoryRepository.findAllByStorageId(storageId);

        happyMemoryRepository.deleteAll(memories);
    }
}
