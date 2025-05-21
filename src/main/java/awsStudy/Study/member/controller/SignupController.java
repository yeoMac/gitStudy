package awsStudy.Study.member.controller;

import awsStudy.Study.member.entity.Member;
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




            log.info("회원가입 요청: {}", dto);
            Member saved = memberService.signup(dto);
            return ResponseEntity.ok(new SignupResponseDto(saved));

    }
}
