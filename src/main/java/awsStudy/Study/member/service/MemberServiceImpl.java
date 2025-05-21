package awsStudy.Study.member.service;

import awsStudy.Study.Exception.DuplicateEmailException;
import awsStudy.Study.member.controller.MemberDto;
import awsStudy.Study.member.entity.Member;
import awsStudy.Study.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Member signup(MemberDto dto) {

        /*Member member = MemberDto.toEntity(dto);*/

        if (memberRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
        }

        String encodePassword = passwordEncoder.encode(dto.getPassword());

        Member member = Member.builder().
                email(dto.getEmail()).
                password(encodePassword).
                nickname(dto.getNickname()).
                build();

        return memberRepository.save(member);

    }


}
