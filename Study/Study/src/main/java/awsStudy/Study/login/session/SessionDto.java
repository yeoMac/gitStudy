package awsStudy.Study.login.session;

import awsStudy.Study.member.entity.Member;

public class SessionDto {

    private Long id;
    private String nickname;

    public SessionDto(Member member) {
        this.id = member.getId();
        this.nickname = member.getNickname();
    }
}
