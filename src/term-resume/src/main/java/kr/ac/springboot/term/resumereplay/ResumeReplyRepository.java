package kr.ac.springboot.term.resumereplay;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.ac.springboot.term.resume.Resume;

public interface ResumeReplyRepository extends CrudRepository<ResumeReply, Long> {
    List<ResumeReply> findAllByResumeOrderByUpdatedateDesc(Resume resume);
}
