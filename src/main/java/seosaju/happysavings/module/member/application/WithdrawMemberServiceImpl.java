package seosaju.happysavings.module.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.member.domain.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class WithdrawMemberServiceImpl implements WithdrawMemberService {

    private final MemberRepository memberRepository;

    @Override
    public void withdraw(Member member) {

        memberRepository.delete(member);
    }
}
