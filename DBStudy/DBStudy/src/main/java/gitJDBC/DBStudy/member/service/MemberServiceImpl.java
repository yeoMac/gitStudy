package gitJDBC.DBStudy.member.service;

import gitJDBC.DBStudy.member.controller.MemberDto;
import gitJDBC.DBStudy.member.entity.Member;
import gitJDBC.DBStudy.member.repository.MemberRepository;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member signUp(MemberDto memberDto) {

        checkSingUp(memberDto);
        Member member = memberToDto(memberDto);
        return memberRepository.saveMember(member);

    }

    private Member memberToDto(MemberDto memberDto) {

        Member member = new Member();
    }

    private void checkSingUp(MemberDto memberDto){
        if (memberDto.getEmail()==memberRepository.findEmailById(memberDto.getId())){

        }
    }
}
