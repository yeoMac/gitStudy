package gitJDBC.DBStudy.member.checkForm;

import gitJDBC.DBStudy.member.controller.MemberDto;
import gitJDBC.DBStudy.member.repository.MemberRepository;

public class CheckSignUp {

    private final MemberRepository memberRepository;

    public CheckSignUp(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean checkExistEmail(MemberDto memberDto) {

        if (memberRepository.existsByEmail(memberDto.getEmail())) {
            throw new IllegalStateException("동일한 이메일이 등록되 있습니다.");
        }
    }
    
    
}
