package project.suhbuway.mvc.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import project.suhbuway.mvc.dto.NewsBoard;

public interface NewsBoardRepository extends CrudRepository<NewsBoard, Long> {
	List<NewsBoard> findByTitleContaining(String title);
	Page<NewsBoard> findByNewsIdGreaterThanOrderByNewsIdDesc(Long newsId, Pageable paging);
}
