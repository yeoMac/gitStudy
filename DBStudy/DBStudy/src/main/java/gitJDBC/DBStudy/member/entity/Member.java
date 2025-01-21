package gitJDBC.DBStudy.member.entity;

import gitJDBC.DBStudy.member.controller.MemberDto;
import lombok.Getter;

@Getter
public class Member {
    private Long id;
    private String password;
    private String nickname;
    private String name;
    private String email;


}
