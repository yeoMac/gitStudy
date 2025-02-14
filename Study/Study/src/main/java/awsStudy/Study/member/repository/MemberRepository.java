package awsStudy.Study.member.repository;

import awsStudy.Study.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
