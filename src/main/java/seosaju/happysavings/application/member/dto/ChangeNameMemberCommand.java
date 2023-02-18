package seosaju.happysavings.application.member.dto;

import lombok.Getter;

@Getter
public class ChangeNameMemberCommand {

    private final String memberId;

    private final String changeName;

    public ChangeNameMemberCommand(String memberId, String changeName) {
        this.memberId = memberId;
        this.changeName = changeName;
    }
}
