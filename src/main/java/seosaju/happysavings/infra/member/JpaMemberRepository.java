package seosaju.happysavings.infra.member;

import org.springframework.data.jpa.repository.JpaRepository;
import seosaju.happysavings.domain.member.Member;
import seosaju.happysavings.domain.member.MemberRepository;

public interface JpaMemberRepository extends JpaRepository<Member, String>, MemberRepository {
}
