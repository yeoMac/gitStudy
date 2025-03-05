package awsStudy.Study.member.controller;

import awsStudy.Study.member.entity.Member;
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

    public static Member toEntity(MemberDto dto) {
        return Member.builder().password(dto.getPassword()).nickname(dto.getNickname()).email(dto.getEmail()).build();
    }
}
