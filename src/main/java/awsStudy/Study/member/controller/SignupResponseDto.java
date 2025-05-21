package awsStudy.Study.member.controller;

import awsStudy.Study.member.entity.Member;
import lombok.Getter;

@Getter
public class SignupResponseDto {
    private Long id;
    private String email;
    private String nickname;

    public SignupResponseDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
    }

}
