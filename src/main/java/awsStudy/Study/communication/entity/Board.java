package awsStudy.Study.communication.entity;

import awsStudy.Study.member.entity.Member;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
public class Board {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String story;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



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
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
