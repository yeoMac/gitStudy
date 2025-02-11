package gitJDBC.DBStudy.member.service;

import gitJDBC.DBStudy.member.checkForm.validSignUp;
import gitJDBC.DBStudy.member.controller.MemberDto;
import gitJDBC.DBStudy.member.entity.Member;
import gitJDBC.DBStudy.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final validSignUp validSignUp;

    public MemberServiceImpl(MemberRepository memberRepository, validSignUp validSignUp) {
        this.memberRepository = memberRepository;
        this.validSignUp = validSignUp;
    }

    @Override
    public Member signUp(MemberDto memberDto) {

        validSignUp.validEmail(memberDto.getEmail());
        validSignUp.validPassword(memberDto.getPassword());

        Member member = toDto(memberDto);

        return memberRepository.saveMember(member);

    }

    private Member toDto(MemberDto memberDto) {

        return new Member(null
                ,memberDto.getPassword()
                ,memberDto.getEmail()
                ,memberDto.getName(),
                memberDto.getNickname(),
                null);
    }


}
