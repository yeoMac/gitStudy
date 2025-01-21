package gitJDBC.DBStudy.member.controller;

import lombok.Getter;

@Getter
public class MemberDto {

    private Long id;
    private String password;
    private String nickname;
    private String name;
    private String email;


}
