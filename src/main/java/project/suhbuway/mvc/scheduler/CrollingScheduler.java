package project.suhbuway.mvc.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.Getter;
import project.suhbuway.mvc.service.NewsBoardService;

@Component
@EnableScheduling
@Getter
public class CrollingScheduler {
   
	@Autowired
	private NewsBoardService service;	
	private int noticeCount = 0;
	
	@Scheduled(fixedRate = 1000 * 60 * 60 * 24)
	public void scheduleCrolling() {
    	//noticeCount = service.updateNewsBoard();
   }
}