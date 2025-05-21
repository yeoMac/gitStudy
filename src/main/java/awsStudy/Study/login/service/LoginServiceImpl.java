package awsStudy.Study.login.service;

import awsStudy.Study.login.SessionConst;
import awsStudy.Study.login.controller.LoginDto;
import awsStudy.Study.login.repository.LoginRepository;
import awsStudy.Study.login.session.SessionDto;
import awsStudy.Study.member.entity.Member;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;


    @Transactional
    @Override
    public Member login(LoginDto dto) {

        Optional<Member> userOptional = loginRepository.findByEmail(dto.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("존재하는 이메일이 없습니다.");
        }

        Member user = userOptional.get();
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        //세션 저장
        SessionDto sessionDto = new SessionDto(user);
        log.info("세션에 저장할 객체: {}", sessionDto.getEmail());
        httpSession.setAttribute(SessionConst.LOGIN_SESSION, sessionDto);

        return user;
    }



}
