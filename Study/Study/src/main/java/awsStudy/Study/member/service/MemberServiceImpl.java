package awsStudy.Study.member.service;

import awsStudy.Study.member.controller.MemberDto;
import awsStudy.Study.member.entity.Member;
import awsStudy.Study.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Member signup(MemberDto dto) {
        //일단 검증 작업 생략(일단 빠르게 배포하는 게 우선 사항)
        Member member = MemberDto.toEntity(dto);
        return memberRepository.save(member);

    }


}
