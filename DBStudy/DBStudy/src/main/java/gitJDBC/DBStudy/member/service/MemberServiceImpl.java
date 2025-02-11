package gitJDBC.DBStudy.member.service;

import gitJDBC.DBStudy.member.checkForm.validSignUp;
import gitJDBC.DBStudy.member.controller.MemberDto;
import gitJDBC.DBStudy.member.entity.Member;
import gitJDBC.DBStudy.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
//
//@Service
//public class MemberServiceImpl implements MemberService{
//
//    private final MemberRepository memberRepository;
//    private final validSignUp validSignUp;
//
//    public MemberServiceImpl(MemberRepository memberRepository, validSignUp validSignUp) {
//        this.memberRepository = memberRepository;
//        this.validSignUp = validSignUp;
//    }
//
//    @Override
//    public Member signUp(MemberDto memberDto) {
//
//        validSignUp.validEmail(memberDto.getEmail());
//        validSignUp.validPassword(memberDto.getPassword());
//
//        Member member = toEntity(memberDto);
//
//        return memberRepository.saveMember(member);
//
//    }
//
//    private Member toEntity(MemberDto memberDto) {
//
//        return new Member(null
//                ,memberDto.getPassword()
//                ,memberDto.getEmail()
//                ,memberDto.getName(),
//                memberDto.getNickname(),
//                null);
//    }
//
//
//}
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final validSignUp validSignUp;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberRepository memberRepository, validSignUp validSignUp) {
        this.memberRepository = memberRepository;
        this.validSignUp = validSignUp;
        this.passwordEncoder = new BCryptPasswordEncoder();  // ✅ 추가
    }

    @Override
    public Member signUp(MemberDto memberDto) {
        validSignUp.validEmail(memberDto.getEmail());
        validSignUp.validPassword(memberDto.getPassword());

        String encryptedPassword = passwordEncoder.encode(memberDto.getPassword());  // ✅ 비밀번호 암호화 적용
        Member member = toEntity(memberDto, encryptedPassword);

        return memberRepository.saveMember(member);
    }

    private Member toEntity(MemberDto memberDto, String encryptedPassword) {
        return new Member(null, encryptedPassword, memberDto.getNickname(),
                memberDto.getName(), memberDto.getEmail(), new Date());
    }
}
