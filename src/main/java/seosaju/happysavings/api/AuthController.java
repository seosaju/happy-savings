package seosaju.happysavings.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seosaju.happysavings.common.security.JwtToken;
import seosaju.happysavings.common.security.JwtTokenProvider;
import seosaju.happysavings.common.security.UserAuthentication;
import seosaju.happysavings.module.member.application.ReadMemberService;
import seosaju.happysavings.module.member.domain.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final ReadMemberService readMemberService;

    public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response,
                                   @Valid @RequestBody JwtToken.Request tokenRequest) throws Exception {

        Member member = readMemberService.findMemberById(tokenRequest.getId())
                .orElseThrow();

        if (!tokenRequest.getPassword().equals(member.getPassword())) {
            throw new IllegalArgumentException("비밀번호를 확인하세요.");
        }

        Authentication authentication = new UserAuthentication(tokenRequest.getId(), null, null);
        String token = JwtTokenProvider.generateToken(authentication);

        JwtToken.Response tokenResponse = JwtToken.Response.builder().token(token).build();

        return ResponseEntity.ok(tokenResponse);
    }
}
