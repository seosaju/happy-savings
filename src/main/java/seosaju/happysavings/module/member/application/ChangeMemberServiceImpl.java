package seosaju.happysavings.module.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seosaju.happysavings.module.member.domain.Member;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangeMemberServiceImpl implements ChangeMemberService {

    @Override
    public void changePassword(Member member, String password) {

        member.changePassword(password);
    }

    @Override
    public void changeName(Member member, String name) {

        member.changeName(name);
    }
}
