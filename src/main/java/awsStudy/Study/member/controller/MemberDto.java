package awsStudy.Study.member.controller;

import awsStudy.Study.member.entity.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {


    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    private String password;
    @NotBlank(message = "닉네임 입력은 필수입니다.")
    private String nickname;
    @Email
    @NotBlank(message = "이메일 입력은 필수입니다")
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
