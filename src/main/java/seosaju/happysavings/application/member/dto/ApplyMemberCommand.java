package seosaju.happysavings.application.member.dto;

import lombok.Getter;

@Getter
public class ApplyMemberCommand {

    private final String username;

    private final String password;

    private final String email;

    public ApplyMemberCommand(String name, String password, String email) {
        this.username = name;
        this.password = password;
        this.email = email;
    }
}
