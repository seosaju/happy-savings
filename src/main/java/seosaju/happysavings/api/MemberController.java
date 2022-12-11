package seosaju.happysavings.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seosaju.happysavings.api.model.MemberRequest;
import seosaju.happysavings.api.model.MemberResponse;
import seosaju.happysavings.module.member.application.ApplyMemberService;
import seosaju.happysavings.module.member.application.ReadMemberService;
import seosaju.happysavings.module.member.domain.Member;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final ApplyMemberService applyMemberService;
    private final ReadMemberService readMemberService;

    @PostMapping("member")
    public ResponseEntity<?> apply(@Valid @RequestBody MemberRequest.Apply request) {

        String id = applyMemberService.apply(request.getName(), "1111", request.getEmail());
        MemberResponse response = new MemberResponse();
        response.setId(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("member/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {

        Member member = readMemberService.findMemberById(id)
                .orElseThrow();

        return ResponseEntity.ok(member);
    }
}
