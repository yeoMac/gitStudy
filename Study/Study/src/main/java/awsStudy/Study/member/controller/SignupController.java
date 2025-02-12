package awsStudy.Study.member.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/api/member/signup")
public class SignupController {

    @Autowired
    private final MemberService memberService;

    @RestController
    public ResponseEntity<Member> signup(@Valid MemberDto dto){

        log.info("signupController");

    return ResponseEntity.ok(MemberService.signup(dto));
    }
}
