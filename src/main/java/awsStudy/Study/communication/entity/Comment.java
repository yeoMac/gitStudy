package awsStudy.Study.communication.entity;

import awsStudy.Study.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    Long id;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "ref")
    private Long ref;
    @Column(name = "step")
    private Integer step;
    @Column(name = "ref_order")
    private Long refOrder;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    //== 실무에서는 대댓 계층글 위해 parent, children 구조 자주 씀, 게시판에 댓글 계층이 있으면 꼭 넣어야 함.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent")
    private List<Comment> children = new ArrayList<>();

    //==편의 메서드
    public void addChild(Comment child) {
        children.add(child);
        child.parent = this;
    }

    public Comment() {
    }

    @Builder
    public Comment(String content, Member member, Board board, Comment parent) {
        this.content = content;
        this.member = member;
        this.board = board;
        this.parent = parent;
    }

}
