package awsStudy.Study.communication.comment.controller;

import lombok.Getter;

@Getter
public class CommentDto {

    private String content;
    private Long boardId;

    private Long parentId;
}
