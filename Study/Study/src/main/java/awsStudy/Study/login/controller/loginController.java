package awsStudy.Study.login.controller;

import awsStudy.Study.login.ArgumentResolver.Login;
import awsStudy.Study.login.service.LoginService;
import awsStudy.Study.login.session.SessionDto;
import awsStudy.Study.member.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
public class loginController {

    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@Valid LoginDto dto, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        try {
            Member loginUser = loginService.login(dto);
            if (loginUser == null) {
                throw new RuntimeException("login fail");
            }
            SessionDto sessionDto = new SessionDto(loginUser);
            request.getSession().setAttribute("sessionDto", sessionDto);

            log.info("login success: {}", dto.getEmail());
            return ResponseEntity.ok(sessionDto);
        } catch (RuntimeException e) {
            log.warn("login fail: {}", dto.getEmail(), e);
            return ResponseEntity.status(500).body("로그인 오류");
        }
    }


}
