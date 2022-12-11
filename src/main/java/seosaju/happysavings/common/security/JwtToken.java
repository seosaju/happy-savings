package seosaju.happysavings.common.security;

import lombok.*;

public class JwtToken {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class Request {

        private String id;
        private String password;
    }
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class Response {

        private String token;
    }
}
