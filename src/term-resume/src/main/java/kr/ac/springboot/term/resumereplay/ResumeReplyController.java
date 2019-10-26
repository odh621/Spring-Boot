package kr.ac.springboot.term.resumereplay;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.springboot.term.resume.Resume;

@RestController
@RequestMapping("/replies/")
public class ResumeReplyController {

    @Autowired
    private ResumeReplyRepository replyrepo;

    @GetMapping("/{bno}")
    public ResponseEntity<List<ResumeReply>> getReplies(@PathVariable("bno") Long bno) {

        Resume resume = new Resume();
        resume.setBno(bno);

        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);

    }

    @Transactional
    @PostMapping("/{bno}")
    public ResponseEntity<List<ResumeReply>> addReply(@PathVariable("bno") Long bno, @RequestBody ResumeReply reply) {

        Resume resume = new Resume();
        resume.setBno(bno);

        reply.setResume(resume);

        replyrepo.save(reply);

        return new ResponseEntity<>(getListByResume(resume), HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/{bno}/{rno}")
    public ResponseEntity<List<ResumeReply>> remove(
            @PathVariable("bno") Long bno,
            @PathVariable("rno") Long rno) {

        replyrepo.deleteById(rno);

        Resume resume = new Resume();
        resume.setBno(bno);

        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);

    }


    @Transactional
    @PutMapping("/{bno}")
    public ResponseEntity<List<ResumeReply>> modify(@PathVariable("bno") Long bno, @RequestBody ResumeReply reply) {

        replyrepo.findById(reply.getRno()).ifPresent(origin -> {
            origin.setReplyText(reply.getReplyText());
            origin.setReplyer(reply.getReplyer());
            replyrepo.save(origin);
        });

        Resume resume = new Resume();
        resume.setBno(bno);

        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);
    }

    private List<ResumeReply> getListByResume(Resume resume) throws RuntimeException {
        return replyrepo.findAllByResumeOrderByUpdatedateDesc(resume);
    }

}
