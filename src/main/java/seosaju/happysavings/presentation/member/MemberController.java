package seosaju.happysavings.presentation.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seosaju.happysavings.module.member.application.MemberService;
import seosaju.happysavings.module.member.application.dto.request.MemberRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> apply(@RequestBody MemberRequest.Apply request) {

        String memberId = memberService.apply(request.getName(), request.getEmail());

        return ResponseEntity.ok(memberId);
    }
}
