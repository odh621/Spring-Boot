package kr.ac.ks.board;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.ac.ks.boardreplay.WebBoardReply;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_webboards")
public class WebBoard {

    public WebBoard() {
    }

    public WebBoard(String title, String content, String writer) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;
    private String title;

    private String writer;

    private String content;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;

    @JsonIgnore
    @OneToMany(mappedBy="board", fetch=FetchType.LAZY)
    private List<WebBoardReply> replie;

    public Long getBno() {
        return bno;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

    public List<WebBoardReply> getReplie() {
        return replie;
    }

    public void setReplie(List<WebBoardReply> replie) {
        this.replie = replie;
    }

    @Override
    public String toString() {
        return "WebBoard [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content
                + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
    }


}
