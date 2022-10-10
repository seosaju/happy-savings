package seosaju.happysavings.module.member.application.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberRequest {

    @Getter
    @Setter
    public static class Apply {

        @NotBlank
        private String name;

        @Email
        @NotBlank
        private String email;
    }
}
