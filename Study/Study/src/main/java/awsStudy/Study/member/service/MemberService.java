package awsStudy.Study.member.service;

import awsStudy.Study.member.controller.MemberDto;
import awsStudy.Study.member.entity.Member;
import org.springframework.stereotype.Service;


public interface MemberService {

    Member signup(MemberDto dto);
}
