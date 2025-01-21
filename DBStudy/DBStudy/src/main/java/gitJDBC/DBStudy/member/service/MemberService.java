package gitJDBC.DBStudy.member.service;

import gitJDBC.DBStudy.member.controller.MemberDto;
import gitJDBC.DBStudy.member.entity.Member;

public interface MemberService {
    Member signUp(MemberDto memberDto);
}
