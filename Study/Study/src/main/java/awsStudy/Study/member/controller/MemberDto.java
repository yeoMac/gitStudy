package awsStudy.Study.member.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {


    private String password;
    private String nickname;
    private String email;

    public MemberDto(String password, String nickname, String email) {
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
