package project.suhbuway.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import project.suhbuway.mvc.dao.NewsBoardRepository;
import project.suhbuway.mvc.dto.NewsBoard;
import project.suhbuway.mvc.scheduler.CrollingScheduler;


@Controller
public class HomeController {
	@Autowired
	NewsBoardRepository rep;
	
	@Autowired
	CrollingScheduler scheduler;
	
	@RequestMapping("/")
	@ResponseBody
	@CrossOrigin
	public Map<String, Object> index(@RequestParam(defaultValue = "1") int page) {
		Pageable pageable = PageRequest.of(page-1 , 10);
		
		Page<NewsBoard> p =	rep.findByNewsIdGreaterThanOrderByNewsIdDesc(0, pageable);
		int noticeCount = scheduler.getNoticeCount();
		
		System.out.println("공지사항 노출수 : "+ noticeCount);
		System.out.println("size : "+ p.getSize());
		System.out.println("getTotalPages : "+ p.getTotalPages());
		System.out.println("getTotalElements : "+ p.getTotalElements());
		System.out.println("nextPageable : "+ p.nextPageable());
		System.out.println("previousPageable : "+ p.previousPageable());
		
		System.out.println("----------------------");
        //List<Board> list = p.getContent();
        //p.getContent().forEach(b->System.out.println(b));
        
        Map<String, Object> result = new HashMap<>();
        result.put("noticeCount", noticeCount);
        result.put("size", p.getSize());
        result.put("getTotalPages", p.getTotalPages());
        result.put("getTotalElements", p.getTotalElements());
        result.put("previousPageable", p.previousPageable());
        result.put("nextPageable", p.nextPageable());
        result.put("newsBoard", p.getContent());
		return result;    
	}
	
	@RequestMapping("/view")
	@ResponseBody
	@CrossOrigin
	public NewsBoard view(@RequestParam(defaultValue = "1") int pageView) {
		NewsBoard list = rep.findByNewsId(pageView); 
		return list;    
	}
	
}
