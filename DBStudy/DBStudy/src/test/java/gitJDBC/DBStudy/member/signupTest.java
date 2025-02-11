package gitJDBC.DBStudy.member;

import gitJDBC.DBStudy.member.controller.MemberDto;
import gitJDBC.DBStudy.member.entity.Member;
import gitJDBC.DBStudy.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class signupTest {

    @Autowired
    private MemberService memberService;

    @Test
    void signup(){

        MemberDto dto = new MemberDto();
        dto.setName("name");
        dto.setEmail("email@gmail.com");
        dto.setPassword("password");
        dto.setNickname("nickname");

        Member member = memberService.signUp(dto);

        assertThat(member.getName()).isEqualTo(dto.getName());

    }
}

