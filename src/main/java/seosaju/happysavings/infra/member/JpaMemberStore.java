package seosaju.happysavings.infra.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seosaju.happysavings.domain.member.Member;
import seosaju.happysavings.domain.member.MemberRepository;
import seosaju.happysavings.domain.member.MemberStore;

@Component
@RequiredArgsConstructor
public class JpaMemberStore implements MemberStore {

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void delete(Member member) {
        memberRepository.delete(member);
    }
}
