package seosaju.happysavings.module.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.member.domain.MemberRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReadMemberServiceImpl implements ReadMemberService {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> findMemberById(String memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public Optional<Member> findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
