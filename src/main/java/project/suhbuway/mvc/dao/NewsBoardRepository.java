package project.suhbuway.mvc.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import project.suhbuway.mvc.dto.NewsBoard;

public interface NewsBoardRepository extends CrudRepository<NewsBoard, Integer> {
	List<NewsBoard> findByTitleContaining(String title);
	NewsBoard findByNewsId(Integer newsId);
	Page<NewsBoard> findByNewsIdGreaterThanOrderByNewsIdDesc(Integer newsId, Pageable paging);
}
