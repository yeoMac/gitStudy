package awsStudy.Study.communication.comment.service;

import awsStudy.Study.communication.board.repository.BoardRepository;
import awsStudy.Study.communication.comment.controller.CommentDto;
import awsStudy.Study.communication.comment.repository.CommentRepository;
import awsStudy.Study.communication.entity.Board;
import awsStudy.Study.communication.entity.Comment;
import awsStudy.Study.login.session.SessionDto;
import awsStudy.Study.member.entity.Member;
import awsStudy.Study.member.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    public Comment createComment(@Valid CommentDto dto, SessionDto sessionDto) {

        Member member = memberRepository.findById(sessionDto.getId()).
                orElseThrow(()->new RuntimeException("회원 정보 없음"));

        Board board = boardRepository.findById(dto.getBoardId()).
                orElseThrow(() -> new RuntimeException("게시판이 존재하지 않습니다."));

        Comment parent = null;
        if (dto.getParentId() != null) {
             parent = commentRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("부모 댓글이 존재하지 않습니다."));

            if (parent.getParent() != null) {
                //대대댓글 막기
                throw new RuntimeException("대대댓글은 허용 안 됩니다.");
            }

        }

        Comment comment = Comment.builder().
                content(dto.getContent()).member(member).board(board).parent(parent).
                build();

        return commentRepository.save(comment);


    }
}
