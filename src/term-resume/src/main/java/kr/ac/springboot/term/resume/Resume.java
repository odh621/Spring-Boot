package kr.ac.springboot.term.resume;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.resumereplay.ResumeReply;

@Entity
@Table(name = "tbl_resume")
public class Resume {

    public Resume() {
    }

    public Resume(Integer studentno, String name, String oi, String email, String intro) {
        this.studentno = studentno;
        this.name = name;
        this.oi = oi;
        this.email = email;
        this.intro = intro;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;

    private Integer studentno;

    private String name;

    private String oi;

    private String email;

    private String intro;

    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
    private List<Experience> experience;

    @JsonIgnore
    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
    private List<ResumeReply> resumereply;

    public Long getBno() {
        return bno;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public Integer getStudentno() {
        return studentno;
    }

    public void setStudentno(Integer studentno) {
        this.studentno = studentno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOi() {
        return oi;
    }

    public void setOi(String oi) {
        this.oi = oi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Resume [bno=");
        builder.append(bno);
        builder.append(", studentno=");
        builder.append(studentno);
        builder.append(", name=");
        builder.append(name);
        builder.append(", oi=");
        builder.append(oi);
        builder.append(", email=");
        builder.append(email);
        builder.append(", intro=");
        builder.append(intro);
        builder.append(", regdate=");
        builder.append(regdate);
        builder.append(", updatedate=");
        builder.append(updatedate);
        builder.append("]");
        return builder.toString();
    }

}
