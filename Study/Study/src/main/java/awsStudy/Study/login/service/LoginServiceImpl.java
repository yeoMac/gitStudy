package awsStudy.Study.login.service;

import awsStudy.Study.login.controller.LoginDto;
import awsStudy.Study.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;


    @Override
    public Member login(LoginDto dto) {
        //추후에 검증 절차 넣을 예정

        toentity(dto);
        return memberRepository.ckeckInform();
    }

    private Member toentity(LoginDto dto) {
        return null;
    }

}
