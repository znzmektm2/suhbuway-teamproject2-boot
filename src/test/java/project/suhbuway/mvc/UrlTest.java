package project.suhbuway.mvc;

import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.suhbuway.mvc.dao.NewsBoardRepository;
import project.suhbuway.mvc.dto.NewsBoard;

public class UrlTest {
	
	@Test
	public void insert() {
		String content = "<tr class=\"notice\">\r\n" + 
				"						<!-- 공지사항일경우 notice 클래스 추가 -->\r\n" + 
				"						<td><div class=\"icon_notice\"></div></td>\r\n" + 
				"						<td>\r\n" + 
				"							<div class=\"title\">\r\n" + 
				"								<a href=\"/controller/board/newsView/1\" onclick=\"view.view(213);return false;\">써브웨이와 함께하는 Mnet ''쇼미더머니8\"</a>\r\n" + 
				"							</div>\r\n" + 
				"						</td>\r\n" + 
				"						<td><div></div></td>\r\n" + 
				"						<td><div class=\"date\">19.07.25</div></td>\r\n" + 
				"					</tr>";
		
		String lastPageNumber = content.substring(11, 17);
		System.out.println(lastPageNumber);
	}

	

}
