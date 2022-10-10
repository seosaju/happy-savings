package seosaju.happysavings.module.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.member.domain.MemberRepository;

@Profile("test")
@Service
@Transactional
@RequiredArgsConstructor
public class TestMemberService implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public String apply(String name, String email) {

        Member member = Member.builder()
                .name(name)
                .email(email)
                .build();

        member = memberRepository.save(member);

        return member.getId();
    }
}
