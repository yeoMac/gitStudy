package gitJDBC.DBStudy.member.controller;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MemberDto {

    private Long id;
    private String password;
    private String nickname;
    private String name;
    private String email;


}
