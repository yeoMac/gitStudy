package awsStudy.Study.communication.comment.controller;

import awsStudy.Study.communication.comment.service.CommentService;
import awsStudy.Study.communication.entity.Comment;
import awsStudy.Study.login.argumentResolver.Login;
import awsStudy.Study.login.session.SessionDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/board/comment")
public class CRUDCommentController {

    private final CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@Valid @RequestBody CommentDto commentDto,
                                                 @Login SessionDto sessionDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body((Comment) bindingResult.getAllErrors());
        }

        return ResponseEntity.ok(commentService.createComment(commentDto,sessionDto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<CommentResponseDto>> getComments(@RequestParam Long boardId){
        return ResponseEntity.ok(commentService.getCommentsByBoard(boardId));
    }
}
