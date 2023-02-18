package seosaju.happysavings.application.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seosaju.happysavings.application.member.dto.*;
import seosaju.happysavings.domain.member.Member;
import seosaju.happysavings.domain.member.MemberFilter;
import seosaju.happysavings.domain.member.MemberReader;
import seosaju.happysavings.domain.member.MemberStore;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberReader memberReader;
    private final MemberStore memberStore;

    @Override
    @Transactional
    public String apply(ApplyMemberCommand command) {

        Member member = Member.builder()
                .username(command.getUsername())
                .password(command.getPassword())
                .email(command.getEmail())
                .build();

        Member savedMember = memberStore.save(member);

        return savedMember.getId();
    }

    @Override
    @Transactional
    public void withdraw(WithdrawMemberCommand command) {

        MemberFilter filter = new MemberFilter();
        filter.setId(command.getMemberId());

        Member member = memberReader.findMember(filter).orElseThrow();

        memberStore.delete(member);
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordMemberCommand command) {

        MemberFilter filter = new MemberFilter();
        filter.setId(command.getMemberId());

        Member member = memberReader.findMember(filter).orElseThrow();

        member.changePassword(command.getChangePassword());
    }

    @Override
    @Transactional
    public void changeName(ChangeNameMemberCommand command) {

        MemberFilter filter = new MemberFilter();
        filter.setId(command.getMemberId());

        Member member = memberReader.findMember(filter).orElseThrow();

        member.changeName(command.getChangeName());
    }

    @Override
    public MemberInfo findMember(String id) {

        MemberFilter filter = new MemberFilter();
        filter.setId(id);

        Member member = memberReader.findMember(filter).orElseThrow();

        return new MemberInfo(
                member.getId(),
                member.getUsername(),
                member.getEmail(),
                member.getRole()
        );
    }
}
