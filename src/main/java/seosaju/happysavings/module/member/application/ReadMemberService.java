package seosaju.happysavings.module.member.application;

import seosaju.happysavings.module.member.domain.Member;

import java.util.Optional;

public interface ReadMemberService {

    Optional<Member> findMemberById(String memberId);

    Optional<Member> findMemberByEmail(String email);
}
