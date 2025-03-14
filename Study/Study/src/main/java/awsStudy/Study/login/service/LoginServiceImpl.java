package awsStudy.Study.login.service;

import awsStudy.Study.login.SessionConst;
import awsStudy.Study.login.controller.LoginDto;
import awsStudy.Study.login.repository.LoginRepository;
import awsStudy.Study.member.entity.Member;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;


    @Override
    public Member login(LoginDto dto) {

        Optional<Member> userOptional = loginRepository.findByEmail(dto.getEmail());

        if (userOptional.isPresent()) {
            throw new RuntimeException("존재하는 이메일이 없습니다.");
        }

        Member user = userOptional.get();
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        //세션 저장
        httpSession.setAttribute(SessionConst.LOGIN_SESSION, user);

        return user;
    }



}
