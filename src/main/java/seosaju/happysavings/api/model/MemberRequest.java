package seosaju.happysavings.api.model;

import lombok.Getter;
import lombok.Setter;

public class MemberRequest {

    @Getter
    @Setter
    public static class Apply {

        private String name;
        private String email;
    }
}
