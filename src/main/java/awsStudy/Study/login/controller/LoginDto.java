package awsStudy.Study.login.controller;

import awsStudy.Study.member.entity.Member;
import lombok.Getter;


@Getter
public class LoginDto {

    private String email;
    private String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Member toEntity(LoginDto dto) {
        return Member.builder().email(dto.getEmail()).password(dto.getPassword()).build();
    }
}
