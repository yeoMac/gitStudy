package awsStudy.Study.communication.entity;

import awsStudy.Study.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "category")
    private List<Board> boards;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Category(Long id, String name, List<Board> boards, Member member) {
        this.id = id;
        this.name = name;
        this.boards = boards;
        this.member = member;
    }

}