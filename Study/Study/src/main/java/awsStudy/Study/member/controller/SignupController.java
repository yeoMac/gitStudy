package awsStudy.Study.member.controller;

import awsStudy.Study.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class SignupController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody MemberDto dto){

        try {
            log.info("회원가입 요청: {}", dto);
            return ResponseEntity.ok(memberService.signup(dto));
        } catch (Exception e) {
            log.info("회원 가입 실패: {}", dto);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
