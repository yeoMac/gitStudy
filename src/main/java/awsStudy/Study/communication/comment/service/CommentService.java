package awsStudy.Study.communication.comment.service;

import awsStudy.Study.communication.board.repository.BoardRepository;
import awsStudy.Study.communication.comment.controller.CommentDto;
import awsStudy.Study.communication.comment.controller.CommentResponseDto;
import awsStudy.Study.communication.comment.repository.CommentRepository;
import awsStudy.Study.communication.entity.Board;
import awsStudy.Study.communication.entity.Comment;
import awsStudy.Study.login.session.SessionDto;
import awsStudy.Study.member.entity.Member;
import awsStudy.Study.member.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


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

//        Comment parent = null;
//        if (dto.getParentId() != null) {
//             parent = commentRepository.findById(dto.getParentId())
//                    .orElseThrow(() -> new RuntimeException("부모 댓글이 존재하지 않습니다."));
//
//            if (parent.getParent() != null) {
//                //대대댓글 막기
//                throw new RuntimeException("대대댓글은 허용 안 됩니다.");
//            }
//
//        }

        if(dto.getParentId() == null) {
            Long maxRef = commentRepository.findMaxRefByBoard(dto.getBoardId());
            Long ref = (maxRef == null) ? 1 : maxRef + 1;

            Comment comment = Comment.builder().
                    content(dto.getContent()).
                    member(member).
                    board(board).
                    created_at(LocalDateTime.now()).
                    ref(ref).
                    step(0).
                    refOrder(0L).
                    build();

            return commentRepository.save(comment);
        }else{
            // 대댓글 저장 로직
            Comment parent = commentRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("부모 댓글이 존재하지 않습니다."));

            Long ref = parent.getRef();
            int parentStep = parent.getStep();
            Long parentRefOrder = parent.getRefOrder();
            Long parentAnswerNum = parent.getChildren().size() + 1L;

            int saveStep = parentStep + 1;

            Long answerNumSum  = commentRepository.findSumAnswerNumByRef(ref);
            int maxStep = commentRepository.findMaxStepByRef(ref).intValue();

            Long newRefOrder = null;

            if(saveStep < maxStep){
                newRefOrder = answerNumSum +1;
            }else if(saveStep == maxStep){
                commentRepository.updateRefOrderPlus(ref, parentRefOrder + parentAnswerNum);
                newRefOrder = parentRefOrder + parentAnswerNum + 1;
            }else{
                commentRepository.updateRefOrderPlus(ref, parentRefOrder);
                newRefOrder = parentRefOrder + 1;
            }

            Comment reply = Comment.builder().
                    content(dto.getContent()).
                    member(member).
                    board(board).
                    created_at(LocalDateTime.now()).
                    ref(ref).
                    step(saveStep).
                    refOrder(newRefOrder).
                    parent(parent).
                    build();

            return commentRepository.save(reply);
        }
    }


    public List<CommentResponseDto> getCommentsByBoard(Long boardId){
        List<Comment> commentList = commentRepository.findAllByBoardIdOrderByRefAndRefOrder(boardId);

        return commentList.stream().
                map(c -> CommentResponseDto.builder().
                        id(c.getId()).
                        content(c.getContent()).
                        nickname(c.getMember().getNickname()).
                        step(c.getStep()).
                        parentId(c.getParent() != null ? c.getParent().getId() : null).
                        build()).
                toList();
    }

}
