package seosaju.happysavings.module.storage.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.storage.domain.Storage;
import seosaju.happysavings.module.storage.domain.StorageRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReadStorageServiceImpl implements ReadStorageService {

    private final StorageRepository storageRepository;

    @Override
    public Optional<Storage> findStorage(long storageId) {
        return storageRepository.findById(storageId);
    }

    @Override
    public List<Storage> findOwnedStorages(Member member) {
        return storageRepository.findByOwnerId(member.getId());
    }
}
