package awsStudy.Study.login.session;

import awsStudy.Study.member.entity.Member;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@Getter
public class SessionDto implements Serializable {

    private Long id;
    private String nickname;
    private String email;

    public SessionDto() {
    }

    public SessionDto(Member member) {
        this.id = member.getId();
        this.nickname = member.getNickname();
        this.email = member.getEmail();
    }
}
