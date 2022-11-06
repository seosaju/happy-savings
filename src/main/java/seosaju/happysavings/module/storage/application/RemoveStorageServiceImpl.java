package seosaju.happysavings.module.storage.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.storage.domain.Storage;
import seosaju.happysavings.module.storage.domain.StorageRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class RemoveStorageServiceImpl implements RemoveStorageService {

    private final StorageRepository storageRepository;

    @Override
    public void remove(Storage storage) {

        if (storage.getMemories().size() > 0) {
            throw new IllegalStateException("Can't delete storage when memories exist.");
        }

        storageRepository.delete(storage);
    }
}
