package gitJDBC.DBStudy.member.controller;

import gitJDBC.DBStudy.member.entity.Member;
import gitJDBC.DBStudy.member.service.MemberServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Repository
public class MemberController {

    private final MemberServiceImpl memberService;

    private final LoginService loginService;

    public MemberController(MemberServiceImpl memberService, LoginService loginService) {
        this.memberService = memberService;
        this.loginService = loginService;
    }

    //회원 가입
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/singup")
    public ResponseEntity<Member> signup(@RequestBody MemberDto memberDto){
        log.info("회원강비 URL접근");
        log.info("newMember 생성");
        return ResponseEntity.ok(memberService.signUp(memberDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Member> login(@ResponseBody MemberDto memberDto, HttpServletRequest request){
        log.info("로그인 시도 email: []");

        Member member = loginService.login(memberDto.getEmail, memberDto.getPassword())
        if (member == null){
            log.info("로그인 실패- 유효하지 않응ㄴ 이메일 또는 비밀번호입니다.");
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);
        log.info("로그인 성공 -세션 ID");

        return ResponseEntity.ok(member);
    }

    //회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemeber(@PathVariable Long id){
        log.info("삭제 시도");
        memberService.deleteMember(id);
        return ResponseEntity.ok("회원 탈퇴가 완료 됐습니다.");
    }
}
