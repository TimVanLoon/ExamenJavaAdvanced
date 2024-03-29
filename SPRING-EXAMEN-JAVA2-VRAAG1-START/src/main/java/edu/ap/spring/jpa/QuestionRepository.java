package edu.ap.spring.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	Question findByQuestion(String question);

	List<Question> findListByQuestion(String question);
	
	List<Question> findByAnswer(String answer);
}

