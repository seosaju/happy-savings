package seosaju.happysavings.module.storage.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.storage.domain.Storage;
import seosaju.happysavings.module.storage.domain.StorageRepository;

import java.time.*;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeStorageServiceImpl implements MakeStorageService {

    private final StorageRepository storageRepository;

    @Override
    public Long make(Member member, String name) {

        Instant beginTime = YearMonth.of(Year.now(Clock.systemUTC()).getValue(), Month.JANUARY)
                .atDay(1).atStartOfDay().toInstant(ZoneOffset.UTC);

        Instant endTime = YearMonth.of(Year.now(Clock.systemUTC()).getValue(), Month.DECEMBER)
                .atEndOfMonth().atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);

        storageRepository.findByOwnerIdAndCreationTimeBetween(member.getId(), beginTime, endTime)
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
}
