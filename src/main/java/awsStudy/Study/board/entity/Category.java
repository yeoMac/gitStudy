package awsStudy.Study.board.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    @OneToMany(mappedBy = "category")
    private List<Board> boards;

    @ManyToOne
    private Member member;



    @Builder
    public Category(Long id, String name, List<Board> boards, Member member) {
        this.id = id;
        this.name = name;
        this.boards = boards;
        this.member = member;
    }
}
