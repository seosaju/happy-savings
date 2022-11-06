package seosaju.happysavings.module.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.member.domain.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplyMemberServiceImpl implements ApplyMemberService {

    private final MemberRepository memberRepository;

    @Override
    public String apply(String username, String password, String email) {

        // TODO :: 인증

        Member member = Member.builder()
                .username(username)
                .password(password) // TODO :: encryptedPassword
                .email(email)
                .build();

        member = memberRepository.save(member);

        return member.getId();
    }
}
