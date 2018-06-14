package kr.ac.ks.boardreplay;

import kr.ac.ks.board.WebBoard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WebBoardReplyRepository extends CrudRepository<WebBoardReply, Long> {
    List<WebBoardReply> findAllByBoardOrderByUpdatedateDesc(WebBoard board);
}
