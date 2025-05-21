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

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto dto, BindingResult bindingResult) {

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

    //    @GetMapping("/me")
//    public ResponseEntity<?> getLoggedInUser(@Login SessionDto user) {
//        if (user == null) {
//            return ResponseEntity.status(400).body("세션이 없습니다.");
//        }
//
//        log.info("세션 유지 확인 : {}", user.getEmail());
//        return ResponseEntity.ok(user);
//    }
    @GetMapping("/me")
    public ResponseEntity<?> getLoggedInUser(@Login SessionDto user) {

        if (user == null || user.getEmail() == null) {
            log.warn("세션 없음 또는 잘못된 세션 객체");
            return ResponseEntity.status(401).body("세션이 없습니다.");
        }

        log.info("세션 유지 확인 : {}", user.getEmail());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }
}
