package seosaju.happysavings.module.storage.application;

public interface StorageService {

    Long make(String memberId, String name);

    void changeName(long storageId, String name);

    void remove(long storageId);
}
