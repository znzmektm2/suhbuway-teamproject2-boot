package project.suhbuway.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.suhbuway.mvc.dao.NewsBoardRepository;
import project.suhbuway.mvc.dto.NewsBoard;


@Controller
public class HomeController {
	@Autowired
	NewsBoardRepository rep;
	
	@RequestMapping("/")
	public ModelAndView index() {
		Pageable page = PageRequest.of(1, 10);
        ModelAndView mv =new ModelAndView();
        mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/pagingTest")
	@ResponseBody
	@CrossOrigin
	public List<NewsBoard> test() {
		Pageable page = PageRequest.of(1, 10);
		
		Page<NewsBoard> p = rep.findByNewsIdGreaterThanOrderByNewsIdDesc(0L, page);
		System.out.println("size : "+ p.getSize());
		System.out.println("getTotalPages : "+ p.getTotalPages());
		System.out.println("getTotalElements : "+ p.getTotalElements());
		System.out.println("nextPageable : "+ p.nextPageable());
		System.out.println("previousPageable : "+ p.previousPageable());
		
		System.out.println("----------------------도착~~");
        List<NewsBoard> list = p.getContent();
		return list;
	}
}
