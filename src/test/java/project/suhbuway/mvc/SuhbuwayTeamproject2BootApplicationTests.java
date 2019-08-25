package project.suhbuway.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project.suhbuway.mvc.dao.NewsBoardRepository;
import project.suhbuway.mvc.dto.NewsBoard;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuhbuwayTeamproject2BootApplicationTests {
	
	@Autowired
	private NewsBoardRepository rep;
	
	@Test
	public void insert() {
		//rep.save(new NewsBoard(i, "제목"+i, "날짜 - "+i, "content"+i, "imgUrl"+i, false));
	}

}
