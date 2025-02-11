package gitJDBC.DBStudy.member.controller;

import gitJDBC.DBStudy.member.entity.Member;
import gitJDBC.DBStudy.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //회원 가입
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public ResponseEntity<Member> signup(@RequestBody @ModelAttribute MemberDto memberDto){
        log.info("회원강비 URL접근");
        log.info("newMember 생성");


        return ResponseEntity.ok(memberService.signUp(memberDto));
    }

}
