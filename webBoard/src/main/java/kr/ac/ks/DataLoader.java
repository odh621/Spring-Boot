package kr.ac.ks;

import java.util.stream.IntStream;

import kr.ac.ks.boardreplay.WebBoardReply;
import kr.ac.ks.boardreplay.WebBoardReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.ks.board.WebBoard;
import kr.ac.ks.board.WebBoardRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private WebBoardRepository boardRepository;

    @Autowired
    private WebBoardReplyRepository webBoardReplyRepository;

    @Override
    public void run(ApplicationArguments args) {
    	IntStream.range(1, 100).forEach(i -> boardRepository.save(new WebBoard("title"+i, "content"+i, "user"+(i%10))));
        IntStream.range(1, 100).forEach(i -> webBoardReplyRepository.save(new WebBoardReply("replyText"+i, "replyer"+i, boardRepository.findById((long)i).orElse(null))));
    }

}