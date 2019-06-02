package kr.ac.springboot.term.experience;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
@Table(name = "tbl_experience")
public class Experience {
	
		public Experience() {
 	
 		}
	
	
	 	public Experience(String term, String title, String position, String content, Resume resume) {
	 		this.term = term;
	 		this.title = title;
	 		this.position = position;
	 		this.content = content;
	 		this.resume = resume; 
	 	}

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long bno;
	 	
	 	private String term;
	 	
	    private String title;

	    private String position;

	    private String content;

	    @CreationTimestamp
	    private Timestamp regdate;

	    @UpdateTimestamp
	    private Timestamp updatedate;
	    
	    @JsonIgnore
	    @ManyToOne(fetch=FetchType.LAZY)
	    private Resume resume;

		public Long getBno() {
			return bno;
		}

		public void setBno(Long bno) {
			this.bno = bno;
		}


		public String getTerm() {
			return term;
		}


		public void setTerm(String term) {
			this.term = term;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getPosition() {
			return position;
		}


		public void setPosition(String position) {
			this.position = position;
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


		public Resume getResume() {
			return resume;
		}


		public void setResume(Resume resume) {
			this.resume = resume;
		}


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Experience [bno=");
			builder.append(bno);
			builder.append(", term=");
			builder.append(term);
			builder.append(", title=");
			builder.append(title);
			builder.append(", position=");
			builder.append(position);
			builder.append(", content=");
			builder.append(content);
			builder.append(", regdate=");
			builder.append(regdate);
			builder.append(", updatedate=");
			builder.append(updatedate);
			builder.append(", resume=");
			builder.append(resume);
			builder.append("]");
			return builder.toString();
		}
   
	    
}
