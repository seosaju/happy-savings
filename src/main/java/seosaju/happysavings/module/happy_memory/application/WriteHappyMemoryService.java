package seosaju.happysavings.module.happy_memory.application;

import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.storage.domain.Storage;

public interface WriteHappyMemoryService {

    long write(Member member, Storage storage, String content);
}
