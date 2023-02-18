package seosaju.happysavings.application.member.dto;

import lombok.Getter;

@Getter
public class ChangePasswordMemberCommand {

    private final String memberId;

    private final String changePassword;

    public ChangePasswordMemberCommand(String memberId, String changePassword) {
        this.memberId = memberId;
        this.changePassword = changePassword;
    }
}
