package awsStudy.Study.login.controller;

import awsStudy.Study.login.argumentResolver.Login;
import awsStudy.Study.login.service.LoginService;
import awsStudy.Study.login.session.SessionDto;
import awsStudy.Study.member.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/member/login")
@RequiredArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@Valid LoginDto dto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        try {
            Member loginUser = loginService.login(dto);

            SessionDto sessionDto = new SessionDto(loginUser);
            log.info("로그인 성공:{}", dto.getEmail());
            return ResponseEntity.ok(sessionDto);
        } catch (RuntimeException e) {
            log.warn("login fail: {}", dto.getEmail(), e);
            return ResponseEntity.status(500).body("로그인 오류: " + e.getMessage());
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getLoggedInUser(@Login Member member) {
        if (member == null) {
            return ResponseEntity.status(400).body("세션이 없습니다.");
        }
        return ResponseEntity.ok(new SessionDto(member));
    }
}
