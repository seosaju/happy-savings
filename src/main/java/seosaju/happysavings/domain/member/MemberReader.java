package seosaju.happysavings.domain.member;

import java.util.Optional;

public interface MemberReader {

    Optional<Member> findMember(MemberFilter memberFilter);
}
