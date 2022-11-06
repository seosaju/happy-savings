package seosaju.happysavings.module.storage.application;

import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.storage.domain.Storage;

import java.util.List;
import java.util.Optional;

public interface ReadStorageService {

    Optional<Storage> findStorage(long storageId);

    List<Storage> findOwnedStorages(Member member);
}
