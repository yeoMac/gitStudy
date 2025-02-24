package awsStudy.Study.member.service;

import awsStudy.Study.member.controller.MemberDto;
import awsStudy.Study.member.entity.Member;
import awsStudy.Study.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    @Override
    public Member signup(MemberDto dto) {
        //일단 검증 작업 생략(일단 빠르게 배포하는 게 우선 사항)
        Member member = toEntity(dto);
        return memberRepository.save(member);

    }

    private Member toEntity(MemberDto dto) {

        //일단 id, nickname, email, password만
        return new Member(null, dto.getNickname(), dto.getEmail(), dto.getPassword());
    }
}
