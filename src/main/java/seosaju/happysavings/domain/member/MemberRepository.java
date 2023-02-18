package seosaju.happysavings.domain.member;

import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findByEmail(String email);

    Optional<Member> findById(String id);

    Member save(Member member);

    void delete(Member member);
}
