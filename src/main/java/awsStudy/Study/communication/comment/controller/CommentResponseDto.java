package awsStudy.Study.communication.comment.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponseDto {

    private Long id;
    private String content;
    private String nickname;
    private int step;
    private Long parentId;
}
