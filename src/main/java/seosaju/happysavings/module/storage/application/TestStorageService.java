package seosaju.happysavings.module.storage.application;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.member.domain.MemberRepository;
import seosaju.happysavings.module.storage.domain.Storage;
import seosaju.happysavings.module.storage.domain.StorageRepository;

import java.time.*;

@Profile("test")
@Service
@RequiredArgsConstructor
public class TestStorageService implements StorageService {

    private final StorageRepository storageRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long make(String memberId, String name) {

        Member member = memberRepository.findById(memberId).orElseThrow();

        Instant beginTime = YearMonth.of(Year.now(Clock.systemUTC()).getValue(), Month.JANUARY)
                .atDay(1).atStartOfDay().toInstant(ZoneOffset.UTC);

        Instant endTime = YearMonth.of(Year.now(Clock.systemUTC()).getValue(), Month.DECEMBER)
                .atEndOfMonth().atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);

        storageRepository.findByOwnerIdAndCreationTimeBetween(memberId, beginTime, endTime)
                .ifPresent(storage -> {
                    throw new IllegalStateException("올해 이미 생성한 저장소가 있습니다.");
                });

        Storage storage = Storage.builder()
                .owner(member)
                .name(name)
                .build();

        storage = storageRepository.save(storage);

        return storage.getId();
    }

    @Override
    @Transactional
    public void changeName(long storageId, String name) {

        Storage storage = storageRepository.findById(storageId).orElseThrow();

        storage.changeName(name);
    }

    @Override
    @Transactional
    public void remove(long storageId) {

        Storage storage = storageRepository.findById(storageId).orElseThrow();

        storageRepository.delete(storage);
    }
}
