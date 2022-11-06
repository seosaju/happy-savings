package seosaju.happysavings.module.storage.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.storage.domain.Storage;

@Service
@Transactional
public class ChangeStorageServiceImpl implements ChangeStorageService {

    @Override
    public void changeName(Storage storage, String name) {

        storage.changeName(name);
    }

    @Override
    public void open(Storage storage) {

        storage.open();
    }
}
