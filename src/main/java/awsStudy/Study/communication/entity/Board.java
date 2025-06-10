package awsStudy.Study.communication.entity;

import awsStudy.Study.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, name = "title")
    String title;
    @Column(name = "story")
    String story;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @Column(name = "updated_at")
    private LocalDateTime updated_at;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Board() {
    }

    //== Builder에서 엔티티도 파라미터로 받은 이유는? 실무에서 무슨 역할을 하니?
    @Builder
    public Board(String title, String story, Member member, Category category) {
        this.title = title;
        this.story = story;
        this.member = member;
        this.category = category;
    }


    //== 밑의 on메서드는 어디에 사용하는 거지? 편의 메서드인가?
    // createdAt, updateAt는 실무에서 필수 정렬, UI 표시, 최신글 판단에 사용됨.

    @PrePersist
    public void onCreate() {
        this.created_at = LocalDateTime.now();
        this.updated_at = this.created_at;
    }

    @PreUpdate
    public void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }
}
