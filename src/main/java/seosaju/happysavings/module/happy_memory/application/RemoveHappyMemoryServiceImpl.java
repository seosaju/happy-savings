package seosaju.happysavings.module.happy_memory.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.happy_memory.domain.HappyMemory;
import seosaju.happysavings.module.happy_memory.domain.HappyMemoryRepository;
import seosaju.happysavings.module.storage.domain.Storage;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RemoveHappyMemoryServiceImpl implements RemoveHappyMemoryService {

    private final HappyMemoryRepository happyMemoryRepository;

    @Override
    public void removeInStorage(Storage storage) {

        List<HappyMemory> memories = happyMemoryRepository.findAllByStorageId(storage.getId());

        happyMemoryRepository.deleteAllById(memories.stream().map(HappyMemory::getId).collect(Collectors.toList()));
    }
}
