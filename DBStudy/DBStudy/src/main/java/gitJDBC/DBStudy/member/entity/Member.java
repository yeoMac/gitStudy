package gitJDBC.DBStudy.member.entity;

import gitJDBC.DBStudy.member.controller.MemberDto;
import lombok.Getter;

import java.util.Date;

@Getter
public class Member {
    private Long id;
    private String password;
    private String nickname;
    private String name;
    private String email;
    private Date date;


    public Member(Long id, String password, String nickname, String name, String email, Date date) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Member() {
    }
}
