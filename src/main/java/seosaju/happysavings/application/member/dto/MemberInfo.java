package seosaju.happysavings.application.member.dto;

import lombok.Getter;
import seosaju.happysavings.domain.member.MemberRole;

@Getter
public class MemberInfo {

    private final String id;

    private final String username;

    private final String email;

    private final MemberRole role;

    public MemberInfo(String id, String username, String email, MemberRole role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
