package kr.ac.springboot.term;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

import kr.ac.springboot.term.resumereplay.ResumeReply;
import kr.ac.springboot.term.resumereplay.ResumeReplyRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ResumeRepository repo;

    @Autowired
    private ExperienceRepository exrepo;

    @Autowired
    private ResumeReplyRepository replyrepo;

    Resume r = new Resume(2014958100, "Donghun Lim", "SW-LAB, SCIENCE OF SOFTWARE, UNIVERSITY OF KYUNGSUNG", "dongh9508@gmail.com", "뛰어난 개발자가 되기 위해 노력하며 항상 새로운 벽에 부딪히고 있는 소프트웨어학과 학생 개발자 임동훈입니다.");

    @Override
    public void run(ApplicationArguments args) {
        // 초기 데이터 입력
        repo.save(r);
        exrepo.save(new Experience("기간", "과제 제목", "내 역할", "과제 내용", r));
        replyrepo.save(new ResumeReply("(ex) 질문 내용", "(ex) 질문자", repo.findById(1L).orElse(null)));
    }
}
