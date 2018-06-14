package kr.ac.ks.boardreplay;

import kr.ac.ks.board.WebBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/replies/*")
public class WebBoardReplyController {

    @Autowired
    private WebBoardReplyRepository replyRepo;

    @Autowired
    private WebBoardReplyRepository boardRepo;

    @GetMapping("/{bno}")
    public ResponseEntity<List<WebBoardReply>> getReplies(@PathVariable("bno") Long bno) {

        WebBoard board = new WebBoard();
        board.setBno(bno);
        return new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/{bno}")
    public ResponseEntity<List<WebBoardReply>> addReply(@PathVariable("bno") Long bno, @RequestBody WebBoardReply reply) {

        WebBoard board = new WebBoard();
        board.setBno(bno);

        reply.setBoard(board);

        replyRepo.save(reply);

        return new ResponseEntity<>(getListByBoard(board), HttpStatus.CREATED);

    }

    @Transactional
    @DeleteMapping("/{bno}/{rno}")
    public ResponseEntity<List<WebBoardReply>> remove(
            @PathVariable("bno") Long bno,
            @PathVariable("rno") Long rno) {

        replyRepo.deleteById(rno);

        WebBoard board = new WebBoard();
        board.setBno(bno);

        return new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);

    }


    @Transactional
    @PutMapping("/{bno}")
    public ResponseEntity<List<WebBoardReply>> modify(@PathVariable("bno") Long bno, @RequestBody WebBoardReply reply) {

        replyRepo.findById(reply.getRno()).ifPresent(origin -> {
            origin.setReplyText(reply.getReplyText());
            replyRepo.save(origin);
        });

        WebBoard board = new WebBoard();
        board.setBno(bno);

        return new ResponseEntity<>(getListByBoard(board), HttpStatus.OK);
    }

    private List<WebBoardReply> getListByBoard(WebBoard board) throws RuntimeException {
        return replyRepo.findAllByBoardOrderByUpdatedateDesc(board);
    }
}
