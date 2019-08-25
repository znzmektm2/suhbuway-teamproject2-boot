package project.suhbuway.mvc.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import project.suhbuway.mvc.dao.NewsBoardRepository;
import project.suhbuway.mvc.dto.NewsBoard;

@Service
@EnableTransactionManagement
public class NewsBoardService {
	
	@Autowired
	NewsBoardRepository rep;
	
	@Transactional
	public int updateNewsBoard() {
		int noticeCount = 0;
		
		rep.deleteAll(); //전체삭제
		
		try {
			//전체 페이지 수 구하기
			String url1 = "http://subway.co.kr/newsList";
			Document doc1 = Jsoup.connect(url1).get();
			String nextBtn = doc1.select(".arr.next").toString();
			int index1 = nextBtn.lastIndexOf("paging.next(");
			String txt = nextBtn.substring(index1);
			int index2 = txt.indexOf(")");
			int AllPagingNumber = Integer.parseInt(txt.substring(12, index2));

			System.out.println("AllPagingNumber : " + AllPagingNumber);
			System.out.println("-----------------");

			//공지사항 노출 수, 제목, 날짜 구하기
			Elements tbody = doc1.select("tbody");
			for(Element el : tbody.select(".notice")) {
				noticeCount++;
				String noticeTitle = el.select(".title a").text();
				String noticeDate = el.select(".date").text();

				System.out.println(noticeTitle + " " + noticeDate);
				System.out.println("noticeCount : " + noticeCount);
			}
			System.out.println("-----------------");

			//전체 게시물 구하기
			String url2 = null;
			Document doc2 = null;
			for(int i=1; i<=AllPagingNumber; i++) {

				url2 = "http://subway.co.kr/newsList?page="+i;
				doc2 = Jsoup.connect(url2).get();

				Elements tbodys = doc2.select("tbody");
				System.out.println("-----------------전체 게시물" + i);
				for(Element el : tbodys.select("tr:not(.notice)")) {
					//게시물 번호
					int newsId = Integer.parseInt(el.select(".num").text());
					//게시물 제목
					String title = el.select(".title a").text();
					//게시물 등록일
					String regDate = el.select(".date").text();

					String aLink = el.select(".title a").toString();
					int index3 = aLink.indexOf("view.view(");
					String txt1 = aLink.substring(index3);
					int index4 = txt1.indexOf(")");
					int viewNum = Integer.parseInt(txt1.substring(10, index4));
					String ViewUrl = "http://subway.co.kr/newsView?noticeIdx="+viewNum+"&query=page%3D"+i+"%26subject%3D";
					Document doc3 = Jsoup.connect(ViewUrl).get();
					// 게시물 내용
					String content = doc3.select(".news_view_conten").html();
					System.out.println("ViewUrl : " + ViewUrl);
					System.out.println("viewNum : " + viewNum);
					System.out.println("번호 : " + newsId + " 제목 : " + title + " 날짜 : " + regDate);
					System.out.println("content-------------------------------------------");
					rep.save(new NewsBoard(newsId, title, regDate, content));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return noticeCount;
	}
}
