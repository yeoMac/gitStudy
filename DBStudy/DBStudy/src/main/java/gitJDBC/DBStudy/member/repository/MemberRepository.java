package gitJDBC.DBStudy.member.repository;

import gitJDBC.DBStudy.member.entity.Member;

public interface MemberRepository {

    String findEmailById(Long id);

    Member saveMember(Member member);

    boolean existsByEmail(String email);
}
