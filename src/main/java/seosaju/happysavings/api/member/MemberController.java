package seosaju.happysavings.api.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seosaju.happysavings.api.member.request.MemberRequest;
import seosaju.happysavings.application.member.MemberService;
import seosaju.happysavings.application.member.dto.ApplyMemberCommand;
import seosaju.happysavings.application.member.dto.MemberInfo;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("member")
    public ResponseEntity<?> apply(@Valid @RequestBody MemberRequest.Apply request) {

        ApplyMemberCommand command = new ApplyMemberCommand(request.getName(), "1111", request.getEmail());

        String id = memberService.apply(command);

        return ResponseEntity.ok(id);
    }

    @GetMapping("member/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {

        MemberInfo member = memberService.findMember(id);

        return ResponseEntity.ok(member);
    }
}
