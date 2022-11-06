package seosaju.happysavings.module.storage.application;

import seosaju.happysavings.module.storage.domain.Storage;

public interface ChangeStorageService {

    void changeName(Storage storage, String name);

    void open(Storage storage);
}
