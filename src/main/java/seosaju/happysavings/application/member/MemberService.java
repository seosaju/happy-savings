package seosaju.happysavings.application.member;

import seosaju.happysavings.application.member.dto.*;

public interface MemberService {

    String apply(ApplyMemberCommand command);

    void withdraw(WithdrawMemberCommand command);

    void changePassword(ChangePasswordMemberCommand command);

    void changeName(ChangeNameMemberCommand command);

    MemberInfo findMember(String id);
}
