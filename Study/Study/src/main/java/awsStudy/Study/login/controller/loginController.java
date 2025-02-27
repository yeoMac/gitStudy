package awsStudy.Study.login.controller;

import awsStudy.Study.login.service.LoginService;
import awsStudy.Study.member.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/member/login")
@RequiredArgsConstructor
public class loginController {

    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(LoginDto dto) {
        try {
            log.info("로그인 요청: {}", dto);
            return ResponseEntity.ok(loginService.login(dto));
        } catch (Exception e) {
            log.error("로그인 실패: {}", dto, e);
            return ResponseEntity.status(500).body("서버 오류");
        }
    }


}
