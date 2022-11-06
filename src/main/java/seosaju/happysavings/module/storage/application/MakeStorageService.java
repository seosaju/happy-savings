package seosaju.happysavings.module.storage.application;

import seosaju.happysavings.module.member.domain.Member;

public interface MakeStorageService {

    Long make(Member member, String name);
}
