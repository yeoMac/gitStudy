package awsStudy.Study.board.controller;


import awsStudy.Study.board.service.BoardService;
import awsStudy.Study.login.argumentResolver.Login;
import awsStudy.Study.login.session.SessionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class CreateBoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody BoardDto dto, @Login SessionDto sessionDto) {

        log.info("create board{}", dto);
        return ResponseEntity.ok(boardService.create(dto, sessionDto));
    }
}
