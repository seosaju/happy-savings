package seosaju.happysavings.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFilter {

    private String id;

    private String email;

    private MemberRole memberRole;
}
