package project.suhbuway.mvc.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
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
	 private Long newsId;
	 private String title;
	 private String regDate;
	 private String content;
	 private String img;
	 private boolean state;
}





