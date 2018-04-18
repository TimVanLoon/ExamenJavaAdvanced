package edu.ap.spring.jpa;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.model.EightBall;
import edu.ap.spring.view.EventHandler;

@Aspect
@Component
public class AOPHandler {

	@Autowired
	EightBall eightBall;
	
	private QuestionRepository repository;
	
	@Autowired
	public void setQuestionRepository(QuestionRepository repository) {
		this.repository = repository;
	}

	 @Before("execution(* edu.ap.spring.jpa.QuestionRepository.save(..))")
	 public void checkBeforeSaveQuestion(JoinPoint joinPoint) throws Exception {
		 Question newQuestion = (Question)joinPoint.getArgs()[0];
		 List<Question> questions = repository.findListByQuestion(newQuestion.getQuestion());
		 
		 if(questions.size() > 0) {
			 System.out.println("Question exists : " + questions.get(0).getQuestion());
			 throw new Exception();
		 }
	 }
	 
	 
	
}
