package awsStudy.Study.communication.comment.controller;

import awsStudy.Study.communication.entity.Board;
import awsStudy.Study.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
public class CommentDto {

    private String content;
    private Long boardId;

    private Long parentId;
}
