package seosaju.happysavings.module.member.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.member.domain.MemberRepository;

public interface JpaMemberRepository extends JpaRepository<Member, String>, MemberRepository {
}
