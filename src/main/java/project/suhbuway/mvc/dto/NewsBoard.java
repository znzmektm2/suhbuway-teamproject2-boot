package project.suhbuway.mvc.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //테이블생성
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewsBoard {
	@Id
	private int newsId;
	private String title;
	private String regDate;
	private String content;
 
}





