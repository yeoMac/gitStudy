package awsStudy.Study.board.service;

import awsStudy.Study.board.controller.BoardDto;
import awsStudy.Study.board.entity.Board;
import awsStudy.Study.board.entity.Category;
import awsStudy.Study.board.repository.BoardRepository;
import awsStudy.Study.board.repository.CategoryRepository;
import awsStudy.Study.login.session.SessionDto;
import awsStudy.Study.member.entity.Member;
import awsStudy.Study.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;


    public Board create(BoardDto dto, SessionDto sessionDto) {

        Member member = memberRepository.findById(sessionDto.getId())
                .orElseThrow(() -> new RuntimeException("회원 없음"));
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("카테고리 없음"));

        Board board = Board.builder()
                .title(dto.getTitle())
                .story(dto.getStory())
                .member(member)
                .category(category)
                .build();
        return boardRepository.save(board);
    }
}
