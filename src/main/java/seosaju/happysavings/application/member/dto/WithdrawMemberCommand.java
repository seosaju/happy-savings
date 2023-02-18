package seosaju.happysavings.application.member.dto;

import lombok.Getter;

@Getter
public class WithdrawMemberCommand {

    private final String memberId;

    public WithdrawMemberCommand(String memberId) {
        this.memberId = memberId;
    }
}
