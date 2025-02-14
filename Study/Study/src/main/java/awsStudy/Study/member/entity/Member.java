package awsStudy.Study.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mamber")
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false, unique = true)
    private String email;

    public Member(String password, String nickname, String email) {
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
