package awsStudy.Study.communication.comment.repository;

import awsStudy.Study.communication.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT COALESCE(MAX(c.ref), 0) FROM Comment c WHERE c.board.id = :boardId")
    Long findMaxRefByBoard(@Param("boardId") Long boardId);

    @Query("SELECT COUNT(c) FROM Comment c WHERE c.ref = :ref")
    Long findSumAnswerNumByRef(@Param("ref") Long ref);


    @Query("SELECT COALESCE(MAX(c.step), 0) FROM Comment c WHERE c.ref =:ref")
    Integer findMaxStepByRef(@Param("ref") Long ref);

    @Modifying
    @Query("UPDATE Comment c SET c.refOrder = c.refOrder +1 WHERE c.ref =: ref AND c.refOrder >: startRefOrder")
    void updateRefOrderPlus(@Param("ref") Long ref, @Param("startRefOrder") Long startRefOrder);


    @Query("SELECT c FROM Comment c WHERE c.board.id =:boardId ORDER BY c.ref DESC, c.refOrder ASC")
    List<Comment> findAllByBoardIdOrderByRefAndRefOrder(@Param("boardId") Long boardId);
}
