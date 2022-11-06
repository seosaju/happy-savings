package seosaju.happysavings.module.happy_memory.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.happy_memory.application.dto.request.HappyMemoryRequest;
import seosaju.happysavings.module.happy_memory.domain.HappyMemory;
import seosaju.happysavings.module.happy_memory.domain.HappyMemoryRepository;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.member.domain.MemberRepository;
import seosaju.happysavings.module.storage.domain.Storage;
import seosaju.happysavings.module.storage.domain.StorageRepository;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class WriteHappyMemoryServiceImpl implements WriteHappyMemoryService {

    private final HappyMemoryRepository happyMemoryRepository;
    private final MemberRepository memberRepository;
    private final StorageRepository storageRepository;

    @Override
    public long write(HappyMemoryRequest.Write request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("No member has this ID."));

        Storage storage = storageRepository.findById(request.getStorageId())
                .orElseThrow(() -> new IllegalArgumentException("No storage has this ID "));


        if (storage.isOpened()) {
            throw new IllegalStateException("Can't put it an already opened storage.");
        }

        HappyMemory memory = HappyMemory.builder()
                .writer(member)
                .storage(storage)
                .contents(request.getContent())
                .build();

        memory = happyMemoryRepository.save(memory);

        return memory.getId();
    }
}
