package awsStudy.Study.login.repository;


import awsStudy.Study.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByEmail(String email);

}
