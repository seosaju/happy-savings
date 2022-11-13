package seosaju.happysavings.module.happy_memory.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.happy_memory.domain.HappyMemory;
import seosaju.happysavings.module.happy_memory.domain.HappyMemoryRepository;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.storage.domain.Storage;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class WriteHappyMemoryServiceImpl implements WriteHappyMemoryService {

    private final HappyMemoryRepository happyMemoryRepository;

    @Override
    public long write(Member member, Storage storage, String content) {

        if (storage.isOpened()) {
            throw new IllegalStateException("Can't put it an already opened storage.");
        }

        HappyMemory memory = HappyMemory.builder()
                .writer(member)
                .storage(storage)
                .contents(content)
                .build();

        memory = happyMemoryRepository.save(memory);

        return memory.getId();
    }
}
