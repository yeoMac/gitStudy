package awsStudy.Study.login.service;

import awsStudy.Study.login.controller.LoginDto;
import awsStudy.Study.member.entity.Member;

public interface LoginService {
    Member login(LoginDto dto);
}
