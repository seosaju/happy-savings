package seosaju.happysavings.module.member.application;

import seosaju.happysavings.module.member.domain.Member;

public interface ChangeMemberService {

    void changePassword(Member member, String password);

    void changeName(Member member, String name);
}
